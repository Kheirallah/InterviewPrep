package com.kheirallah.inc.linkedlists;

//Easy
//Crack the coding interview 2.2

/*
Implement an algorithm to find the kth to last element of a singly linked list
 Example 1
    Input: 2, 1 -> 2 -> 3 -> 6
    Output: 6
 */

import com.kheirallah.inc.model.LinkedList;
import com.kheirallah.inc.model.Node;

public class ReturnKthToLast {

    public static void main(String[] args) {
        Node head = new Node(1);
        LinkedList list = new LinkedList(head);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(6);
        int position = 2;
        list.print();
        kthToTheLast(head, position);
    }

    //Time Complexity O(N) iterate through the list once
    //Space Complexity O(1)
    private static int kthToTheLast(Node head, int pos) {
        if (head == null) {
            return 0;
        }
        int index = kthToTheLast(head.next, pos) + 1;
        if (index == pos) {
            System.out.println(pos + "th to the last node is " + head.value);
        }
        return index;
    }
}
