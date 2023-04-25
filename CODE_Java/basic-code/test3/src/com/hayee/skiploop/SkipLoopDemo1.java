package com.hayee.skiploop;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/4 23:23
 */
public class SkipLoopDemo1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                //跳过本次循环
                continue;
            }
            System.out.println("小老虎在吃第"+i+"个包子");
        }
    }
}
