package com.kheirallah.inc.linkedlists;

//Medium
//Crack the coding interview 2.8

/*
Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
    Definition:
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list

    Input: 1 -> 2 -> 3 -> 4 -> 2 (same 2 as earlier)
    Output: 2
 */

import com.kheirallah.inc.model.Node;

public class LoopDetection {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(head.next);
        System.out.println(findLoop(head).value);
    }

    //Time Complexity O(N), traverse through the length of the list
    //Space Complexity O(1), no new data structures needed
    private static Node findLoop(Node head) {
        Node slow = head;
        Node fast = head;

        //Find meeting point. This will be LOOP_SIZE - k steps into the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { //Collision
                break;
            }
        }

        //Error check - no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        //Move slow to Head. Keep fast at Meeting point. Each are k steps from the loop start. If they move at the same pace, they must meet at the loop start.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        //Both now point to the start of the loop
        return fast;
    }

}
