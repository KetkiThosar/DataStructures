package com.leetcode.problem.solutions;

public class UncrossedLines {

	public static void main(String[] args) {
		int[] Q = { 1, 1, 2, 1, 2,2 };
		int[] T = { 1, 3, 2, 3, 1,2,3,3 };
		

		System.out.println(new UncrossedLines().maxUncrossedLines(Q, T));
		//int[] S = { 2, 5, 1, 2, 5 };
		//int[] R = { 10, 5, 2, 1, 5, 2 };
	//	System.out.println(new UncrossedLines().maxUncrossedLines(S, R));
		//int[] A = { 1, 3, 7, 1, 7, 5 };
		//int[] B = { 1, 9, 2, 5, 1 };
	//	System.out.println(new UncrossedLines().maxUncrossedLines(A, B));
	}

	public int maxUncrossedLines(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				//System.out.println("A[i-1]: "+A[i-1]);
				//System.out.println("B[j-1]: "+B[j-1]);
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[j - 1][i]);
				}
			}
		}
		return dp[m][n];

	}
}
