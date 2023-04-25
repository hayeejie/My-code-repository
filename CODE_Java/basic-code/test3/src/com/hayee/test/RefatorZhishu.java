package com.hayee.test;

/**
 * Hard learning
 * 优化的求质数算法
 * @author hayeejie
 * @date 2023/4/5 16:14
 */
public class RefatorZhishu {
    public static void main(String[] args) {
        int number = 71;
        //如果这个范围之内，所有的数字都不能被number整除
        //那么number就一定是一个质数
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println(number + "是质数");
        } else {
            System.out.println(number + "不是质数");
        }
    }
}
