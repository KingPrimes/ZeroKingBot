package com.twg.bot.warframe.service.impl;


import com.twg.bot.warframe.domain.WarframeAlias;
import com.twg.bot.warframe.mapper.WarframeAliasMapper;
import com.twg.bot.warframe.service.IWarframeAliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Warframe Alias Service业务层处理
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
@Service
public class WarframeAliasServiceImpl implements IWarframeAliasService {
    @Autowired
    private WarframeAliasMapper aliasMapper;

    @Override
    public WarframeAlias selectWarframeAliasById(Integer aliasId) {
        return aliasMapper.selectWarframeAliasById(aliasId);
    }

    @Override
    public List<WarframeAlias> selectWarframeAliasList(WarframeAlias warframeAlias) {
        return aliasMapper.selectWarframeAliasList(warframeAlias);
    }

    @Override
    public int insertWarframeAlias(WarframeAlias warframeAlias) {
        return aliasMapper.insertWarframeAlias(warframeAlias);
    }

    @Override
    public int updateWarframeAlias(WarframeAlias warframeAlias) {
        return aliasMapper.updateWarframeAlias(warframeAlias);
    }

    @Override
    public int deleteWarframeAliasById(Integer aliasId) {
        return aliasMapper.deleteWarframeAliasById(aliasId);
    }

    @Override
    public int deleteWarframeAliasByIds(Integer[] aliasIds) {
        return aliasMapper.deleteWarframeAliasByIds(aliasIds);
    }
}
