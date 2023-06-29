package com.hayeejie.myio;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name Learn-basic-code
 * @date 2023/6/28 19:45
 */
public class RandomRollCall {
    public static void main(String[] args) throws IOException {
        //1.读取文件内容
        BufferedReader br = new BufferedReader(new FileReader("test8\\src\\com\\hayeejie\\myio\\name.txt"));
        //2.新建一个集合存入数据
        ArrayList<String> nameList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            nameList.add(line.split("-")[0]);
        }
        br.close();
        //3.打乱集合
        Collections.shuffle(nameList);
        //4.显示第一个学生名字
        System.out.println(nameList.get(0));
    }
}
