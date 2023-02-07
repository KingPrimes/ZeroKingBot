package com.zkb.framework.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringToEnumConverterFactory implements ConverterFactory<String, EnumValue> {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends EnumValue> @NotNull Converter<String, T> getConverter(@NotNull Class<T> targetType) {
        return new StringToEnum(targetType);
    }

    private static class StringToEnum<T extends Enum<T> & EnumValue> implements Converter<String, T> {

        private final Class<T> enumType;

        StringToEnum(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(@NotNull String source) {
            source = source.trim();// 去除首尾空白字符
            return source.isEmpty() ? null : EnumValue.valueOf(this.enumType, source);
        }
    }
}
