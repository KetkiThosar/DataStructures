package com.leetcode.problem.solutions;

public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		if (text1 == null || text2 == null) {
			return -1;
		}
		int max = 0;
		int m = text2.length();
		int n = text1.length();
		int[][] dp = new int[n+1][m+1];
		char[] first = text1.toCharArray();
		char[] second = text2.toCharArray();
		for (int i = 1; i <=first.length; i++) {
			for (int j = 1; j <=second.length; j++) {
				max = Math.max(dp[i-1][j], dp[i][j - 1]);
				if (first[i-1] == second[j-1]) {
					dp[i][j] = max + 1;
				} else {
					dp[i][j] = max;
				}
			}
		}
		
		System.out.println("Ans : "+dp[n][m]);
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		lcs.longestCommonSubsequence( "ace", "abcde" );
		lcs.longestCommonSubsequence( "abc", "abc" );
		lcs.longestCommonSubsequence( "abc", "def" );
		lcs.longestCommonSubsequence( "bsbininm","jmjkbkjkv");
		
	}
}
