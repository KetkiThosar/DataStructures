package com.leetcode.problem.solutions;

public class ProductOfArrayItself {

	public int[] productExceptSelf(int[] nums) {
		/*e.g. 1 3 5 9 
		res[0] =1 
		res[1] = res[0] * nums [0];
		res[1] = 1 * 1 = 1
		res[2] = res[1] * nums[1]; 
		res[2] = 1 * 3 
		res[3] = 3 * 5 
		
		 
		*/
		int res [] = new int [nums.length] ;
		res [0]=1; 
		for(int i = 1 ; i<nums.length ; i++) {
			res[i]=res[i-1]*nums[i-1];
		}
		int right = 1; 
		for(int i = nums.length -1 ; i>=0 ; i++ ) {
			res[i]=res[i]*right;
			right*=nums[i];
		}
		return res;
	}
}
