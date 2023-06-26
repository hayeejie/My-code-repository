package com.hayee.file;

import java.io.File;
import java.util.HashMap;


/**
 * Hard learning
 *
 * @author hayeejie
 * @name Learn-basic-code
 * @date 2023/6/25 11:09
 */
public class FileTypeGetCount {
    public static void main(String[] args) {
        File path = new File("E:\\github\\CODE_Java\\basic-code\\puzzlegame");
        HashMap<String, Integer> typeCount = getTypeCount(path);
        typeCount.forEach((key, value) -> System.out.println(key + " : " + value + "个"));
    }

    private static HashMap<String, Integer> getTypeCount(File path) {
        HashMap<String, Integer> hm = new HashMap<>();
        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    HashMap<String, Integer> sonHm = getTypeCount(file);
                    sonHm.forEach((key, value) -> {
                        if (hm.containsKey(key)) {
                            hm.put(key, hm.get(key) + value);
                        } else {
                            hm.put(key, value);
                        }
                    });
                } else {
                    String name = file.getName();
                    String[] split = name.split("\\.");
                    String type = split[split.length - 1];
                    if (hm.containsKey(type)) {
                        hm.put(type, hm.get(type) + 1);
                    } else {
                        hm.put(type, 1);
                    }
                }
            }
        }
        return hm;
    }
}
