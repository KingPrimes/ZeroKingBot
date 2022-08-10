package com.twg.bot.group.service;


import com.twg.bot.group.domain.OFFunGroup;

import java.util.List;

public interface IOFFunGroupService {
    List<OFFunGroup> selectOFFunGroupList(OFFunGroup group);

    OFFunGroup selectOFFunGroupById(Integer group);

    int insertOFFunGroup(OFFunGroup group);

    int updateOFFunGroup(OFFunGroup group);

    int deleteOFFunGroupById(Integer group);
}
