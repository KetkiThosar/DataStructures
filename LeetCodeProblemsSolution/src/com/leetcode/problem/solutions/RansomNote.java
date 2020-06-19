package com.leetcode.problem.solutions;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null){
            return false;
        }
        ransomNote = ransomNote.trim();
        magazine = magazine.trim();
        int [] freq = new int [128] ;
        char [] input = magazine.toCharArray();
        for(int i = 0 ; i < input.length; i++ ){
            int c = input[i] - '0';
            freq[c]++;
        }
        char [] ransom = ransomNote.toCharArray();
        for(int j = 0 ; j < ransom.length ; j++) {
        	int c = ransom[j] - '0';
        	if(freq[c]==0) {
        		return false;
        	}
        	freq[c]--;
        }
        return true;
    }
	public static void main(String[] args) {
		String ransomNote = "aa";String magazine = "aab";
		System.out.println(new RansomNote().canConstruct(ransomNote, magazine));
	}

}
