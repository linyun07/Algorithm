package com.linyun;

import java.util.Arrays;
import java.util.Random;

/**
 * @author linyun
 * @description
 * @since 2023/9/7 21:52
 */


public class Day9_7_DutchFlag {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = buildArr(5);
        int num = arr[random.nextInt(arr.length-1)];
//        contrastNum(arr, num);
        dutchFlag(arr, num);
    }

    public static void contrastNum(int[] arr, int num) {
        System.out.println(num);
        int l = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= num) {
                swap(l++, i, arr);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void dutchFlag(int[] arr, int num) {
        System.out.println(num);
        int l = 0, r = arr.length - 1;
        for (int i = 0; i < arr.length && i<=r; i++) {
            if (arr[i] < num) {
                swap(l++, i, arr);
            } else if (arr[i] > num) {
                swap(r--, i, arr);
                i -= 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] buildArr(int n) {
        Random random = new Random();
        int[] num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(100) + 1;
        }
        System.err.println(Arrays.toString(num));
        return num;
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
