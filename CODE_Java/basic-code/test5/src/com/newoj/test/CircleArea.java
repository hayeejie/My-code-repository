package com.newoj.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/14 21:54
 */
public class CircleArea {
    public static void main(String[] args) {
        double Pi = 3.14159;
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        for (int j = 1; j <= i; j++) {
            double r = scanner.nextDouble();
            double area = Pi * r * r;
            System.out.printf("Case %d: %.3f\n",j,area);
        }
    }
}
