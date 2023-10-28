package com.andyron.ch28heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Java中堆类（优先队列类）的测试
 * @author andyron
 **/
public class PriorityQueueTest {
    public static void main(String[] args) {
        /* 初始化堆 */
        // 初始化小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();
        // 初始化大顶堆（使用 lambda 表达式修改 Comparator 即可）
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        /* 元素入堆 */
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
        maxHeap.offer(4);

        System.out.println(maxHeap);
        /* 获取堆顶元素 */
        int peek = maxHeap.peek(); // 5

        /* 堆顶元素出堆 */
        // 出堆元素会形成一个从大到小的序列
        peek = maxHeap.poll(); // 5
        System.out.println(maxHeap);
        peek = maxHeap.poll(); // 4
        System.out.println(maxHeap);
        peek = maxHeap.poll(); // 3
        System.out.println(maxHeap);
        peek = maxHeap.poll(); // 2
        System.out.println(maxHeap);
        peek = maxHeap.poll(); // 1

        /* 获取堆大小 */
        int size = maxHeap.size();

        /* 判断堆是否为空 */
        boolean isEmpty = maxHeap.isEmpty();

        /* 输入列表并建堆 */
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 2, 5, 4));
    }
}
