package ama_oa_2021;

//time complexity O(n^3)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class findMinTriple {
	public int findTriple(int productsNode,List<Integer> productsFrom,List<Integer> productsTo){
		Map<Integer,Set<Integer>> graph=new HashMap<>();
		for(int i=0;i<productsFrom.size();i++){
			int start=productsFrom.get(i),end=productsTo.get(i);
			if(!graph.containsKey(start)){
				Set<Integer> set=new HashSet<>();
				graph.put(start, set);
			}
			if(!graph.containsKey(end)){
				Set<Integer> set=new HashSet<>();
				graph.put(end, set);
			}
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		int minSum=Integer.MAX_VALUE;
		for(int node=1;node<=productsNode;node++){
			Set<Integer> neighbors=graph.get(node);
			for(int v:neighbors){
				if(v>node){
					for(int w:neighbors){
						if(w>v && graph.get(v).contains(w)){
							int curSum=neighbors.size()-2+graph.get(v).size()-2+graph.get(w).size()-2;
							minSum=Math.min(minSum, curSum);
						}
					}
				}
			}
		}
		return minSum==Integer.MAX_VALUE?-1:minSum;
	}
}
