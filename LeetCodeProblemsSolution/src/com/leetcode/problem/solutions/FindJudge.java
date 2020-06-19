package com.leetcode.problem.solutions;

public class FindJudge {

	public static void main(String[] args) {
		int N = 3;
		int[][] trust = { { 1, 2 }, { 2, 3 } };
		System.out.println(new FindJudge().findJudge(N, trust));

	}

	public int findJudge(int N, int[][] trust) {
		int[] array = new int[N + 1];
		for (int i = 0; i < trust.length; i++) {
			array[trust[i][1]]++;
			array[trust[i][0]]--;
		} // end of for loop

		for (int index = 1; index <= N; index++) {
			if (array[index] == N - 1) {
				return index;
			}

		}
		return -1;
	}
}
