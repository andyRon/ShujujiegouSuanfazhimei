package com.andyron.ch09queue;

/**
 * 基于链表的队列
 * @author andyron
 **/
public class LinkedListQueue {
    private Node head = null;
    private Node tail = null;

    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }
        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    private static class Node {
        private String data;
        private Node next;
        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
        public String getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue("luck");
        queue.enqueue("james");
        queue.enqueue("davis");
        System.out.println(queue.dequeue());
        queue.printAll();
    }
}
