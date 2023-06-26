package com.hayee.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name Learn-basic-code
 * @date 2023/6/12 17:11
 */
public class A02_MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("姓名", "张三");
        map.put("班级", "信科20-2");
        map.put("学号", "3102090712032");

        System.out.println(map);

    }
}
