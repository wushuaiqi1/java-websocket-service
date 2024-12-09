package com.ws.utils;

import java.util.Objects;

public class NumberUtils {

    /**
     * @param value 参数
     * @return 数字类型
     */
    public static Integer StringToInteger(String value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return Integer.valueOf(value);
    }
}
