package com.kheirallah.inc.model;

public class LinkedList {
    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public void appendToTail(int val) {
        Node end = new Node(val);
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void appendToTail(Node val) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = val;
    }

    public void print() {
        Node n = head;
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
        System.out.println();
    }
}
