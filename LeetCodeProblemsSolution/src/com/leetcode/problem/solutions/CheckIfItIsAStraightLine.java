package com.leetcode.problem.solutions;

public class CheckIfItIsAStraightLine {

	public static void main(String[] args) {
		int[][] coordinates = { { 0, 0 }, { 0, 1 }, { 0, -1 } };
		System.out.println(new CheckIfItIsAStraightLine().checkStraightLine(coordinates));
	}

	public boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length == 1) {
			return true;
		}
		int[] p = coordinates[0];
		int[] q = coordinates[1];
		for (int i = 2; i < coordinates.length; i++) {
			int[] curr = coordinates[i];
			if ((q[1] - p[1]) * (curr[0] - p[0]) != (curr[1] - p[1]) * (q[0] - p[0])) {
				return false;
			}
		}
		return true;
	}

}
