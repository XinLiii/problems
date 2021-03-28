package ama_oa_2021;

//time complexity O(n*logn)
//space complexity O(n*logn)

import java.util.ArrayList;
import java.util.List;

public class swapAlgorithm {
	class Pair{
		int index;
		int value;
		public Pair(int i,int v){
			index=i;
			value=v;
		}
	}
	
	public static int count=0;
	
	public static List<Pair> mergeSort(List<Pair> nums){
		if(nums.size()<=1){
			return nums;
		}
		int mid=nums.size()/2;
		List<Pair> left=mergeSort(nums.subList(0, mid));
		List<Pair> right=mergeSort(nums.subList(mid,nums.size()));
		return merge(left,right);
	}
	
	public static List<Pair> merge(List<Pair> left,List<Pair> right){
		int l=0,r=0;
		List<Pair> res=new ArrayList<>();
		while(l<left.size() || r<right.size()){
			if(r>=right.size() || (l<left.size() && left.get(l).value<right.get(r).value)){
				res.add(left.get(l));
				l++;
				count+=r;
			}
			else{
				res.add(right.get(r));
				r++;
			}
		}
		return res;
	}
	
	public int numberOfSwapsSort(List<Integer> nums){
		List<Pair> lst=new ArrayList<>();
		for(int i=0;i<nums.size();i++){
			Pair pair=new Pair(i,nums.get(i));
			lst.add(pair);
		}
		mergeSort(lst);
		return count;
	}
}
