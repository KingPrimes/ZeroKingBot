package com.zkb.common.utils.update;

import com.zkb.common.utils.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class UpdateJar implements ApplicationContextAware {

    private ApplicationContext context;

    Logger log = LoggerFactory.getLogger(UpdateJar.class);

    /**
     * 结束进程并更新Jar文件 保留备份
     * @param fileName 文件名称
     */
    public void restart(String fileName) {
        String path = System.getProperty("user.dir");
        try {
            File backup = new File(System.getProperty("user.dir")+"\\backup");
            if(!backup.exists()){
                backup.mkdirs();
            }
            File run = new File(System.getProperty("user.dir") + "\\run.bat");
            FileWriter runWriter = new FileWriter(run);
            runWriter.write("java -jar "+fileName+"\nexit");
            runWriter.close();

            File updata = new File(System.getProperty("user.dir") + "\\updata.bat");
            FileWriter writer = new FileWriter(updata);
            StringBuilder builder = new StringBuilder();
            builder.append("@echo off ")
                    .append("@ping 127.0.0.1 -n 8 & copy /Y .\\")
                    .append(fileName)
                    .append(" .\\backup\\baka_")
                    .append(DateUtils.getDate())
                    .append("_")
                    .append(fileName)
                    .append(" & xcopy /s/e/y .\\tmp  .\\")
                    .append(fileName)
                    .append(" & .\\run.bat")
            ;
            writer.write(builder.toString());
            writer.close();
            Runtime.getRuntime().exec("cmd /k start " + path + "\\updata.bat");
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        int exitCode = SpringApplication.exit(context, () -> 0);
        System.exit(exitCode);
    }

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
