package com.hayeejie.util;

import java.util.Random;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name puzzlegame
 * @date 2023/5/17 16:45
 */
public class CodeUtil {

    public static String getCode() {
        char[] chs = new char[52];
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < chs.length; i++) {
            //ASCII码表
            if (i <= 25) {
                //添加小写字母
                chs[i] = (char) (97 + i);
            } else {//27
                //添加大写字母
                chs[i] = (char) (65 + i - 26);
            }
        }
        for (int i = 0; i < 4; i++) {
            sb.append(chs[r.nextInt(chs.length)]);
        }
        sb.append(nums[r.nextInt(nums.length)]);
        String code = sb.toString();
        // 将字符串转换为 char 数组
        char[] c = code.toCharArray();

        // 循环随机打乱数组中的元素
        for (int i = 0; i < c.length; i++) {
            int index = r.nextInt(c.length);
            char temp = c[i];
            c[i] = c[index];
            c[index] = temp;
        }
        code = new String(c);
        return code;
    }
}
