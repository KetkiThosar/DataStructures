package com.leetcode.problem.solutions;

public class SearchInBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode searchBST(TreeNode node, int data) {
		if (node == null) {
			return node;
		}
		if (node.val == data) {
			return node;
		}
		if (data < node.val) {
			return searchBST(node.left, data);
		} else if (data > node.val) {
			return searchBST(node.right, data);
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
