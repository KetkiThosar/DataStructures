package com.leetcode.problem.solutions;

public class NumberComplement {

	public int findComplement(int num) {
		String binary = Integer.toBinaryString(num);
		char[] array = binary.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '0') {
				array[i] = '1';
			} else {
				array[i] = '0';
			}
		}
		String afterRepl = String.valueOf(array);
		int decimal = Integer.parseInt(afterRepl, 2);
		return decimal;
	}

	public static void main(String[] args) {
		System.out.println(new NumberComplement().findComplement(20));
	}
}
