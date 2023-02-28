package com.zkb.bot.domain;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.enums.ActionPathEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


public class OCRData {

    @JsonProperty("texts")
    private List<TextsDTO> texts;
    @JsonProperty("language")
    private String language;

    /**
     * 调用QQ的OCR图片识别接口
     *
     * @param imageFill 图片链接中的 fill参数
     * @param bot       bot
     * @return 具体数据
     */
    public static OCRData ocrImage(String imageFill, Bot bot) {
        JSONObject params = new JSONObject() {
            {
                this.put("image", imageFill);
            }
        };
        ActionPathEnum action = ActionPathEnum.OCR_IMAGE;
        return JSON.to(OCRData.class, bot.customRequest(action, params).getData().toString());
    }

    public List<TextsDTO> getTexts() {
        return texts;
    }

    public void setTexts(List<TextsDTO> texts) {
        this.texts = texts;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("texts", texts)
                .append("language", language)
                .toString();
    }

    public static class TextsDTO {
        @JsonProperty("text")
        private String text;
        @JsonProperty("confidence")
        private Integer confidence;
        @JsonProperty("coordinates")
        private List<CoordinatesDTO> coordinates;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getConfidence() {
            return confidence;
        }

        public void setConfidence(Integer confidence) {
            this.confidence = confidence;
        }

        public List<CoordinatesDTO> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<CoordinatesDTO> coordinates) {
            this.coordinates = coordinates;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                    .append("text", text)
                    .append("confidence", confidence)
                    .append("coordinates", coordinates)
                    .toString();
        }

        public static class CoordinatesDTO {
            @JsonProperty("x")
            private Integer x;
            @JsonProperty("y")
            private Integer y;

            public Integer getX() {
                return x;
            }

            public void setX(Integer x) {
                this.x = x;
            }

            public Integer getY() {
                return y;
            }

            public void setY(Integer y) {
                this.y = y;
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                        .append("x", x)
                        .append("y", y)
                        .toString();
            }
        }

    }

}
