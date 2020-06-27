package com.leetcode.problem.solutions;

public class DuplicateNumber {

	/**
	 * Solution should have time complexity better than O(n2) 
	 * Array should not be
	 * modified Try to do with space complexity O(1) 
	 * array will have N+1 items where N is the length of the array
	 * 
	 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
	 * prove that at least one duplicate number must exist.
	 * Assume that there is only one duplicate number, find the duplicate one.
	 * 
	 * @param num
	 * @return
	 */
	public int duplicateNumber(int[] num) {
		int hare = num[0];
		int tortoise = num[0];
		do {
			tortoise = num[tortoise];
			hare = num [num[hare]];
		} while (hare != tortoise);

		hare = num[0];

		while(tortoise!=hare) {
			tortoise = num[tortoise];
			hare = num[hare];	
		}

		
		return hare;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
