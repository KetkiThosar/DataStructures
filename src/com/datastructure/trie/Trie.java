package com.datastructure.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Ketki.Thosar Insert/Delete/Search into Trie data structure
 * 
 */
public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode("");
	}

	private class TrieNode {

		private Map<Character, TrieNode> children;
		private boolean endOfWord;
		private String prefix;

		public TrieNode(String prefix) {
			children = new HashMap<>();
			endOfWord = Boolean.FALSE;
			this.prefix = prefix;
		}

		@Override
		public String toString() {
			return "TrieNode [children=" + children + ", endOfWord=" + endOfWord + "]";
		}

	}

	public void insert(String word) {
		TrieNode current = root;
		for (int t = 0; t < word.length(); t++) {
			Character c = word.charAt(t);
			TrieNode node = current.children.get(c);
			if (node == null) {
				node = new TrieNode(word.substring(0, t + 1));
				current.children.put(c, node);
			}
			current = node;
		} // end of for loop
		current.endOfWord = true;
	}

	public void insertRecursively(String word, TrieNode node, int index) {
		if (index == word.length()) {
			node.endOfWord = true;
			return;
		}
		Character c = word.charAt(index);
		TrieNode current = node.children.get(c);
		if (current == null) {
			current = new TrieNode(word.substring(0, index + 1));
			node.children.put(c, current);
		}
		insertRecursively(word, current, index + 1);
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int t = 0; t < word.length(); t++) {
			Character ch = word.charAt(t);
			TrieNode node = current.children.get(ch);
			// if node does not exist for given char then return false
			if (node == null) {
				return false;
			}
			current = node;
		}
		// return true if current endOfWorld is true else return false
		return current.endOfWord;
	}

	public boolean searchRecursively(String word, TrieNode node, int index) {
		if (index == word.length()) {
			return node.endOfWord;
		}
		Character ch = word.charAt(index);
		TrieNode current = node.children.get(ch);
		// if node does not exist for given char then return false
		if (current == null) {
			return false;
		}
		return searchRecursively(word, current, index + 1);
	}

	public boolean delete(String word) {
		return delete(word, root, 0);
	}

	private boolean delete(String word, TrieNode node, int index) {
		if (word.length() == index) {
			if (!node.endOfWord) {
				return false;
			}
			node.endOfWord = false;
			return node.children.size() == 0;
		}

		Character ch = word.charAt(index);
		TrieNode current = node.children.get(ch);
		// if node does not exist for given char then return false
		if (current == null) {
			return false;
		}

		boolean shouldNodeBeDeleted = delete(word, current, index + 1);

		if (shouldNodeBeDeleted) {
			node.children.remove(ch);
			return node.children.size() == 0;
		}
		return false;
	}

	private List<String> searchCommonWords(TrieNode node, List<String> list) {
		if (node.endOfWord) {
			list.add(node.prefix);
		}
		for (Entry<Character, TrieNode> entry : node.children.entrySet()) {
			searchCommonWords(entry.getValue(), list);
		}
		return list;
	}

	public List<String> getSuggestions(String word) {
		TrieNode trieNode = getNode(word);
		if (trieNode == null) {
			System.out.println("No suggestions found for prefix: " + word);
			return null;
		}
		List<String> list = new ArrayList<>();
		return searchCommonWords(trieNode, list);
	}

	private TrieNode getNode(String word) {
		TrieNode current = root;
		for (int t = 0; t < word.length(); t++) {
			Character ch = word.charAt(t);
			TrieNode node = current.children.get(ch);
			// if node does not exist for given char then return false
			if (node == null) {
				return null;
			}
			current = node;
		}
		return current;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("Ketki");
		trie.insert("Ketan");
		trie.insert("Keshav");
		trie.insert("Kedar");
		trie.insert("Kalyani");
		trie.insert("Kalpana");
		trie.insert("Kamana");
		List<String> ans = trie.getSuggestions("Ke");
		if(ans!=null){
			System.out.println("ans: " + ans.toString());	
		}
		
	}

}
