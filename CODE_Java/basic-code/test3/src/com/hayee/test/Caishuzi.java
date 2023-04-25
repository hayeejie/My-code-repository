package com.hayee.test;

import java.util.Random;
import java.util.Scanner;

/**
 * Hard learning
 * 程序随机生成一个数字，利用程序实现猜数字
 * @author hayeejie
 * @date 2023/4/5 16:57
 */
public class Caishuzi {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(100)+1;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个数字：");
            int x = sc.nextInt();
            if (x < num) {
                System.out.println("小了");
            } else if (x > num) {
                System.out.println("大了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }

    }
}
