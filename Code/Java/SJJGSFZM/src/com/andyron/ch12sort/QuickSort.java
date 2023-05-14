package com.andyron.ch12sort;

import java.util.Arrays;

/**
 * @author andyron
 **/
public class QuickSort {
    public static void quick_sort(int[] a, int n) {
        quick_sort_c(a, 0, n - 1);
    }

    private static void quick_sort_c(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(a, p, r);
        quick_sort_c(a, p, q - 1);
        quick_sort_c(a, q + 1, r);
    }

    /**
     * 分区函数，获取分区点
     */
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};
        QuickSort.quick_sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
