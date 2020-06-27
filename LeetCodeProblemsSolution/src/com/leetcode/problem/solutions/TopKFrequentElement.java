package com.leetcode.problem.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> freq= new HashMap<>();
		for(int num : nums) {
		  freq.put(num, freq.getOrDefault(num, 0)+1);	
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
		pq.addAll(freq.entrySet());
		List<Integer> result = new ArrayList<>();
		while(k>0 && !pq.isEmpty()) {
			Map.Entry<Integer, Integer> entry = pq.poll();
			result.add(entry.getKey());
			k--;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int [] nums = {1,1,1,2,2,3}; 
		int	k = 2;
		System.out.println(new TopKFrequentElement().topKFrequent(nums, k));
	}

}
