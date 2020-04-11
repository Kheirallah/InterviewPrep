package com.kheirallah.inc.tree;

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.
Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
 */
public class PathSum {

    //Time O(N)
    //Space O(1)
    public static boolean hasPathSum(BinaryTreeNode root, int sum) {
        if (root == null) return false;
        if (root.leftChild == null && root.rightChild == null) return sum == root.data;
        return hasPathSum(root.leftChild, sum - root.data) || hasPathSum(root.rightChild, sum - root.data);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.leftChild = new BinaryTreeNode(4);
        root.leftChild.leftChild = new BinaryTreeNode(11);
        root.leftChild.leftChild.leftChild = new BinaryTreeNode(7);
        root.leftChild.leftChild.rightChild = new BinaryTreeNode(2);
        root.rightChild = new BinaryTreeNode(8);
        root.rightChild.leftChild = new BinaryTreeNode(13);
        root.rightChild.rightChild = new BinaryTreeNode(4);
        root.rightChild.rightChild.rightChild = new BinaryTreeNode(1);
        System.out.println(hasPathSum(root, 22));
    }
}
