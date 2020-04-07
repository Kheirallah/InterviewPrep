package com.kheirallah.inc.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations {

    public static void inOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.leftChild);
        System.out.println(root.data);
        inOrderTraversal(root.rightChild);
    }

    public static void preOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public static void postOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.data);
    }

    public static void levelOrderTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) queue.add(node.leftChild);
            if (node.rightChild != null) queue.add(node.rightChild);
        }
    }

    public static int getHeight(BinaryTreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
    }

}
