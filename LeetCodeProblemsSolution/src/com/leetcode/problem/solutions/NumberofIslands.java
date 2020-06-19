package com.leetcode.problem.solutions;

public class NumberofIslands {

	public static void main(String[] args) {
		char[][] arr = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(new NumberofIslands().numIslands(arr));
	}

	public int numIslands(char[][] grid) {
		if (grid == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count += 1;
					callBFS(grid, i, j);
				}
			}
		}
		return count;
	}

	void callBFS(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		callBFS(grid, i - 1, j);//up
		callBFS(grid, i, j - 1);//left
		callBFS(grid, i, j + 1);//right
		callBFS(grid, i + 1, j);//down
	}
}
