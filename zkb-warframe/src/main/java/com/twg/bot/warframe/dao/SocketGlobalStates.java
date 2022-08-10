package com.twg.bot.warframe.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SocketGlobalStates {
    @JsonProperty("event")
    private String event;
    @JsonProperty("packet")
    private Packet packet;
    @JsonProperty("status")
    private int status;

    @NoArgsConstructor
    @Data
    public static class Packet {
        @JsonProperty("language")
        private String language;
        @JsonProperty("platform")
        private String platform;
        @JsonProperty("data")
        private GlobalStates data;
    }
}
