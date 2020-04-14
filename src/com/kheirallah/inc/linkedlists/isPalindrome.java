package com.kheirallah.inc.linkedlists;

//Easy
//Crack the coding interview 2.6

/*
Implement a function to check if a linked list is a palindrome
    Input: 1 -> 2 -> 1
    Output: true
 */

import com.kheirallah.inc.model.Node;

public class isPalindrome {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(1);
        head.print();
        System.out.println(isPalindrome(head));
    }

    //Time Complexity O(N) iterate through the same sized list twice
    //Space Complexity O(N) due to requiring a reversed list
    private static Boolean isPalindrome(Node head) {
        Node reversed = reverseList(head);
        return isEqual(head, reversed);
    }

    private static Node reverseList(Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.value);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private static Boolean isEqual(Node l1, Node l2) {
        while (l1 != null && l2 != null) {
            if (l1.value != l2.value) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
