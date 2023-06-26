package com.hayee.file;

import java.io.File;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name Learn-basic-code
 * @date 2023/6/25 10:57
 */
public class FileGetcount {
    public static void main(String[] args) {
        File file = new File("E:\\github\\CODE_Java\\basic-code\\puzzlegame");
        long count = getcount(file);
        System.out.println(count);
    }

    public static long getcount(File path) {
        long len = 0;
        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    len += getcount(file);
                } else {
                    len += file.length();
                }
            }
        }
        return len;
    }
}
