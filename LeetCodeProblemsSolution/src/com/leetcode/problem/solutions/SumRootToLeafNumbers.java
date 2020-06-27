package com.leetcode.problem.solutions;

public class SumRootToLeafNumbers {
	int sum = 0;

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

	/* 1. Steps Main idea move down from root to each leaf nodes and calculate the sum,
	 * 2. one more thing at every step sum will multiplied by 10 and add the current value in the sum. 
	 * 3. check if root null - return 0; 
	 * 4. check if it is leaf node which means we got the root to leaf path for that branch and it is terminal
	 * node return the sum. 
	 * 5. recusrisvely open left and right sub tree branch and
	 * update sum * 10 + current node value. In below tree we have three leaf nodes
	 * colored green so we have 3 numbers.
	 */
	public int sumNumbers(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int current_sum = 10 * sum + root.val;
		if (root.left == null && root.right == null) {
			return current_sum;
		}
		return sumNumbers(root.left, current_sum) + sumNumbers(root.right, current_sum);
	}

	public static void main(String[] args) {

	}

}
