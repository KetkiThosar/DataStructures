package com.leetcode.problem.solutions;

public class ReverseLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// 1->2->3->4->5->NULL
	public ListNode reverse(ListNode node) {
		ListNode current = node;
		ListNode next = node;
		ListNode prev = null;
		while (node != null) {
			current = node;
			next = node.next;
			current.next = prev;
			prev = node;
			node = next;
		}
		return current;
	}
	
	//A->B->C->D->NULL
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = reverseList(head.next); // step 1
		ListNode q = head.next; // step 2
		q.next = head; // step 3
		head.next = null; // step 4
		return p;
	}

	public static void main(String[] args) {

	}

}
