package com.hayee.suanfa;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name Learn-basic-code
 * @date 2023/6/4 16:32
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(getCount(20));
    }

    public static int getCount(int layer) {
        if (layer == 1) {
            return 1;
        }
        if (layer == 2) {
            return 2;
        }
        if (layer == 3) {
            return 4;
        }
        return getCount(layer - 1) + getCount(layer - 2) + getCount(layer - 3);
    }
}
