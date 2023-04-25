package com.hayee.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/4 23:40
 */
public class Squar2 {
    public static void main(String[] args) {
        /*
        键盘输入一个大于等于二的数x，计算并返回x的平方根
        结果保留整数部分，小数部分将被舍去。
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个大于等于2的整数：");
        int x = sc.nextInt();
        int count = 1;
        while (true){
            if (count * count > x) {
                System.out.println("平方根为"+(count - 1));
                break;
            } else if (count *count == x) {
                System.out.println("平方根为"+count);
                break;
            }
            count++;
        }

    }
}
