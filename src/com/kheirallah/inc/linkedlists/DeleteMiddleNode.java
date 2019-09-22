package com.kheirallah.inc.linkedlists;

//Easy
//Crack the coding interview 2.3

/*
Implement an algorithm to delete a node in the middle (i.e., any node but the first and last, not necessarily the exact middle) of
a singly linked list, given only access to that node.
 Example 1
    Input: node 2, 1 -> 2 -> 3 -> 6
    Output: 1 -> 3 -> 6
 */

import com.kheirallah.inc.model.Node;

public class DeleteMiddleNode {

    public static void main(String args[]) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(6);
        Node middle = head.next;
        head.print();
        System.out.println(deleteMiddleNode(middle));
        head.print();
    }

    //Time Complexity O(1) we are given the node already so no comparisons need to be made
    //Space Complexity O(1) extra space needed for the new node object remains constant
    private static boolean deleteMiddleNode(Node middle) {
        if (middle.next == null || middle == null) {
            return false;
        }
        Node next = middle.next;
        middle.value = next.value;
        middle.next = next.next;
        return true;
    }
}
