package com.zkb.bot.aiml.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * ChatGPT 返回消息
 */
@NoArgsConstructor
@Data
public class ChatGPTRes {

    @JsonProperty("id")
    private String id;
    @JsonProperty("object")
    private String object;
    @JsonProperty("created")
    private Integer created;
    @JsonProperty("model")
    private String model;
    @JsonProperty("usage")
    private Usage usage;
    @JsonProperty("choices")
    private List<Choices> choices;
    @JsonProperty("error")
    private Error error;

    @NoArgsConstructor
    @Data
    public static class Usage {
        @JsonProperty("prompt_tokens")
        private Integer promptTokens;
        @JsonProperty("completion_tokens")
        private Integer completionTokens;
        @JsonProperty("total_tokens")
        private Integer totalTokens;
    }

    @NoArgsConstructor
    @Data
    public static class Choices {
        @JsonProperty("message")
        private Message message;
        @JsonProperty("finish_reason")
        private String finishReason;
        @JsonProperty("index")
        private Integer index;

        @NoArgsConstructor
        @Data
        public static class Message {
            @JsonProperty("role")
            private String role;
            @JsonProperty("content")
            private String content;
        }
    }

    @NoArgsConstructor
    @Data
    public static class Error{
        @JsonProperty("message")
        private String message;
        @JsonProperty("type")
        private String type;
        @JsonProperty("param")
        private String param;
        @JsonProperty("code")
        private String code;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("message", message)
                    .append("type", type)
                    .append("param", param)
                    .append("code", code)
                    .toString();
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    public static ChatGPTRes error(String erroMsg){
        ChatGPTRes res =new ChatGPTRes();
        List<Choices> cho = new ArrayList<>();
        Choices.Message message = new Choices.Message();
        message.setRole("error");
        message.setContent(erroMsg);
        Choices ch = new Choices();
        ch.setMessage(message);
        ch.setIndex(0);
        ch.setFinishReason("stop");
        cho.add(ch);
        Usage us = new Usage();
        us.setPromptTokens(0);
        us.setCompletionTokens(0);
        us.setTotalTokens(0);
        res.setUsage(us);
        res.setChoices(cho);
        return res;
    }
}
