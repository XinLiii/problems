package ama_oa_2021;

import java.util.PriorityQueue;

// time complexity
// O(n*logn)

public class minCostConnSticks {
	public int connectSticks(int[] sticks){
		if(sticks.length<2) return 0;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int stick:sticks){
			pq.offer(stick);
		}
		int res=0,cur=0;
		while(pq.size()>1){
			cur=pq.poll()+pq.poll();
			res+=cur;
			pq.offer(cur);
		}
		return res;
	}
}
