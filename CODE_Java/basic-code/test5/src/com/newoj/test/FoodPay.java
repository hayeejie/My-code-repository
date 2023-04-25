package com.newoj.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/14 21:46
 */
public class FoodPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int s = scanner.nextInt();
            int price = (m + n + t)*s;
            System.out.println(price);
        }
    }
}
