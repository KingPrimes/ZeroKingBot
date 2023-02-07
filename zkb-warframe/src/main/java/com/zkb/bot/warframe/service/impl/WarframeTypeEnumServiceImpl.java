package com.zkb.bot.warframe.service.impl;

import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.bot.warframe.domain.TypeEnum;
import com.zkb.bot.warframe.mapper.WarframeTypeEnumMapper;
import com.zkb.bot.warframe.service.IWarframeTypeEnumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarframeTypeEnumServiceImpl implements IWarframeTypeEnumService {

    private static final Logger log = LoggerFactory.getLogger(WarframeTypeEnumServiceImpl.class);

    @Autowired
    WarframeTypeEnumMapper typeEnumMapper;

    //初始化
    public void init(){
        log.info("开始初始化Warframe指令……");
        List<TypeEnum> tes = typeEnumMapper.selectWarframeTypeEnumList(null);

        if(tes==null || tes.size()==0 || tes.size()!=WarframeTypeEnum.values().length){
           if(tes!=null){
               Map<String,String> initMap = new HashMap<>();
               Map<String,String> sqlMap = new HashMap<>();

               for (WarframeTypeEnum value : WarframeTypeEnum.values()) {
                   initMap.put(value.name(), value.getType());
               }
               for (TypeEnum te : tes) {
                   sqlMap.put(te.getKey(),te.getValue());
               }

               Map<String, String> kMap = new HashMap<>(sqlMap);

               sqlMap.forEach((qk,qv)->{
                   initMap.forEach((k,v)->{
                       if(k.equals(qk)){
                           kMap.remove(qk);
                       }
                   });
               });

               kMap.forEach((k,v)->{
                   typeEnumMapper.daleteWarframeTypeEnum(k);
               });
           }

            for(WarframeTypeEnum key:WarframeTypeEnum.values()){
                if(WarframeTypeEnum.valueOf(key.name()).getType()!=null && WarframeTypeEnum.valueOf(key.name()).getType().trim().length()!=0 && !key.name().equals("REDIS_MISSION_KEY")){
                   TypeEnum typeEnum = new TypeEnum();
                   typeEnum.setKey(key.name());
                   typeEnum.setValue(key.getType());
                   typeEnumMapper.insertWarframeTypeEnum(typeEnum);
                }
            }
        }else{
            for(WarframeTypeEnum keyEnum: WarframeTypeEnum.values()){
                for(TypeEnum typeEnum:tes){
                    if(keyEnum.name().equals(typeEnum.getKey())){
                        keyEnum.setType(typeEnum.getValue());
                        break;
                    }
                }
            }
        }
        log.info("Warframe指令初始化完成……");
    }

    /**
     * 修改
     *
     * @param typeEnum 数据
     * @return 条数
     */
    @Override
    public int updateWarframeTypeEnum(TypeEnum typeEnum) {

        for (WarframeTypeEnum value : WarframeTypeEnum.values()) {
            if(value.name().equals(typeEnum.getKey())){
                value.setType(typeEnum.getValue());
            }
        }
        return typeEnumMapper.updateWarframeTypeEnum(typeEnum);
    }

    /**
     * 条件查询
     * @param typeEnum 条件
     * @return 具体数据
     */
    @Override
    public List<TypeEnum> selectWarframeTypeEnumList(TypeEnum typeEnum) {
        return typeEnumMapper.selectWarframeTypeEnumList(typeEnum);
    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    @Override
    public int daleteWarframeTypeEnum(String key) {
        return typeEnumMapper.daleteWarframeTypeEnum(key);
    }
}
