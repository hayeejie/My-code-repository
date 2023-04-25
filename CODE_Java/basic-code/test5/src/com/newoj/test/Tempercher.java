package com.newoj.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/14 21:14
 */
public class Tempercher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()){
            double huaf = scanner.nextDouble();
            double shec = (huaf - 32) * 5 / 9;
            System.out.printf("%.2fF = %.2fC\n", huaf,shec);
        }
    }
}
