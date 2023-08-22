package com.zkb.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeUtils {
    /**
     * 监测某个程序是否在运行
     * @param name 进程名，前缀
     * @return true在运行
     */
    public static boolean exec(String name) {
        boolean filg = false;
        Runtime cmd = Runtime.getRuntime();
        try {
            Process process = cmd.exec("cmd /c Tasklist");

            BufferedReader str = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String oneLine;
            while ((oneLine = str.readLine()) != null) {
                oneLine = oneLine.toLowerCase();
                //这里不用完全匹配，而是匹配前缀，只要前缀满足要求即可
                if (oneLine.startsWith(name)) {
                    filg = true;
                    break;
                }
            }

            return filg;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
