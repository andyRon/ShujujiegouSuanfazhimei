package com.andyron.ch12sort;

import java.util.Arrays;

/**
 * @author andyron
 **/
public class MergeSort {
    /**
     * 归并排序
     * @param a 要排序数组
     * @param n 数组长度
     */
    public static void mergeSort(int[] a, int n) {
        merge_sort_c(a, 0, n - 1);
    }

    /**
     * 给数组a从下标p到r之间的数组进行归并排序
     * @param a
     * @param p
     * @param r
     */
    private static void merge_sort_c(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }
        // 取p到r之间的位置q
        int q = (p + r) / 2;
        // 分治递归
        merge_sort_c(a, p, q);
        merge_sort_c(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    /**
     * 合并函数
     *
     * 两个游标 i 和 j，分别指向 A[p...q]和 A[q+1...r]的第一个元素。
     * 比较这两个元素 A[i]和 A[j]，如果 A[i]<=A[j]，我们就把 A[i]放入到临时数组 tmp，并且 i 后移一位，
     * 否则将 A[j]放入到数组 tmp，j 后移一位。
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        // 申请一个大小跟a[p...r]一样的临时数组
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }

    /**
     * 合并（哨兵） // TODO
     */
    public static void mergeBySentry(int[] a, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = a[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = a[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0, j = 0, k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                a[k++] = leftArr[i++];
            } else {
                a[k++] = rightArr[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};
        mergeSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
