package ama_oa_2021;

public class MaximalNetworkRank {
	public static int maximalNetworkRank(int n, int[][] roads) {
        int[] degree=new int[n];
        int res=0;
        for(int[] road:roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        for(int[] road:roads){
            res=Math.max(res,degree[road[0]]+degree[road[1]]-1);
        }
        return res;
    }
	
	public static void main(String[] args){
		int n=6;
		int[][] roads={{0,1},{1,2},{3,4},{4,5}};
		System.out.println(maximalNetworkRank(n,roads));
	}
}
