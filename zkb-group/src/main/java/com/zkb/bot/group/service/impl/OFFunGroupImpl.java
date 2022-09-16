package com.zkb.bot.group.service.impl;


import com.zkb.bot.group.domain.OFFunGroup;
import com.zkb.bot.group.mapper.OFFunGroupMapper;
import com.zkb.bot.group.service.IOFFunGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OFFunGroupImpl implements IOFFunGroupService {

 @Resource
    private OFFunGroupMapper of;

    @Override
    public List<OFFunGroup> selectOFFunGroupList(OFFunGroup group) {
        return of.selectOFFunGroupList(group);
    }

    @Override
    public OFFunGroup selectOFFunGroupById(Integer group) {
        return of.selectOFFunGroupById(group);
    }

    @Override
    public int insertOFFunGroup(OFFunGroup group) {
        return of.insertOFFunGroup(group);
    }

    @Override
    public int updateOFFunGroup(OFFunGroup group) {
        return of.updateOFFunGroup(group);
    }

    @Override
    public int deleteOFFunGroupById(Integer group) {
        return of.deleteOFFunGroupById(group);
    }
}
