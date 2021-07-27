package com.pearson.dp;

public class ClimbingStairs {
    
    public int climbStairs(int n) {
        return topDown(n, new int[n+1]);
    }
    
    public int topDown(int n, int[] arr) {
        if (arr[n] != 0) {
            return arr[n];
        }
        if(n == 0 || n == 1) {
            arr[n] = 1;
            return 1;
        }
        
        arr[n] = topDown(n-1, arr) + topDown(n-2, arr);  
        return arr[n];
    }
    
    public int bottomUp(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}
