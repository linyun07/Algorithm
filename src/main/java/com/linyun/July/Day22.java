package com.linyun.July;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author linyun
 * @since 2023/7/22 9:09
 */


public class Day22 {
    public static Random random = new Random();

    /**
     * 异或面试题：
     * 1.在一个数组中 一种数出现了奇数次 其他数都出现了偶数次
     * 找到出现奇数次的数 时间：O(N) 空间:O(1)
     * 2.两种数出现了奇数次 其他数出现了偶数次
     * 找到这两种出现奇数次的数 时间：O(N) 空间:O(1)
     */
    @Test
    public void EOR1() {
        //第一题
        int[] num = new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3};
        int eor = 0;
        for (int curNum : num) {
            eor ^= curNum;
        }
        System.out.println(eor);
    }

    @Test
    public void EOR2() {
        // 第二题
        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5};
        int eor = 0;
        for (int curNum : nums) {
            eor ^= curNum;
        }
        /**
         * eor=a^b;
         * eor!=0 那么a或b必然有 一位上不相等
         * eor有一个位置上为1
         */
        int rightOne = eor & (~eor + 1);//提取出一个数最右侧的1
        int onlyOne = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                onlyOne ^= num;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));


    }

    /**
     * 冒泡排序：相邻两个进行比较 符合判断条件就交换
     */
    @Test
    public void bubbleSort() {
        int[] arr = buildArray(10);
        ArrForMap(arr);
        if (arr.length <= 2 || arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        ArrForMap(arr);
    }

    /**
     * 选择排序：每次查找找到最大或最小的值索引与i索引值互换
     */
    @Test
    public void selectSort() {
        int[] arr = buildArray(10);
        ArrForMap(arr);
        if (arr.length <= 2 || arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) { //i~N-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //i+1~N找比arr[minIndex]小的值
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        ArrForMap(arr);
    }

    /**
     * 插入排序
     */

    public int[] insertSort() {
        int[] arr = buildArray(10);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j+1, j);
                }
            }
        }
        return arr;
    }

    @Test
    public void binarySearch(){
        int[] num = insertSort();
        int temp=num[random.nextInt(num.length)];
        ArrForMap(num);
        int start=0,end=num.length;
        while (start<end){
            int mid=start+((end-start)/2);
            if (temp>num[mid]){
                start=mid+1;
            }else if (temp<num[mid]){
                end=mid-1;
            }else if (temp==num[mid]){
                System.out.println("你要找的数"+temp+"在"+mid+"位");
                break;
            }
        }
    }

    /**
     * 数据通过Map集合形式输出
     *
     * @param arr
     */
    private static void ArrForMap(int[] arr) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arrMap.put(i, arr[i]);
        }
        System.err.println(arrMap);
    }

    /**
     * 交换arr的i和j上的值
     *
     * @param arr
     * @param i
     * @param j
     */
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        //异或：相同为0 不同为1 相当于无进位相加
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 通过随机数生成length个数的数组
     *
     * @param length
     * @return
     */
    static int[] buildArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        return arr;
    }
}
