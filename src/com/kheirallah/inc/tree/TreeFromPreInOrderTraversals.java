package com.kheirallah.inc.tree;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
 */
public class TreeFromPreInOrderTraversals {

    private static int preIndex = 0;

    public static void main(String[] args) {
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        BinaryTreeNode root = buildTree(inOrder, preOrder);
        System.out.println("Pre order");
        TreeOperations.preOrderTraversal(root);
        System.out.println("In order");
        TreeOperations.inOrderTraversal(root);
    }

    //Time: O(N^2) can be order n if we use a hashmap for the search instead of a standard selective search but ups the space complexity
    //Space: O(1)
    private static BinaryTreeNode buildTree(int[] inOrder, int[] preOrder) {
        return buildUtil(inOrder, preOrder, 0, inOrder.length - 1);
    }

    private static BinaryTreeNode buildUtil(int[] inOrder, int[] preOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        BinaryTreeNode node = new BinaryTreeNode(preOrder[preIndex]);
        preIndex++;
        if (inStart == inEnd) return node;
        int inIndex = search(inOrder, inStart, inEnd, node.data);
        node.leftChild = buildUtil(inOrder, preOrder, inStart, inIndex - 1);
        node.rightChild = buildUtil(inOrder, preOrder, inIndex + 1, inEnd);
        return node;
    }

    private static int search(int[] traversedList, int start, int end, int data) {
        for (int i = start; i <= end; i++) {
            if (traversedList[i] == data) return i;
        }
        return -1;
    }
}
