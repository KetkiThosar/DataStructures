package com.leetcode.problem.solutions;

public class NumberComplement {

	/*
	 * for example: 100110, its complement is 011001, the sum is 111111. So we only
	 * need get the min number large or equal to num, then do substraction
	 */

	public int findComplement(int num) {
		int n = 0;
		while (n < num) {
			n = (n << 1) | 1;
		}
		return n - num;
	}

	public int findComplementBruteForce(int num) {
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
