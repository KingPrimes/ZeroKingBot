package com.zkb.bot.warframe.service.impl;


import com.zkb.bot.warframe.domain.WarframeAlias;
import com.zkb.bot.warframe.mapper.WarframeAliasMapper;
import com.zkb.bot.warframe.service.IWarframeAliasService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Warframe Alias Service业务层处理
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
@Service
public class WarframeAliasServiceImpl implements IWarframeAliasService {
    @Resource
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
