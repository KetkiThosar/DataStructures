package com.leetcode.problem.solutions;

/*
 * Problem# 
 */
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
       if(matrix == null || matrix.length == 0){
           return 0;
       }
       int dp[][] = new int[matrix.length][];  
       int maxLen = 0; 
       int row = matrix.length;
       int col = matrix[0].length;
       for(int i = 1; i<row;i++){
         for(int j = 1 ; j<col;j++){
           if(matrix[i-1][j-1]=='1'){
             dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
             maxLen = Math.max(maxLen,dp[i][j]);  
           }  
         }  
       } 
       return maxLen*maxLen; 
    }
}