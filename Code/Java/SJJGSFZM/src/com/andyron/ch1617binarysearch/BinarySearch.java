package com.andyron.ch1617binarysearch;

/**
 * 二分查找最简单的情况：有序数组中不存在==重复==元素
 * @author andyron
 **/
public class BinarySearch {
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
//            int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1); // 改进
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int bsearch2(int a[], int n, int value) {
        return bsearchInternally(a, 0, n - 1, value);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, a[mid + 1], high, value);
        } else {
            return bsearchInternally(a, low, a[mid - 1], value);
        }
    }

    public static void main(String[] args) {

    }
}
