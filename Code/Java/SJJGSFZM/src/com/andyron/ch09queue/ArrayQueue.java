package com.andyron.ch09queue;

/**
 * 基于数组的队列
 * @author andyron
 **/
public class ArrayQueue {

    private String[] items;
    /**
     * 数组大小
     */
    private int n = 0;
    /**
     * 队头下标
     */
    private int head = 0;
    /**
     * 队尾下标
     */
    private int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    /**
     * 入队
     */
    public boolean enqueue(String item) {
        // tail为n时表示队尾没有空间了
        if (tail == n) {
            // head为0同时tail为n，表示队列满了
            if (head == 0 ){
                return false;
            }
            // 队前有空间，进行数据搬移
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            // 搬移完之后，更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }
    /**
     * 出队
     */
    public String  dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
