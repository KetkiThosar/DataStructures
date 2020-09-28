package com.leetcode.problem.solutions;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

	class Trie {

		class TrieNode {
			Map<Character, TrieNode> children;
			boolean isWord;

			TrieNode() {
				children = new HashMap<>();
				isWord = false;
			}

		}

		TrieNode root = null;

		Trie() {
			root = new TrieNode();
		}

		void insert(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode node = current.children.get(c);
				if (node == null) {
					node = new TrieNode();
					current.children.put(c, node);
				}

				current = node;
			}
			current.isWord = true;
		}

		boolean search(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode node = current.children.get(c);
				if (node == null) {
					return false;
				}
				current = node;
			}
			return current.isWord;
		}

		boolean startsWith(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode node = current.children.get(c);
				if (node == null) {
					return false;
				}
				current = node;
			}
			return true;
		}

	}

	public static void main(String[] args) {

	}

}
