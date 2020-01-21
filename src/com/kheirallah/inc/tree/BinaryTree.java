package com.kheirallah.inc.tree;

public class BinaryTree {
    public int data;
    public BinaryTree leftChild;
    public BinaryTree rightChild;

    public BinaryTree(int data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    private void inOrderTraversal(BinaryTree root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.leftChild);
        System.out.println(root.data);
        inOrderTraversal(root.rightChild);
    }

    private void preOrderTraversal(BinaryTree root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    private void postOrderTraversal(BinaryTree root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.data);
    }
}
