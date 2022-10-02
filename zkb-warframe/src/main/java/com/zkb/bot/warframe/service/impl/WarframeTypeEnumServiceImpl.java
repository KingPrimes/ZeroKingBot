package com.zkb.bot.warframe.service.impl;

import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.bot.warframe.domain.TypeEnum;
import com.zkb.bot.warframe.mapper.WarframeTypeEnumMapper;
import com.zkb.bot.warframe.service.IWarframeTypeEnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class WarframeTypeEnumServiceImpl implements IWarframeTypeEnumService {

    @Autowired
    WarframeTypeEnumMapper typeEnumMapper;

    //初始化
    @PostConstruct
    public void init(){
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
