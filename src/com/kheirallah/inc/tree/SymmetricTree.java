package com.kheirallah.inc.tree;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
 */
public class SymmetricTree {

    //Time O(N)
    //Space O(1)
    public static boolean isSymmetric(BinaryTreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.data == t2.data) && isMirror(t1.leftChild, t2.rightChild) && isMirror(t2.leftChild, t1.rightChild);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.leftChild = new BinaryTreeNode(2);
        root.leftChild.leftChild = new BinaryTreeNode(3);
        root.leftChild.rightChild = new BinaryTreeNode(4);
        root.rightChild = new BinaryTreeNode(2);
        root.rightChild.leftChild = new BinaryTreeNode(4);
        root.rightChild.rightChild = new BinaryTreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
