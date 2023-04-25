package com.hayee.test;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/4 23:29
 */
public class When7Pass {
    public static void main(String[] args) {
        /*
        逢七过
        从任意一个数字开始报数，当你要报的数字是包含7或者是7的倍数时都要说过
        要求：使用程序在控制台打印出1-100之间的满足逢七过的数据
         */

        for (int i = 1; i <= 100 ; i++) {
            if (i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0) {
                System.out.println("过");
                continue;
            }
            System.out.println(i);
        }


    }
}
