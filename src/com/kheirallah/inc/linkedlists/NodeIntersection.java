package com.kheirallah.inc.linkedlists;

//Medium
//Crack the coding interview 2.7

/*
Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is defined based on reference, NOT value.
That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.

 Example 1
    Input: 1 -> 2 -> 5 ->
                            -> 7 -> 9 -> 15
           3 -> 4 ->
    Output: Node with value of 7
 */

import com.kheirallah.inc.model.Node;

public class NodeIntersection {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(5);

        Node headTwo = new Node(3);
        headTwo.appendToTail(4);

        Node headThree = new Node(7);
        headThree.appendToTail(9);
        headThree.appendToTail(15);

        headTwo.appendToTail(headThree);
        head.appendToTail(headThree);

        head.print();
        headTwo.print();

        System.out.println(findIntersection(head, headTwo).value);
    }

    //Time Complexity O(M + N) where M is listOnes length and N is listTwos length
    //Space Complexity O(1), no additional space is required
    private static Node findIntersection(Node listOne, Node listTwo) {
        if (listOne == null || listTwo == null) {
            return null;
        }
        Result result1 = getTailAndSize(listOne);
        Result result2 = getTailAndSize(listTwo);

        if (result1.tail != result2.tail) {
            return null; //these lists have no intersection if they dont end at the same node
        }

        Node shorter = result1.size < result2.size ? listOne : listTwo;
        Node longer = result1.size < result2.size ? listTwo : listOne;

        //Advance the pointer for the longer linked list by the difference in lengths.
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        //move both pointers until you have a collision
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer; //or shorter, they should be equal
    }

    private static Node getKthNode(Node head, int k) {
        Node current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    private static Result getTailAndSize(Node list) {
        if (list == null) {
            return null;
        }

        int size = 1;
        Node current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

}

class Result {
    public Node tail;
    public int size;

    public Result(Node tail, int size) {
        this.tail = tail;
        this.size = size;
    }
}
