package com.newoj.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/14 22:11
 */
public class ParallelogramPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int x = c1 - b1;
            int y = c2 - b2;
            int d1 = a1 + x;
            int d2 = a2 + y;
            System.out.printf("D(%d,%d)\n",d1,d2);
        }
    }
}
