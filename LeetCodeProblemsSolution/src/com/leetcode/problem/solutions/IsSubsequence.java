package com.leetcode.problem.solutions;

public class IsSubsequence {
	//TODO follow up question remaining. 
	
	
	/*Given a string s and a string t, check if s is subsequence of t.

	A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
	of the characters without disturbing the relative positions of the remaining characters.
	 (ie, "ace" is a subsequence of "abcde" while "aec" is not).

	Follow up:
	If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
	and you want to check one by one to see if T has its subsequence. 
	In this scenario, how would you change your code? */
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
