package com.leetcode.problem.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public String frequencySortWithBucketList(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
						
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
				
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(c);

        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(new SortCharactersByFrequency().frequencySort("Aabb"));
	}

}
