package com.zkb.bot.warframe.service.impl;

import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.bot.warframe.domain.TypeEnum;
import com.zkb.bot.warframe.mapper.WarframeTypeEnumMapper;
import com.zkb.bot.warframe.service.IWarframeTypeEnumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeTypeEnumServiceImpl implements IWarframeTypeEnumService {

    private static final Logger log = LoggerFactory.getLogger(WarframeTypeEnumServiceImpl.class);

    @Autowired
    WarframeTypeEnumMapper typeEnumMapper;

    //初始化
    public void init(){
        log.info("开始初始化Warframe指令……");
        List<TypeEnum> tes = typeEnumMapper.selectWarframeTypeEnumList(null);
        if(tes==null || tes.size()==0){
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

        return typeEnumMapper.updateWarframeTypeEnum(typeEnum);
    }
}
