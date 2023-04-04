package com.andyron.ch06linkedlist;

/**
 * 单链表
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int value) {
        Node newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next !=p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }
        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        boolean flag=true;
        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);
        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                flag = false;
                break;
            }

        }
        return flag;
    }

    /**
     * 判断是否为回文
     */
    public boolean isPalindrome() {
        if (head == null) {
            return false;
        }

        Node p = head;
        Node q = head;
        if (p.next == null) {
            System.out.println("只有一个元素");
            return true;
        }
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }

        Node leftLink = null;
        Node rightLink = null;
        if (q.next == null) {
            rightLink = p.next;
            leftLink = inverseLinkList(p).next;
        } else {
            rightLink = p.next;
            leftLink = inverseLinkList(p);
        }

        return TFResult(leftLink, rightLink);
    }

    /**
     * 带节点的链表翻转
     */
    public Node inverseLinkListHead(Node p) {
        Node head = new Node(9999, null);
        head.next = p;

        Node cur = p.next;
        p.next = null;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            System.out.println("first " + head.data);
            cur = next;
        }
        return head;
    }

    /**
     * 无头节点的链表翻转
     */
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;
        Node next = null;
        while (r != p) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        return r;
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();
//        int data[] = {1,2,4,3,1};
        int data[] = {1,2,3,6,3,2,1};

        for (int i = 0; i < data.length; i++) {
            link.insertTail(data[i]);
        }
        link.printAll();
        System.out.println("是否是回文：" + link.isPalindrome());
    }
}