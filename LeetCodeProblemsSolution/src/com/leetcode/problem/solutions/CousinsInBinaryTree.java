package com.leetcode.problem.solutions;


import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

	public static void main(String[] args) {

	}

	/* Definition for a binary tree node. */
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

	public boolean isCousins(TreeNode root, int A, int B) {
	//	Deque<TreeNode> stack = new ArrayDeque<>();
		if (root == null)
			return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean isAexist = false;
			boolean isBexist = false;
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.val == A)
					isAexist = true;
				if (cur.val == B)
					isBexist = true;
				//This condition to check if they are brothers
				if (cur.left != null && cur.right != null) {
					if ((cur.left.val == A && cur.right.val == B) || (cur.left.val == B && cur.right.val == A)) {
						return false;
					}
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}//end of for loop
			if (isAexist && isBexist)
				return true;
		}
		return false;
	}
}
