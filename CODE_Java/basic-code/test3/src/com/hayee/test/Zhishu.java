package com.hayee.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/5 15:53
 */
public class Zhishu {
    public static void main(String[] args) {
        //键盘输入一个正整数，判断是否为质数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int number = scanner.nextInt();
        boolean flag = true;
        for (int i = 2; i <= number-1; i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("不是质数");
        }else System.out.println("是质数");

    }
}
