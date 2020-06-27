package com.leetcode.problem.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

	public static void main(String[] args) {
		
	}

	public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> ret = new ArrayList<>();

	        backtrack(ret, new ArrayList<>(), new HashSet<>(), nums);

	        return ret;
	}
	
	private void  backtrack(List<List<Integer>>list,List<Integer>tempList,Set<Integer>tempSet,int [] nums) {
		if(nums.length == tempSet.size()) {
			list.add(new ArrayList<>(tempList));
			return;
		}
		for(int i = 0 ; i< nums.length;i++) {
			if(tempSet.contains(nums[i])) {
				continue;
			}
			tempSet.add(nums[i]);
			tempList.add(nums[i]);
			
			backtrack(list,tempList,tempSet,nums);
			tempSet.remove(tempList.get(tempList.size()-1));
			tempList.remove(tempList.size()-1);
		}
	}

}
