package com.zkb.bot.domain.xmsj.model;

import com.zkb.bot.domain.xmsj.model.vo.Body;
import com.zkb.bot.domain.xmsj.model.vo.ResultSets;

public interface IXmsjApi {

    /**
     * 根据歌曲名称查询歌曲
     * @param name 歌曲名称
     * @param groupID 群组ID
     * @param userID 用户ID
     * @return 结果集
     */
    ResultSets queryMusics(String name, Long groupID, Long userID);

    /**
     * 根据ID返回歌曲详情
     * @param groupID 群组ID
     * @param userID 用户ID
     * @param msg 消息
     * @return 歌曲详情
     */
    Body reqSong(Long groupID,Long userID,String msg) throws Exception;


}
