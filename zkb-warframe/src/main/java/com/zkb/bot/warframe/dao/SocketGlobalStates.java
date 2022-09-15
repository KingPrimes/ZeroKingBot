package com.zkb.bot.warframe.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class SocketGlobalStates {
    @JsonProperty("event")
    private String event;
    @JsonProperty("packet")
    private Packet packet;
    @JsonProperty("status")
    private int status;
    public SocketGlobalStates() {
    }
    public SocketGlobalStates(String event, Packet packet, int status) {
        this.event = event;
        this.packet = packet;
        this.status = status;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("event", event)
                .append("packet", packet)
                .append("status", status)
                .toString();
    }

    public static class Packet {
        @JsonProperty("language")
        private String language;
        @JsonProperty("platform")
        private String platform;
        @JsonProperty("data")
        private GlobalStates data;
        public Packet() {
        }
        public Packet(String language, String platform, GlobalStates data) {
            this.language = language;
            this.platform = platform;
            this.data = data;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public GlobalStates getData() {
            return data;
        }

        public void setData(GlobalStates data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("language", language)
                    .append("platform", platform)
                    .append("data", data)
                    .toString();
        }

    }

}


