package com.andyron.ch09queue;

/**
 * @author andyron
 **/
public class GeneralLinkedListQueue<T> {
    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
        public T getData() {
            return data;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void enqueue(T value) {
        Node newNode = new Node(value, null);
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }
        T value = head.data;
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

    public static void main(String[] args) {
        GeneralLinkedListQueue<Integer> queue = new GeneralLinkedListQueue<>();
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(23);
        queue.dequeue();
        queue.printAll();
    }
}
