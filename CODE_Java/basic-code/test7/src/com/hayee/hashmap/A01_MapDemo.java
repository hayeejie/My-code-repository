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
public class A01_MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("姓名", "张三");
        map.put("班级", "信科20-2");
        map.put("学号", "3102090712032");

        //第一种遍历方式
        /*//将键或者将值提出成单列集合（这里使用key）
        Set<String> strings = map.keySet();
        //增强for
        for (String s : strings) {
            System.out.println(s+" = "+map.get(s));
        }
        //迭代器
        Iterator<String> i = strings.iterator();
        while (i.hasNext()) {
            String next = i.next();
            System.out.println(next + " = " + map.get(next));
        }
        //lambda
        strings.forEach( s -> System.out.println(s +" = "+map.get(s)));*/


        //第二种遍历方式
       /* //直接提出成双列集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //增强for
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        //迭代器
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + " = " + next.getValue());
        }
        //lambda
        entries.forEach(stringStringEntry -> System.out.println(stringStringEntry.getKey()+" = "+stringStringEntry.getValue()));*/

        //第三种遍历方式，直接使用lambda
        map.forEach((String key, String value) -> System.out.println(key + " = " + value));


    }
}
