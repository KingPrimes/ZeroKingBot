package com.zkb.bot.domain.xmsj.model.res;

import com.zkb.bot.domain.xmsj.model.vo.Body;
import com.zkb.bot.enums.MusicTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

    public void setDataType(MusicTypeEnum type) {
        if (data.size() != 0) {
            for (Body datum : data) {
                datum.setMe(type);
            }
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("data", data)
                .toString();
    }
}
