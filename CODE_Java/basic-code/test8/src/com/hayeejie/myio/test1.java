package com.hayeejie.myio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name Learn-basic-code
 * @date 2023/6/28 16:08
 */
public class test1 {
    public static void main(String[] args) throws IOException {
        /*
            制造假数据：
                获取姓氏：https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0
                获取男生名字：http://www.haoming8.cn/baobao/10881.html
                获取女生姓名：http://www.haoming8.cn/baobao/7641.html
        */
        //1.定义变量记录地址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        //2.爬取数据，把网址上的内容拼接成一个字符串
        String familyNameStr = webWorm(familyNameNet);
        String boyNameStr = webWorm(boyNameNet);
        String girlNameStr = webWorm(girlNameNet);

        //3.利用正则表达式获取数据
        ArrayList<String> familyNameTempList = getData(familyNameStr, "(.{4})(，|。)", 1);
        ArrayList<String> boyNameTempList = getData(boyNameStr, "([\\u4e00-\\u9fa5]{2})(、|。)", 1);
        ArrayList<String> girlNameTempList = getData(girlNameStr, "(.. ){4}..", 0);

        //4.处理数据
        ArrayList<String> familyNameList = new ArrayList<>();
        //将每个姓氏拿出来添加到新的集合中
        for (String str : familyNameTempList) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                familyNameList.add(c + "");
            }
        }

        //去重 Hashset集合 或者 ArrayList集合判断不存在再添加
        ArrayList<String> boyNameList = new ArrayList<>();
        for (String str : boyNameTempList) {
            if (!boyNameList.contains(str)) {
                boyNameList.add(str);
            }
        }

        //用空格切割，取出每个元素，得到每个女生的名字
        ArrayList<String> girlNameList = new ArrayList<>();
        for (String str : girlNameTempList) {
            String[] arr = str.split(" ");
            girlNameList.addAll(Arrays.asList(arr));
        }

        //5.生成数据
        ArrayList<String> nameInfos = getInfos(familyNameList, boyNameList, girlNameList, 50, 70);

        //6.写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("test8\\src\\com\\hayeejie\\myio\\name.txt"));
        for (String nameInfo : nameInfos) {
            bw.write(nameInfo);
            bw.newLine();
        }
        bw.close();


    }

    public static ArrayList<String> getInfos(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, int boyCount, int girlCount) {
        //1.生成男生不重复的名字
        HashSet<String> boyhs = new HashSet<>();
        while (boyhs.size() != boyCount) {
            //随机
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boyhs.add(familyNameList.get(0) + boyNameList.get(0));
        }

        //2.生成女生不重复的名字
        HashSet<String> girlhs = new HashSet<>();

        while (girlhs.size() != girlCount) {
            //随机
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girlhs.add(familyNameList.get(0) + girlNameList.get(0));
        }

        //3.张三-男-25
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();

        //男生
        for (String boyName : boyhs) {
            int age = r.nextInt(10) + 18;
            list.add(boyName + "-男-" + age);
        }

        //女生
        for (String girlName : girlhs) {
            int age = r.nextInt(10) + 18;
            list.add(girlName + "-女-" + age);
        }


        return list;
    }


    public static ArrayList<String> getData(String str, String regex, int index) {
        //1.创建集合存储数据
        ArrayList<String> list = new ArrayList<>();
        //2.根据正则表达式获取数据
        Pattern pattern = Pattern.compile(regex);
        //3.根据pattern的规则，到str中获取数据
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group(index));
        }
        return list;
    }

    public static String webWorm(String net) throws IOException {
        //1.定义一个StringBuilder拼接字符串
        StringBuilder sb = new StringBuilder();
        //2.创建一个URL对象
        URL url = new URL(net);
        //3.连接上这个网址
        URLConnection conn = url.openConnection();
        //4.读取数据
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        //5.关流
        isr.close();
        //6.返回数据
        return sb.toString();
    }

}
