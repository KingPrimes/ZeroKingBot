package com.zkb.bot.warframe.service;


import com.zkb.bot.warframe.domain.WarframeTranslation;

import java.util.List;

/**
 * IWarframeTranslationService接口
 * 中英文翻译
 *
 * @author KingPrimes
 * @Date 2021-05-24
 */
public interface IWarframeTranslationService {
    /**
     * 根据Id查询
     *
     * @param traId ID
     * @return 结果
     */
    WarframeTranslation selectWarframeTranslationById(Long traId);

    /**
     * 根据英文匹配中文
     *
     * @param translation 数据
     * @return 结果
     */
    String enToZh(String translation);

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
    String enOrzh(String enOrzh);

    /**
     * 模糊搜索英文
     *
     * @param key 数据
     * @return 结果
     */
    List<String> zhToEnList(String key);

    /**
     * 模糊搜索中文
     *
     * @param key 数据
     * @return 结果
     */
    List<String> enToZhList(String key);

    /**
     * 模糊搜索中英文匹配值
     *
     * @param key 值
     * @return 结果
     */
    List<WarframeTranslation> enAndZhToList(String key);

    /**
     * 查询列表
     *
     * @param warframeTranslation 条件
     * @return 集合
     */
    List<WarframeTranslation> selectWarframeTranslationList(WarframeTranslation warframeTranslation);

    /**
     * 新增
     *
     * @param warframeTranslation 数据
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
     * 修改
     *
     * @param warframeTranslation 数据
     * @return 结果
     */
    int updateWarframeTranslation(WarframeTranslation warframeTranslation);

    /**
     * 批量删除
     *
     * @param traIds 需要删除的ID
     * @return 结果
     */
    int deleteWarframeTranslationByIds(Long[] traIds);

    /**
     * 删除信息
     *
     * @param traId ID
     * @return 结果
     */
    int deleteWarframeTranslationById(Long traId);
}
