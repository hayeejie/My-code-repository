package com.hayee.skiploop;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/4 23:26
 */
public class SkipLoopDemo2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("小老虎在吃第"+i+"个包子");
            if (i == 3) {
                //结束整个循环
                break;
            }
            //System.out.println("小老虎在吃第"+i+"个包子");
        }
    }
}
