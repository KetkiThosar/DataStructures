package com.leetcode.problem.solutions;

public class BitwiseANDofNumbersRange {
	 public int rangeBitwiseAnd(int m, int n) {
	      int i = 0; // i means we have how many bits are 0 on the right
	      while(m != n){
	        m >>= 1;
	        n >>= 1;
	        i++;  
	      }  
	      return n << i;  
	    }
	public static void main(String[] args) {
		System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(26, 30));
	}

}
