package com.leetcode.problem.solutions;


public class ConstructBinaryTreeFromPreorderTraversal {
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

	
	public TreeNode bstFromPreorder(int[] preorder) {
		
		return createBst(0,preorder,preorder.length -1 );
		
	}
	
	public TreeNode createBst(int start, int [] preorder,int end) {
		System.out.println("start : "+start+" end : "+end);
		if(start > end) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[start]);
		int i ;
		for(i = start; i<= end ; i++) {
			if(preorder[i]>node.val) {
				break;
			}
		}
		
		node.left = createBst(start+1,preorder,i-1);
		node.right = createBst(i,preorder,end);
		
		return node;
	}
	
	
	
	
	
	public static void main(String[] args) {
		new ConstructBinaryTreeFromPreorderTraversal().bstFromPreorder(new int [] {8,5,1,7,10,12});
	}
}
