package com.leetcode.problem.solutions;

public class BinaryTreeMaximumPathSum {
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

	private int answer = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		findSum(root);
		return answer;
	}

	public int findSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int L = Math.max(0, findSum(root.left));
		int R = Math.max(0, findSum(root.right));
		answer = Math.max(answer, L + R + root.val);
		return Math.max(L, R) + root.val;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum btmp = new BinaryTreeMaximumPathSum();
		BinaryTreeMaximumPathSum.TreeNode node = btmp.new TreeNode(2);
		node.left = btmp.new TreeNode(-1);
		btmp.maxPathSum(node);
	}
}
