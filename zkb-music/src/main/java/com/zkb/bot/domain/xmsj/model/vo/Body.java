package com.zkb.bot.domain.xmsj.model.vo;

import com.zkb.bot.enums.MusicTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Body {
    //类型 qq 163 虾米等
    String type;
    //html地址
    String link;
    //歌曲ID
    String songid;
    //歌曲名称
    String title;
    //作者名称
    String author;
    //歌词
    //String lrc;
    //歌曲播放地址
    String url;
    //封面地址
    String pic;
    //类型
    MusicTypeEnum me;

    public MusicTypeEnum getMe() {
        return me;
    }

    public void setMe(MusicTypeEnum me) {
        this.me = me;
    }

    /**
     * get 类型 qq 163 虾米等
     *
     * @return type 类型 qq 163 虾米等
     */
    public String getType() {
        return this.type;
    }

    /**
     * set 类型 qq 163 虾米等
     *
     * @param type 类型 qq 163 虾米等
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * get html地址
     *
     * @return link html地址
     */
    public String getLink() {
        return this.link;
    }

    /**
     * set html地址
     *
     * @param link html地址
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * get 歌曲ID
     *
     * @return songid 歌曲ID
     */
    public String getSongid() {
        return this.songid;
    }

    /**
     * set 歌曲ID
     *
     * @param songid 歌曲ID
     */
    public void setSongid(String songid) {
        this.songid = songid;
    }

    /**
     * get 歌曲名称
     *
     * @return title 歌曲名称
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * set 歌曲名称
     *
     * @param title 歌曲名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get 作者名称
     *
     * @return author 作者名称
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * set 作者名称
     *
     * @param author 作者名称
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * get 歌词
     *
     * @return lrc 歌词
     */
    /*public String getLrc() {
        return this.lrc;
    }*/

    /**
     * set 歌词
     *
     * @param lrc 歌词
     */
   /* public void setLrc(String lrc) {
        this.lrc = lrc;
    }
*/

    /**
     * get 歌曲播放地址
     *
     * @return url 歌曲播放地址
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * set 歌曲播放地址
     *
     * @param url 歌曲播放地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * get 封面地址
     *
     * @return pic 封面地址
     */
    public String getPic() {
        return this.pic;
    }

    /**
     * set 封面地址
     *
     * @param pic 封面地址
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("type", type)
                .append("link", link)
                .append("songid", songid)
                .append("title", title)
                .append("author", author)
                //.append("lrc", lrc)
                .append("url", url)
                .append("pic", pic)
                .toString();
    }
}
