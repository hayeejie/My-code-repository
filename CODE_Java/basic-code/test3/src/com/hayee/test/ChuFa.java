package com.hayee.test;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/4 23:08
 */
public class ChuFa {
    public static void main(String[] args) {
        /*
        给定两个整数（都是正数，不超出int范围），求出商和余数。
        不使用乘法除法和%运算符
         */
        int num1 = 4999;
        int num2 = 12;
        int cout = 0;

        //求商和余，当循环结束，cout为商，num1为余
        while (num1 >= num2){
            num1 -= num2;
            cout++;
        }

        System.out.println("商为"+cout);
        System.out.println("余为"+num1);


    }
}
