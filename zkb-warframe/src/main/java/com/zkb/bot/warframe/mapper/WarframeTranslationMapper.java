package com.zkb.bot.warframe.mapper;


import com.zkb.bot.warframe.domain.WarframeTranslation;

import java.util.List;

/**
 * WarframeTranslationMapper接口
 * Warframe中英文翻译
 *
 * @author KingPrimes
 * @date 2021-05-24
 */
public interface WarframeTranslationMapper {
    /**
     * 查询
     *
     * @param traId ID
     * @return 结果
     */
    WarframeTranslation selectWarframeTranslationById(Long traId);


    /**
     * 根据英文匹配中文
     *
     * @param us_en 英文
     * @return 结果
     */
    String enToZh(String us_en);

    /**
     * 中文匹配 英文
     *
     * @param cn_zh 中文
     * @return 结果
     */
    String zhToEn(String cn_zh);

    /**
     * 中英文模糊翻译
     *
     * @param enOrzh 数据
     * @return 结果
     */
    WarframeTranslation enOrzh(String enOrzh);

    /**
     * 模糊搜索英文
     *
     * @param key 数据
     * @return 结果
     */
    List<WarframeTranslation> zhToEnList(String key);

    /**
     * 模糊搜索中文
     *
     * @param key 数据
     * @return 结果
     */
    List<WarframeTranslation> enToZhList(String key);

    /**
     * 模糊搜索中英文匹配值
     *
     * @param key 值
     * @return 结果
     */
    List<WarframeTranslation> enAndZhToList(String key);


    /**
     * 查询【请填写功能名称】列表
     *
     * @param warframeTranslation 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<WarframeTranslation> selectWarframeTranslationList(WarframeTranslation warframeTranslation);

    /**
     * 新增【请填写功能名称】
     *
     * @param warframeTranslation 【请填写功能名称】
     * @return 结果
     */
    int insertWarframeTranslation(WarframeTranslation warframeTranslation);

    /**
     * 批量添加翻译词典，更新
     *
     * @param list 数据
     * @return 结果
     */
    int insertWarframeTranslationList(List<WarframeTranslation> list);

    /**
     * 修改【请填写功能名称】
     *
     * @param warframeTranslation 【请填写功能名称】
     * @return 结果
     */
    int updateWarframeTranslation(WarframeTranslation warframeTranslation);

    /**
     * 删除【请填写功能名称】
     *
     * @param traId 【请填写功能名称】ID
     * @return 结果
     */
    int deleteWarframeTranslationById(Long traId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param traIds 需要删除的数据ID
     * @return 结果
     */
    int deleteWarframeTranslationByIds(Long[] traIds);
}
