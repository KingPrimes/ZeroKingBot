package com.zkb.common.utils;

import java.util.List;

public class ListUtils {
    /**
     * 判断两个集合的值是否相同
     * 自己写的类,必须重写equals
     *
     * @param a 左右即可
     * @param b 左右即可
     * @return 相同true 反之false
     */
    public static <T> boolean equals(List<T> a, List<T> b) {
        if (a == b)
            return true;
        if (a.size() != b.size())
            return false;
        int n = a.size();
        int i = 0;
        while (n-- != 0) {
            if (!a.get(i).equals(b.get(i)))
                return false;
            i++;
        }
        return false;
    }

}
