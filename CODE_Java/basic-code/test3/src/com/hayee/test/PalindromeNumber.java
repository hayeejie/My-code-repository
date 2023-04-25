package com.hayee.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/4 22:48
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        /*
        输入一个整数x。
        如果x是一个回文整数，打印true，否则打印false。
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int x = sc.nextInt();
        //将x的值记录在temp中
        int temp = x;
        int num = 0;

        while (x != 0){
            //取得个位数
            int ge = x % 10;
            num = num * 10 + ge;
            x = x / 10;
        }

        //进行比较
        System.out.println(temp == num);


    }
}
