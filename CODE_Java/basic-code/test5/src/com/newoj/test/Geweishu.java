package com.newoj.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/14 21:00
 */
public class Geweishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int num = sc.nextInt();
            int ge = num % 10;
            System.out.println(ge);
        }
    }
}
