package com.andyron.ch28heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author andyron
 **/
public class Heap {
    /**
     * 数组，从下标1开始存储数据
     */
    private int[] a;
    /**
     * 堆可以存储的最大数据个数
     */
    private int n;
    /**
     * 堆中已经存储的数据个数
     */
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入元素
     * 从下往上的堆化
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        // 自下往上堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 删除堆顶元素
     * 把最后一个节点放到堆顶，然后再进行从上往下的堆化
     */
    public void removeMax() {
        // 堆中没有数据
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 自上往下堆化
     * @param a 存储堆的数组
     * @param n 堆中已经存储的数据个数
     * @param i 开始交换的位置
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public static void main(String[] args) {

    }

}
