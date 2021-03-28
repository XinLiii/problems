package ama_oa_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class connectNodes {
	public static int minCostToConnect(int n,List<List<Integer>> edges,List<List<Integer>> newEdges){
		Map<Integer,Set<Integer>> graph=new HashMap<>();
		for(List<Integer> edge:edges){
			int s=edge.get(0),e=edge.get(1);
			if(!graph.containsKey(s)){
				Set<Integer> tmp=new HashSet<>();
				graph.put(s, tmp);
			}
			if(!graph.containsKey(e)){
				Set<Integer> tmp=new HashSet<>();
				graph.put(e, tmp);
			}
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		System.out.println(graph.get(1).size());
		int minCost=0;
		Collections.sort(newEdges,(a,b)->(a.get(2)-b.get(2)));
		Set<Integer> connected=new HashSet<>();
		for(List<Integer> newEdge:newEdges){
//			should do bfs here
			int n1=newEdge.get(0),n2=newEdge.get(1);
			if(connected.contains(n1) && connected.contains(n2)) continue;
			if((graph.containsKey(n1) && graph.get(n1).contains(n2)) || 
					(graph.containsKey(n2) && graph.get(n2).contains(n1))){
				if(graph.containsKey(n1)){
					connected.addAll(graph.get(n1));
					connected.add(n1);
				}
				if(graph.containsKey(n2)){
					connected.addAll(graph.get(n2));
					connected.add(n2);
				}
			}
			else{
				minCost+=newEdge.get(2);
				System.out.println(connected.size());
				if(!graph.containsKey(n1)){
					Set<Integer> tmp=new HashSet<>();
					graph.put(n1, tmp);
				}
				if(!graph.containsKey(n2)){
					Set<Integer> tmp=new HashSet<>();
					graph.put(n2, tmp);
				}
				graph.get(n1).addAll(graph.get(n2));
				graph.get(n1).add(n2);
				graph.get(n2).addAll(graph.get(n1));
				graph.get(n2).add(n1);
				connected.add(n1);
				connected.add(n2);
				connected.addAll(graph.get(n1));
				connected.addAll(graph.get(n2));
			}
		}
		return minCost;
	}
	
	public static void main(String[] args){
		List<List<Integer>> lst=new ArrayList<>();
		List<Integer> l1=new ArrayList<>();
		l1.add(1);
		l1.add(4);
		lst.add(l1);
		List<Integer> l2=new ArrayList<>();
		l2.add(4);
		l2.add(5);
		lst.add(l2);
		List<Integer> l3=new ArrayList<>();
		l3.add(2);
		l3.add(3);
		lst.add(l3);
		List<List<Integer>> cost=new ArrayList<>();
		List<Integer> l4=new ArrayList<>();
		l4.add(1);
		l4.add(2);
		l4.add(5);
		cost.add(l4);
		List<Integer> l5=new ArrayList<>();
		l5.add(1);
		l5.add(3);
		l5.add(10);
		cost.add(l5);
		List<Integer> l6=new ArrayList<>();
		l6.add(1);
		l6.add(6);
		l6.add(2);
		cost.add(l6);
		List<Integer> l7=new ArrayList<>();
		l7.add(5);
		l7.add(6);
		l7.add(5);
		cost.add(l7);
		System.out.println(minCostToConnect(6,lst,cost));
	}
}
