package com.hayee.test;

import java.util.Arrays;

/**
 * Hard learning
 *
 * @author hayeejie
 * @date 2023/4/8 16:14
 */
public class CopyMath {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] newArr = copy(arr,4,8);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }
        System.out.println();

        //另一种解法，不需要自己写方法，用Java自带APi
        int[] coArr = Arrays.copyOfRange(arr,4,8);
        for (int r: coArr) {
            System.out.println(r);
        }
    }
    public static int[] copy(int[] arr,int from,int to){
        int[] copyArr = new int[to - from];
        int index = 0;
        for (int i = from; i < to; i++) {
            copyArr[index] = arr[i];
            index++;
        }
        return copyArr;
    }
}
