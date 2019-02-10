package com.datastructure.trie;

import java.util.List;
/**
 * 
 * @author Ketki.Thosar
 *	Implements a method that returns auto suggested words for a prefix 
 */
public class AutoSuggest {

	public List<String> autoSuggest(String prefix) {
		Trie trie = new Trie();
		return trie.getSuggestions(prefix);
	}

}
