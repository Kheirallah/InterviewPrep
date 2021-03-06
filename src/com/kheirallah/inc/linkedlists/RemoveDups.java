package com.kheirallah.inc.linkedlists;

//Easy
//Crack the coding interview 2.1

/*
Write code to remove duplicates from an unsorted linked list

 Example 1
    Input: 1 -> 2 -> 2 -> 4 -> 5 ->
    Output: 1 -> 2 -> 4 -> 5 ->
 */

import com.kheirallah.inc.model.LinkedList;
import com.kheirallah.inc.model.Node;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    public static void main(String[] args) {
        Node head = new Node(1);
        LinkedList list = new LinkedList(head);
        list.appendToTail(2);
        list.appendToTail(2);
        list.appendToTail(2);
        list.appendToTail(4);
        list.appendToTail(5);
        list.print();
        removeDups(head);
        //removeDupsInPlace(head);
        list.print();
    }

    //Time Complexity O(N)
    //Space Complexity O(N)
    private static void removeDups(Node head) {
        Set<Integer> valuesFound = new HashSet<>();
        Node current = head;
        Node previous = current;
        while (current.next != null) {
            if (valuesFound.contains(current.value)) {
                previous.next = current.next;
            } else {
                previous = current;
                valuesFound.add(current.value);
            }
            current = current.next;
        }
    }

    //Time Complexity O(N^2)
    //Space Complexity O(1)
    private static void removeDupsInPlace(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
