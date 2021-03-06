package com.leetcode.problem.solutions;

public class FibonnaciNumber {
	public int fib(int N) {
		if (N == 0) {
			return 0;
		}
		int dp[] = new int[N + 1];
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N];
	}

	public static void main(String[] args) {
		System.out.println(new FibonnaciNumber().fib(1));

	}

}
