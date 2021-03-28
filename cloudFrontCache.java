package ama_oa_2021;

//time complexity O(n+e)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class cloudFrontCache {
	public static int cloudFrontCache(int n,List<List<Integer>> edges){
		Map<Integer,Set<Integer>> graph=new HashMap<>();
		for(List<Integer> edge:edges){
			int a=edge.get(0),b=edge.get(1);
			if(!graph.containsKey(a)){
				Set<Integer> tmp=new HashSet<>();
				graph.put(a,tmp);
			}
			if(!graph.containsKey(b)){
				Set<Integer> tmp=new HashSet<>();
				graph.put(b,tmp);
			}
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		Set<Integer> visited=new HashSet<>();
		int res=0;
		for(int i=1;i<=n;i++){
			if(!visited.contains(i)){
				visited.add(i);
				if(!graph.containsKey(i)){
					res+=1;
				}
				else{
					Queue<Integer> que=new LinkedList<>();
					que.offer(i);
					int cost=0;
					while(!que.isEmpty()){
						int cur=que.poll();
						cost++;
						for(int next:graph.get(cur)){
							if(!visited.contains(next)){
								visited.add(next);
								que.offer(next);
							}
						}
					}
					res+=Math.ceil(Math.sqrt(cost));
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		List<List<Integer>> edges=new ArrayList<>();
		List<Integer> tmp=new ArrayList<>();
		tmp.add(1);
		tmp.add(2);
		edges.add(tmp);
		List<Integer> tmp2=new ArrayList<>();
		tmp2.add(1);
		tmp2.add(3);
		edges.add(tmp2);
		List<Integer> tmp3=new ArrayList<>();
		tmp3.add(2);
		tmp3.add(4);
		edges.add(tmp3);
		List<Integer> tmp4=new ArrayList<>();
		tmp4.add(3);
		tmp4.add(5);
		edges.add(tmp4);
		List<Integer> tmp6=new ArrayList<>();
		tmp6.add(7);
		tmp6.add(8);
		edges.add(tmp6);
		System.out.println(cloudFrontCache(10,edges));
	}
}
