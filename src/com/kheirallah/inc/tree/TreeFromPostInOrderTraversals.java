package com.kheirallah.inc.tree;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
 */
public class TreeFromPostInOrderTraversals {

    private static int postIndex = 0;

    public static void main(String[] args) {
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        int[] postOrder = new int[]{9, 15, 7, 20, 3};
        BinaryTreeNode root = buildTree(inOrder, postOrder);
        System.out.println("Post order");
        TreeOperations.postOrderTraversal(root);
        System.out.println("In order");
        TreeOperations.inOrderTraversal(root);
    }

    //Time: O(N^2) can be order n if we use a hashmap for the search instead of a standard selective search but ups the space complexity
    //Space: O(1)
    private static BinaryTreeNode buildTree(int[] inOrder, int[] postOrder) {
        postIndex = inOrder.length - 1;
        return buildUtil(inOrder, postOrder, 0, inOrder.length - 1);
    }

    private static BinaryTreeNode buildUtil(int[] inOrder, int[] postOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        BinaryTreeNode node = new BinaryTreeNode(postOrder[postIndex]);
        --postIndex;

        if (inStart == inEnd) return node;

        int inIndex = search(inOrder, inStart, inEnd, node.data);

        node.rightChild = buildUtil(inOrder, postOrder, inIndex + 1, inEnd);
        node.leftChild = buildUtil(inOrder, postOrder, inStart, inIndex - 1);

        return node;
    }

    private static int search(int[] traversedList, int start, int end, int data) {
        for (int i = start; i <= end; i++) {
            if (traversedList[i] == data) return i;
        }
        return -1;
    }
}
