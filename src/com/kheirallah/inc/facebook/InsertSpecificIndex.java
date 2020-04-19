package com.kheirallah.inc.facebook;

import com.kheirallah.inc.model.LinkedList;
import com.kheirallah.inc.model.Node;

/*
https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
 */
public class InsertSpecificIndex {
    public static void main(String[] args) {
        Node head = new Node(16);
        LinkedList list = new LinkedList(head);
        list.appendToTail(13);
        list.appendToTail(7);
        list.print();
        insertSpecificNode(head, 1, 2);
        list.print();
    }

    //Time O(N)
    //Space O(1)
    private static void insertSpecificNode(Node head, int data, int position) {
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }
}
