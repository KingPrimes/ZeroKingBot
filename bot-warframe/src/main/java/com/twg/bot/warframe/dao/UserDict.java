package com.twg.bot.warframe.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class UserDict {

    @JsonProperty("continue")
    private Continue continueX;
    @JsonProperty("query")
    private Query query;

    @NoArgsConstructor
    @Data
    public static class Continue {
        @JsonProperty("rvcontinue")
        private String rvcontinue;
        @JsonProperty("continue")
        private String continueX;
    }

    @NoArgsConstructor
    @Data
    public static class Query {
        @JsonProperty("pages")
        private List<Pages> pages;

        @NoArgsConstructor
        @Data
        public static class Pages {
            @JsonProperty("pageid")
            private Integer pageid;
            @JsonProperty("ns")
            private Integer ns;
            @JsonProperty("title")
            private String title;
            @JsonProperty("revisions")
            private List<Revisions> revisions;

            @NoArgsConstructor
            @Data
            public static class Revisions {
                @JsonProperty("contentformat")
                private String contentformat;
                @JsonProperty("contentmodel")
                private String contentmodel;
                //中英词条
                @JsonProperty("content")
                private String content;
            }
        }
    }
}
