package com.kheirallah.inc.linkedlists;

//Easy
//Crack the coding interview 2.5

/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such
that the 1's digit is a the head of the list. Write a function that adds the two numbers and returns the sum of the list.

    Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
    Output: 2 -> 1 -> 9. That is, 912
 */

import com.kheirallah.inc.model.Node;

public class SumLists {

    public static void main(String args[]) {
        Node head = new Node(7);
        head.appendToTail(1);
        head.appendToTail(6);
        Node secondHead = new Node(5);
        secondHead.appendToTail(9);
        secondHead.appendToTail(2);
        head.print();
        System.out.println("+");
        secondHead.print();
        Node sum = sumLists(head, secondHead, 0);
        sum.print();
    }

    //Time Complexity O(M + N) where M equals list one size and N equals list two size, if same size O(N)
    //Space Complexity O(N) requires a new linked list for the sum
    private static Node sumLists(Node listOne, Node listTwo, int carry) {
        if (listOne == null && listTwo == null && carry == 0) {
            return null;
        }
        Node result = new Node();
        int value = carry;

        if (listOne != null) {
            value += listOne.value;
        }

        if (listTwo != null) {
            value += listTwo.value;
        }

        //Second digit of value
        result.value = value % 10;

        if (listOne != null || listTwo != null) {
            Node more = sumLists(listOne == null ? null : listOne.next, listTwo == null ? null : listTwo.next, value >= 10 ? 1 : 0);
            result.next = more;
        }

        return result;
    }
}
