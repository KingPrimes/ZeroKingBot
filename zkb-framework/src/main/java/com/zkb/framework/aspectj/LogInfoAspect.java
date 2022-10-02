package com.zkb.framework.aspectj;

import com.alibaba.fastjson.JSONObject;
import com.zkb.common.annotation.LogInfo;
import com.zkb.common.enums.BusinessStatus;
import com.zkb.common.utils.ServletUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.framework.manager.AsyncManager;
import com.zkb.framework.manager.factory.AsyncFactory;
import com.zkb.system.domain.SysLogInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 日志记录
 */
@Aspect
@Component
public class LogInfoAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    long runTime;

    //配置切入点
    @Pointcut("@annotation(com.zkb.common.annotation.LogInfo)")
    public void logPointCut() {

    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
   /* @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, LogInfo controllerLog, Object jsonResult) {
        handleLog(joinPoint, controllerLog, null, jsonResult);
    }*/

    /**
     * 在函数执行时调用。获取函数执行所需的时间
     */
    @Around(value = "@annotation(controllerLog)")
    public Object doAround(ProceedingJoinPoint pjp, LogInfo controllerLog) {
        Object obj;
        try {
            long starTime = System.currentTimeMillis();
            obj = pjp.proceed();
            runTime = System.currentTimeMillis() - starTime;
            handleLog(pjp, controllerLog, null, "");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, LogInfo controllerLog, Exception e) {
        handleLog(joinPoint, controllerLog, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, LogInfo controllerLog, final Exception e, Object jsonResult) {
        try {

            // *========数据库日志=========*//
            SysLogInfo logInfo = new SysLogInfo();
            logInfo.setLogStatus(BusinessStatus.SUCCESS.ordinal());
            String url = ServletUtils.getRequest().getRequestURI();
            // 请求的地址
            switch (controllerLog.title()){
                case Warframe:
                    for(int i=0;i<4;i++){
                        url = url.substring(0,url.lastIndexOf("/"));
                    }
                    logInfo.setLogUrl(StringUtils.substring(url, 0, 255));
                    break;
                default:
                    logInfo.setLogUrl(StringUtils.substring(ServletUtils.getRequest().getRequestURI(), 0, 255));
                    break;
            }



            if (e != null) {
                logInfo.setLogStatus(BusinessStatus.FAIL.ordinal());
                logInfo.setLogErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            logInfo.setLogMethod(className + "." + methodName + "()");
            // 设置请求方式
            logInfo.setLogRequestMethod(ServletUtils.getRequest().getMethod());
            logInfo.setLogRunTime(runTime);
            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, controllerLog, logInfo, jsonResult);
            // 保存数据库
            AsyncManager.me().execute(AsyncFactory.recordOper(logInfo));
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param log     日志
     * @param logInfo 操作日志
     */
    public void getControllerMethodDescription(JoinPoint joinPoint, LogInfo log, SysLogInfo logInfo, Object jsonResult) {
        // 设置action动作
        logInfo.setLogBusinessType(log.businessType().ordinal());
        // 设置标题
        logInfo.setLogTitle(log.title().getType());
        // 执行的命令
        logInfo.setLogOrderType(log.orderType());
        // 请求的群组
        logInfo.setLogGroup(logInfo.getLogGroup());
        // 请求的用户
        logInfo.setLogUser(logInfo.getLogUser());


        // 是否需要保存request，参数和值
        if (log.isSaveRequestData()) {
            // 获取参数的信息，传入到数据库中。
            setRequestValue(joinPoint, logInfo);
        }
        // 是否需要保存response，参数和值
        if (log.isSaveResponseData() && StringUtils.isNotNull(jsonResult)) {
            logInfo.setLogResult(StringUtils.substring(JSONObject.toJSONString(jsonResult), 0, 2000));
        }
    }


    /**
     * 获取请求的参数，放到log中
     *
     * @param logInfo 操作日志
     */
    private void setRequestValue(JoinPoint joinPoint, SysLogInfo logInfo) {
        Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
        if (StringUtils.isNotEmpty(map)) {
            String params = JSONObject.toJSONString(map);
            logInfo.setLogParam(StringUtils.substring(params, 0, 2000));
        } else {
            Object args = joinPoint.getArgs();
            if (StringUtils.isNotNull(args)) {
                Signature signature = joinPoint.getSignature();
                MethodSignature methodSignature = (MethodSignature) signature;
                String[] parameterNames = methodSignature.getParameterNames();
                Object[] value = joinPoint.getArgs();
                for (int i = 0; i < parameterNames.length; i++) {
                   if(StringUtils.isNotNull(parameterNames[i]) && StringUtils.isNotNull(value[i])){
                       switch (parameterNames[i]) {
                           case "bot":
                               logInfo.setLogBot(Long.valueOf(value[i].toString()));
                               break;
                           case "group":
                               logInfo.setLogGroup(Long.valueOf(value[i].toString()));
                               break;
                           case "rawMsg":
                               logInfo.setLogRawMsg(value[i]);
                               break;
                           case "user":
                               logInfo.setLogUser(Long.valueOf(value[i].toString()));
                               break;
                           default:
                               break;
                       }
                   }
                }
                String params = argsArrayToString(value);
                logInfo.setLogParam(StringUtils.substring(params, 0, 2000));
            }
        }
    }


    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray) {
        StringBuilder params = new StringBuilder();
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (StringUtils.isNotNull(o)) {
                    try {
                        Object jsonObj = JSONObject.toJSONString(o);
                       if(!StringUtils.isNumber(jsonObj.toString())){
                           params
                                   .append(jsonObj.toString())
                                   .append(" ");
                       }
                    } catch (Exception ignored) {
                    }
                }
            }
        }
        return params.toString().trim();
    }


}
