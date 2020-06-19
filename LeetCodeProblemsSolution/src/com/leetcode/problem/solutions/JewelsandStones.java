package com.leetcode.problem.solutions;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {

	public int numJewelsInStones(String J, String S) {
		if (J == null || S == null) {
			return 0;
		}
		J = J.trim();
		S = S.trim();
		Set<Character> jewels = new HashSet<>();
		char[] jchar = J.toCharArray();
		for (int i = 0; i < jchar.length; i++) {
			jewels.add(jchar[i]);
		}
		char[] schar = S.toCharArray();
		int count = 0;
		for (int j = 0; j < schar.length; j++) {
			if (jewels.contains(schar[j])) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String J = "z";
		String S = "ZZ";
		System.out.println(new JewelsandStones().numJewelsInStones(J, S));

	}

}
