package com.linyun;

import java.util.Arrays;
import java.util.Random;

/**
 * @author linyun
 * @since 2023/9/6 19:39
 */


public class Day9_6_LogNSort {

    public static void main(String[] args) {
        //master公式求递归时间复杂度：T(n) =a* (N/b) +O(N^d)
        int[] arr = buildArr(5);
        System.err.println(Arrays.toString(arr));
        System.out.println("数组中最大的是" + process(arr, 0, arr.length - 1));
        mergeSort(arr);

    }

    /**
     * 归并排序：左边排好序，右边排好序，让整体有序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int sum = mergeProcess(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println("数组中小和总和为：" + sum);
    }

    /**
     * 对两边排好序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static int mergeProcess(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        int sum = mergeProcess(arr, 1, mid)
                + mergeProcess(arr, mid + 1, r)
                + mergeArr(arr, 1, mid, r);
        return sum;
    }

    /**
     * 合并两边数组
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static int mergeArr(int[] arr, int l, int mid, int r) {
        int[] helpArr = new int[r - l + 1];
        int i = 0, res = 0;
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1)  : 0;
            helpArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helpArr[i++] = arr[p1++];
        }
        while (p2 <= r) {
            helpArr[i++] = arr[p2++];
        }
        for (i = 0; i < helpArr.length; i++) {
            arr[l + i] = helpArr[i];
        }
        return res;
    }

    /**
     * 求l 到 r中最大的数
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int process(int arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);//中点
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    public static int[] buildArr(int n) {
        Random random = new Random();
        int[] num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(100) + 1;
        }
        return num;
    }

}
