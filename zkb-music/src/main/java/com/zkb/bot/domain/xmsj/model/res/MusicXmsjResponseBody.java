package com.zkb.bot.domain.xmsj.model.res;

import com.zkb.bot.domain.xmsj.model.vo.Body;

import java.util.List;

/**
 * 结果实体类
 */
public class MusicXmsjResponseBody {

    List<Body> data;

    public List<Body> getData() {
        return this.data;
    }

    public void setData(List<Body> data) {
        this.data = data;
    }

}
