package com.leetcode.problem.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public int orangesRotting(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int row = grid.length;
		int col = grid[0].length;
		int fresh = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					fresh++;
				}
			}
		} // end of for loop

		if (fresh == 0) {
			return 0;
		}
		int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				for (int[] dir : directions) {
					int x = point[0] + dir[0];
					int y = point[1] + dir[1];

					if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0 || grid[x][y] == 2) {
						continue;
					}
					grid[x][y] = 2;
					queue.offer(new int[] { x, y });
					fresh--;
				}
			}
		} // end of while loop
		return fresh == 0 ? count - 1 : -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(new RottingOranges().orangesRotting(grid));
	}

}
