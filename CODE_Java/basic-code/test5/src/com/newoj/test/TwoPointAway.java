package com.newoj.test;

import java.util.Scanner;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/24 9:46
 */
public class TwoPointAway {
    public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                while (in.hasNextDouble()){
                    double x1 = in.nextDouble();
                    double y1 = in.nextDouble();
                    double x2 = in.nextDouble();
                    double y2 = in.nextDouble();
                    double x = x2 - x1;
                    double y = y2 - y1;
                    double result = twopoint(x,y);
                    System.out.printf("%.2f\n",result);
                }
    }
    public static double twopoint(double x,double y){
        double sum = x * x + y * y;
        return Math.sqrt(sum);
    }

}
