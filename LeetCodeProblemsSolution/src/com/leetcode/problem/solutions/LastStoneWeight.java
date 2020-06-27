package com.leetcode.problem.solutions;

import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		int [] input = {2,7,4,1,8,1};
		System.out.println(new LastStoneWeight().lastStoneWeight(input));
	}

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int n : stones) {
			pq.add(n);
		}
		while (pq.size() >1) {
			int weight = pq.poll() - pq.poll();
				pq.add(weight);
		}
		return pq.poll();

	}

}
