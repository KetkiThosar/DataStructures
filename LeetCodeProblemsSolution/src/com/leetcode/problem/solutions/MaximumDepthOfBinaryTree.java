package com.leetcode.problem.solutions;

public class MaximumDepthOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public int maxDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return Math.max(maxDepth(node.left), maxDepth(node.right))+1;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
