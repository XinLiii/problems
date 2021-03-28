package ama_oa_2021;

//time complxity O(mn)
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class moveObstacle {
	public int moveObstacle(int r,int c,List<List<Integer>> lot){
		Queue<int[]> que=new LinkedList<>();
		int m=lot.size(),n=lot.get(0).size();
		int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
		int[] start={0,0};
		que.offer(start);
		int lvl=0;
		while(!que.isEmpty()){
			int s=que.size();
			lvl+=1;
			for(int i=0;i<s;i++){
				int[] cur=que.poll();
				for(int[] dir:dirs){
					int newr=cur[0]+dir[0],newc=cur[1]+dir[1];
					if(newr>=0 && newr<m && newc>=0 && newc<n){
						if(lot.get(newr).get(newc)==0){
							que.offer(new int[]{newr,newc});
							lot.get(newr).set(newc,1);
						}
						else if(lot.get(newr).get(newc)==9){
							return lvl;
						}
					}
				}
			}
		}
		return -1;
	}
}
