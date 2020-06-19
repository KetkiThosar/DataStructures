package com.leetcode.problem.solutions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private DNode head;
	private DNode tail;
	private int capacity;
	private Map<Integer, DNode> cache = new HashMap<>();

	class DNode {
		private DNode pre;
		private DNode post;
		private int key;
		private int value;

		DNode() {

		}

		DNode(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[key = " + key + " Value = " + value + " ]";
		}

	}

	void moveToHead(DNode node) {
		node.post = head.post;
		node.pre = head;
		head.post = node;
		node.post.pre = node;

	}

	void remove(DNode prev) {
		prev.pre.post = prev.post;
		prev.post.pre = prev.pre;
	}

	DNode popTail() {
		DNode prev = tail.pre;
		remove(prev);
		return prev;
	}

	DNode addNode(int key, int value) {
		DNode node = new DNode(key, value);
		moveToHead(node);
		return node;
	}

	public Integer get(int key) {
		DNode node = cache.get(key);
		if (node != null) {
			remove(node);
			moveToHead(node);
			System.out.println(node.value);
			return node.value;
		}
		System.out.println("-1");
		return -1;
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new DNode();
		tail = new DNode();
		head.post = tail;
		tail.pre = head;
	}

	public void put(int key, int value) {
		DNode node = cache.get(key);
		if (node == null) {
			node = addNode(key, value);
			cache.put(key, node);
			if (cache.size() > capacity) {
				DNode tail = popTail();
				cache.remove(tail.key);
			}
		} else {
			node.value = value;
			moveToHead(node);
		}

	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1); // returns 1
		cache.put(3, 3); // evicts key 2
		cache.get(2); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		cache.get(1); // returns -1 (not found)
		cache.get(3); // returns 3
		cache.get(4); // returns 4
	}
}
