package com.leetcode.problem.solutions;

public class CanJump {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int lastGoodPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			int val = nums[i] + i;
			if (val >= lastGoodPos) {
				lastGoodPos = i;
			}
		}
		return lastGoodPos == 0;
	}

	public static void main(String[] args) {
		new CanJump().canJump(new int [] {3,2,2,0,1,4});
	}
}
