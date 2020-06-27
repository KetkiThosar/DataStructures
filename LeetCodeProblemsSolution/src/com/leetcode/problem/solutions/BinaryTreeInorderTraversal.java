package com.leetcode.problem.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			result.add(current.val);
			current = current.right;
		}
		return result;
	}

	public static void main(String[] args) {

		BinaryTreeInorderTraversal.TreeNode node = new BinaryTreeInorderTraversal().new TreeNode(4);
		node.left = new BinaryTreeInorderTraversal().new TreeNode(9);
		node.right = new BinaryTreeInorderTraversal().new TreeNode(0);
		node.left.left = new BinaryTreeInorderTraversal().new TreeNode(5);
		node.left.right = new BinaryTreeInorderTraversal().new TreeNode(1);
		node.left.right.left = new BinaryTreeInorderTraversal().new TreeNode(6);

		new BinaryTreeInorderTraversal().inorderTraversal(node);

	}

}
