package com.leetcode.problem.solutions;

public class SingleNumber {

	 public int singleNumber(int[] nums) {
		 int x = nums[0];
		 for(int i = 1 ; i<nums.length;i++) {
			 x^=nums[i];
		 }
		 return x;
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
