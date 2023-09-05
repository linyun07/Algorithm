package com.linyun;

import java.util.Arrays;
import java.util.Random;

/**
 * @author linyun
 * @since 2023/9/5 9:12
 */


public class Day9_5_Sort {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] arr = buildArr(10);
        System.err.println("创建新数组" + Arrays.toString(arr));
//        selectionSort(arr);
//        bobbleSort(arr);
        insertSort(arr);
//        printOddTimesNum2();
        binarySearch(arr);
    }

    /**
     * 二分查找
     * @param arr
     */
    public static void binarySearch(int[] arr) {
        int start = 0, end = arr.length - 1;
        int num = arr[RANDOM.nextInt(10)];
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if(num == arr[mid]){
                System.out.println("你要找的数"+num+"在数组的第" + mid + "位");
                break;
            }else if (num > arr[mid]) {
                start = mid + 1;
            } else if (num < arr[mid]) {
                end = mid - 1;
            }else {
                System.out.println("没找到" + num + "的位置请查看后 重试");
                break;
            }
        }
    }

    /**
     * 插入排序：从第二个元素开始。对于每个元素，我们将其与其前面的元素进行比较，并将比它大的元素向后移动，直到找到合适的位置将其插入
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr.length < 2 && arr == null) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
        System.out.println("插入排序后的数组为：" + Arrays.toString(arr));
    }

    /**
     * 求出一个数组中出现奇数次的两个不同数
     * & -->AND运算符：有0为0，全1为1
     * | -->OR运算符:有1为1，全0为0
     * ^ -->异或运算符:相同为0，不同为1
     */
    public static void printOddTimesNum2() {
        int[] arr = {2, 2, 3, 3, 6, 6, 8, 7};
        int eor = 0, onlyOne = 0;
        //求出一个唯一的数
        for (int curNum : arr) {
            eor ^= curNum;
        }
        int rightOne = eor & (~eor + 1);//提取最右的1
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    /**
     * 冒泡排序:它重复地遍历待排序的元素，比较相邻的两个元素，并按照规定的顺序交换它们
     *
     * @param arr
     */
    public static void bobbleSort(int[] arr) {
        if (arr.length < 2 && arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
        System.out.println("冒泡排序之后的结果为：" + Arrays.toString(arr));
    }

    /**
     * 选择排序：选择数组中最小的数与前面做交换
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr.length < 2 && arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(i, minIndex, arr);
        }
        System.out.println("选择排序之后的结果为：" + Arrays.toString(arr));
    }

    /**
     * 对arr数组里面的i和j位置做交换
     *
     * @param i
     * @param j
     * @param arr
     */
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 生成n的元素的数组
     *
     * @param n
     * @return
     */
    public static int[] buildArr(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = RANDOM.nextInt(100) + 1;
            nums[i] = num;
        }
        return nums;
    }

}
