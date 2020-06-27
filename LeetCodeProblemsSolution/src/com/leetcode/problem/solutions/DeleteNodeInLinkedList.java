package com.leetcode.problem.solutions;

public class DeleteNodeInLinkedList {

	/**
	 * Write a function to delete a node (except the tail) in a singly linked list,
	 * given only access to that node.
	 * 
	 * Given linked list -- head = [4,5,1,9], which looks like following:
	 * 
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public void deleteNode(ListNode node) {
		if(node != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}
	
	

	public static void main(String[] args) {
		
	}

}
