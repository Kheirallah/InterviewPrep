package com.kheirallah.inc.linkedlists;

//Easy
//Crack the coding interview 2.4

/*
Implement an algorithm to partition a linked list around a value x, such that all nodes less than x come before all nodes greater
than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The
partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions
    Input: 5, 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
    Output: 1 -> 2 -> 3 -> 5 -> 8 -> 5 -> 10
 */

import com.kheirallah.inc.model.Node;

public class Partition {

    public static void main(String[] args) {
        Node head = new Node(3);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(5);
        head.appendToTail(10);
        head.appendToTail(2);
        head.appendToTail(1);
        int partition = 5;
        head.print();
        head = partition(head, partition);
        head.print();
    }

    //Time Complexity O(N) iterate through the list
    //Space Complexity O(1) no extra data structures needed
    private static Node partition(Node node, int partition) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (node.value < partition) {
                //Insert node at the head
                node.next = head;
                head = node;
            } else {
                //Insert at the tail
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}
