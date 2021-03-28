package ama_oa_2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class fiveStart {
	public static int numFiveStars(List<List<Integer>> ratings,int t){
		int n=ratings.size();
		PriorityQueue<List<Integer>> pq=new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> a,List<Integer> b){
				double resA=((double)(a.get(1)-a.get(0)))/((double)(a.get(1)*(a.get(1)+1)));
				double resB=((double)(b.get(1)-b.get(0)))/((double)(b.get(1)*(b.get(1)+1)));
				if(resA>=resB) return -1;
				else return 1;
			}
		});
		double curRating=0.0;
		for(List<Integer> rating:ratings){
			curRating+=((double)rating.get(0)/(double)rating.get(1));
			pq.offer(rating);
		}
		int res=0;
		double rate=(double)t/100;
		while(curRating<rate*n && !pq.isEmpty()){
			List<Integer> cur=pq.poll();
			curRating-=((double)cur.get(0)/(double)cur.get(1));
			curRating+=((double)(cur.get(0)+1)/(double)(cur.get(1)+1));
			res++;
			cur.set(0, cur.get(0)+1);
			cur.set(1, cur.get(1)+1);
			pq.offer(cur);
		}
		return res;
	}
	
	public static void main(String[] args){
		List<List<Integer>> lst=new ArrayList<>();
		List<Integer> l1=new ArrayList<>();
		l1.add(4);
		l1.add(4);
		lst.add(l1);
		List<Integer> l2=new ArrayList<>();
		l2.add(1);
		l2.add(2);
		lst.add(l2);
		List<Integer> l3=new ArrayList<>();
		l3.add(3);
		l3.add(6);
		lst.add(l3);
		System.out.println(numFiveStars(lst,75));
	}
}
