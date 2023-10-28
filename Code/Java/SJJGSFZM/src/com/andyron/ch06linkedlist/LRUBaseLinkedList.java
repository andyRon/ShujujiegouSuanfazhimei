package com.andyron.ch06linkedlist;

import java.time.temporal.Temporal;
import java.util.List;
import java.util.Scanner;

/**
 * 基于单链表LRU算法
 */
public class LRUBaseLinkedList<T> {
    class SNode<T> {
        private T element;
        private SNode<T> next;

        public SNode(T element) {
            this.element = element;
        }
        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }
        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode<T> getNext() {
            return next;
        }

        public void setNext(SNode<T> next) {
            this.next = next;
        }
    }

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;
    /**
     * 头节点
     */
    private SNode<T> head;
    /**
     * 链表长度
     */
    private Integer length;
    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.head = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }
    public LRUBaseLinkedList(Integer capacity) {
        this.capacity = capacity;
        this.head = new SNode<>();
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPre(data);

        //
        if (preNode != null) {
            deleteEle(preNode);
            insertEleAtBegin(data);
        } else {
            if (length >= this.capacity) {
                deleteEleAtEnd();
            }
            insertEleAtBegin(data);
        }
    }

    /**
     * 删除下一个
     */
    private void deleteEle(SNode preNode) {
        SNode tmp = preNode.getNext();
        preNode.setNext(tmp.getNext());
        tmp = null;
        length--;
    }

    /**
     * 开始出插入节点
     */
    private void insertEleAtBegin(T data) {
        SNode node = head.getNext();
        head.setNext(new SNode<>(data, node));
        length++;
    }

    /**
     * 元素的前一个节点
     */
    private SNode findPre(T data) {
        SNode node = head;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除尾节点
     */
    private void deleteEleAtEnd() {
        SNode node = head;
        if (node.getNext() == null) {
            node = node.getNext();
        }
        // 倒数第二个
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        SNode tmp = node.getNext();
        node.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = head.getNext();
        while (node != null) {
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Object> lruList = new LRUBaseLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lruList.add(scanner.nextInt());
            lruList.printAll();
        }
    }
}