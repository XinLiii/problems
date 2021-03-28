package ama_oa_2021;

import java.util.ArrayList;

//two methods
//sort and select, time complexity O(n*logn)


import java.util.List;
import java.util.PriorityQueue;

public class optimizeBoxWeight {
	public List<Integer> optimizeBoxWeight(List<Integer> arr){
		int sum=0;
		for(int each:arr){
			sum+=each;
		}
		PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
		pq.addAll(arr);
		int curSum=0;
		List<Integer> res=new ArrayList<>();
		while(curSum<=sum/2){
			int cur=pq.poll();
			res.add(0, cur);
			curSum+=cur;
		}
		return res;
	}
}
