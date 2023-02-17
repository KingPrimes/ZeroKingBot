package com.zkb.bot.domain.xmsj.model.vo;

import com.zkb.bot.enums.MusicTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class ResultSets {

    List<R> rList = new ArrayList<>();

    public static ResultSets builder(){
        return new ResultSets();
    }

    public ResultSets add(int index, String title, String author, MusicTypeEnum me){
        this.rList.add(new R(index, title, author,me));
        return this;
    }

    public String build(){
        StringBuilder str = new StringBuilder();
        str.append("为您查询到以下歌曲信息:\n");
        if(this.rList.size()!=0){
            for (R r : this.rList) {
                str.append(r.index)
                        .append(":")
                        .append(r.title)
                        .append(" - ")
                        .append(r.author)
                        .append("\n");
            }
            str.append("请发送点歌+编号");
            return str.toString();
        }
        return "";
    }

    static class R{
        int index;
        String title;

        String author;

        MusicTypeEnum me;


        public R(int index, String title, String author, MusicTypeEnum me) {
            this.index = index;
            this.title = title;
            this.author = author;
            this.me = me;
        }

        public MusicTypeEnum getMe() {
            return me;
        }

        public void setMe(MusicTypeEnum me) {
            this.me = me;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
