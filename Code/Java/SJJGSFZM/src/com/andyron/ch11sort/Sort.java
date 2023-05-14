package com.andyron.ch11sort;

import java.util.Arrays;

/**
 * @author andyron
 **/
public class Sort {
    /**
     * 冒泡排序
     * @param a
     * @param n 数组大小
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int j = 0; j < n; ++j) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int i = 0; i < n - j - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换提前退出
            if (!flag) {
                break;
            }
        }
    }
    // TODO 冒泡 改进

    /**
     * 插入排序
     * @param a
     * @param n
     * // TODO
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 初始，第一个元素作为已排序区间，后面的元素作为未排序区
        // 从未排序区第一个元素开始遍历
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     * @param a
     * @param n
     */
    public void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};
        Sort sort = new Sort();
//        sort.bubbleSort(a, a.length);
        sort.insertionSort(a, a.length);
//        sort.selectionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
