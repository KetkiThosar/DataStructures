package com.leetcode.problem.solutions;

public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {
		char[] sarray = s.toCharArray();
		int prev = -1;
		for (int i = 0; i < sarray.length; i++) {
			prev = t.indexOf(sarray[i], prev + 1);
			if (prev == -1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
