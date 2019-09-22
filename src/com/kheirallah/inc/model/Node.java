package com.kheirallah.inc.model;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public void appendToTail(int val) {
        Node end = new Node(val);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void print() {
        Node n = this;
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
        System.out.println();
    }
}
