package com.leetcode.problem.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

	/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

	Example 1:

	Input: n = 12
	Output: 3 
	Explanation: 12 = 4 + 4 + 4.
	Example 2:

	Input: n = 13
	Output: 2
	Explanation: 13 = 4 + 9.*/
	
	
	public int numSquares(int n) {
		/**
		 * solution works as follows
		 * 1. get all squares of numbers <= n
		 * 2. e.g.  for every number from 1 to n find the minimum no of squares required 
		 * with dp[0]= 0 dp[1] = 1
		 * dp[5] can be calculated as dp[5] = dp[j - num] dp[5-1] dp[4] : where j = 5 num = 1 
		 * 
		 * 
		 * 
		 * 
		 */
		 List<Integer> list = new ArrayList<>();
	        
	      for(int i = 1 ;i*i<=n;i++){
	         list.add(i*i);
	      }  
	      int [] dp = new int [n+1];
	      Arrays.fill(dp,n+1); 
	      dp[0]=0;
	      dp[1]=1;    
	      for(int j =1 ;j<=n;j++){
	          for(int num : list){
	           if(j>=num){
	        	   /** not understood when dp[5] to be calculated  it is either dp[4] or dp[1]
	        	    *  dp[4] = 1
	        	    *  dp[5] = min(dp[5],dp[4]+1) = 2 OR
	        	    *  dp[5] = min(dp[5],dp[5-4]+1); = 2 why????? how can we get 5 by adding 1 twice??? 
	        	    */
	            dp[j]=Math.min(dp[j],dp[j - num]+1);     
	           }    
	          }//end of for loop
	      } // end of outer for loop
	        
	      return dp[n];  
		
	}
	
	
	public static void main(String[] args) {
		new PerfectSquares().numSquares(13);
	}

}
