package com.zkb.bot.aiml.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zkb.bot.aiml.enums.ChatModelEnum;
import com.zkb.bot.aiml.enums.ChatRoleEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * ChatGPT 请求消息
 */
public class ChatGPTReq {

    @JsonProperty("model")
    private String model;
    @JsonProperty("messages")
    private List<Messages> messages = new ArrayList<>();

    /**
     * 构建消息体
     *
     * @return 新实例
     */
    public static ChatGPTReq builder() {
        return new ChatGPTReq();
    }

    public String getModel() {
        return model;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    /**
     * 设置模型
     *
     * @param model 模型
     */
    public void setMod(ChatModelEnum model) {
        this.model = model.desc();
    }

    /**
     * 添加消息
     *
     * @param role    角色
     * @param content 消息体
     */
    public void add(ChatRoleEnum role, String content) {
        this.messages.add(new Messages(role.desc(), content));
    }

    public ChatGPTReq build() {
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("model", model)
                .append("messages", messages)
                .toString();
    }

    //消息体
    public static class Messages {
        @JsonProperty("role")
        private String role;
        @JsonProperty("content")
        private String content;

        public Messages(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("role", role)
                    .append("content", content)
                    .toString();
        }
    }
}
