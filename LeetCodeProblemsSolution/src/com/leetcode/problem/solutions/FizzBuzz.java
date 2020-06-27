package com.leetcode.problem.solutions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public List<String> fizzBuzz(int n) {
		String fizz = "Fizz";
		String buzz = "Buzz";
		String fizzBuzz = "FizzBuzz";
		List<String> result = new ArrayList<>();
		if (n < 1) {
			return result;
		}
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				result.add(fizzBuzz);
			} else if (i % 5 == 0) {
				result.add(buzz);
			} else if (i % 3 == 0) {
				result.add(fizz);
			} else {
				result.add("" + i);
			}
		}
		return result;
	}

}
