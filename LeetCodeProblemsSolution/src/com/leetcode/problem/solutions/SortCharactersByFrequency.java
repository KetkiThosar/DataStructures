package com.leetcode.problem.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public String frequencySort(String s) {
		// int[] freq = new int[128];
		char[] array = s.toCharArray();
		Map<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			freq.put(array[i], freq.getOrDefault(array[i], 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(freq.entrySet());
		
		StringBuilder sb = new StringBuilder();
		
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> e = pq.poll();
			for(int i = 0 ; i < e.getValue(); i++) {
				sb.append(e.getKey());
			}
		}
		

		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(new SortCharactersByFrequency().frequencySort("Aabb"));
	}

}
