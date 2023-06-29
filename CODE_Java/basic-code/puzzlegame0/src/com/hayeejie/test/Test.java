package com.hayeejie.test;

import java.util.Random;

/**
 * Hard learning
 *
 * @author hayeejie
 * @name puzzlegame
 * @date 2023/5/15 15:36
 */
public class Test {
    public static void main(String[] args) {
        //定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //打乱数组数据中的数字
        //遍历数组得到每一个数据，拿着每一个元素跟随即索引上的数据进行交换
        Random random = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随即索引
            int index = random.nextInt(tempArr.length);
            //拿着每一个元素跟随即索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        //打印数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();

        //创建一个二维数组
        int[][] data = new int[4][4];

        //第一种方法：给二位数组添加数据
        /*for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }*/

        //第二种方法：给二位数组添加数据
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = tempArr[index];
                index++;
            }
        }

        //打印二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
