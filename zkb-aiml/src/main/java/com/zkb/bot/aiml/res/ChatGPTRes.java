package com.zkb.bot.aiml.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

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
