package com.leetcode.problem.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class KthSmallest {

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

	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		TreeNode current = root;
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		result.add(0);
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.add(current);
				current = current.left;
			}
			current = stack.pop();
			result.add(current.val);
			if (result.size() > k) {
				return result.get(k);
			}
			current = current.right;
		}
		return result.get(k);
	}

	public int kthSmallestMostEfficient(TreeNode root, int k) {
		List<Integer> arrayList = new ArrayList<>();
		getSortedElems(root, k, arrayList);

		return arrayList.get(k - 1);
	}

	public void getSortedElems(TreeNode root, int k, List<Integer> arrayList) {

		if (root == null || arrayList.size() - 1 > k) {
			return;
		}
		getSortedElems(root.left, k, arrayList);
		arrayList.add(root.val);
		getSortedElems(root.right, k, arrayList);

	}

	public static void main(String[] args) {

	}

}
