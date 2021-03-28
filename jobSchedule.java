package ama_oa_2021;

//time complexity O(nnd)
//space complexity O(nd)
//do memoisation to avoid TLE

import java.util.Arrays;

public class jobSchedule {
	public int minDifficulty(int[] jobDifficulty, int d){
		int n=jobDifficulty.length;
		if(n<d) return -1;
		int[][] dp=new int[n][d+1];
		for(int[] row:dp){
			Arrays.fill(row, -1);
		}
		return dfs(d,0,jobDifficulty,n,dp);
	}
	
	public static int dfs(int d,int i,int[] jobDifficulty,int n,int[][] dp){
		if(d==0 && i==n) return 0;
		if(d==0 || i==n) return -1;
		if(dp[i][d]!=-1) return dp[i][d];
		int curMax=jobDifficulty[i];
		int min=Integer.MAX_VALUE;
		for(int curJob=i;curJob<n;curJob++){
			curMax=Math.max(curMax, jobDifficulty[curJob]);
			int pre=dfs(d-1,curJob+1,jobDifficulty,n,dp);
			if(pre!=-1){
				min=Math.min(min, pre);
			}
		}
		dp[i][d]=min;
		return min;
	}
}
