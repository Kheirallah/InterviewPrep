package com.kheirallah.inc.tree;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary Tree, compute the average per level
public class AveragePerLevel {

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(4);

        //left tree
        binaryTreeNode.leftChild = new BinaryTreeNode(2);
        binaryTreeNode.leftChild.leftChild = new BinaryTreeNode(3);
        binaryTreeNode.leftChild.rightChild = new BinaryTreeNode(5);

        //right tree
        binaryTreeNode.rightChild = new BinaryTreeNode(9);
        binaryTreeNode.rightChild.rightChild = new BinaryTreeNode(7);

        averageOfLevels(binaryTreeNode);
    }

    //Time: O(N)
    //Space: O(N)
    public static void averageOfLevels(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            int counter = 0;
            Queue<BinaryTreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                BinaryTreeNode node = queue.poll();
                sum += node.data;
                counter++;
                if (node.leftChild != null) {
                    temp.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    temp.add(node.rightChild);
                }
            }
            queue = temp;
            System.out.println((sum * 1.0) / counter);
        }
    }
}
