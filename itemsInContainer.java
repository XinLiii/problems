package ama_oa_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class itemsInContainer {
	public static List<Integer> numberOfItems(String s,List<List<Integer>> ranges){
		int l=s.length();
		int[] leftBounds=new int[l],rightBounds=new int[l];
		Map<Integer,Integer> prefixSums=new HashMap<>();
		int curSum=0;
		List<Integer> res=new ArrayList<>();
		for(int i=0;i<l;i++){
			if(s.charAt(i)=='|'){
				prefixSums.put(i, curSum);
			}
			else{
				curSum++;
			}
		}
		int pre=-1;
		for(int i=0;i<l;i++){
			if(s.charAt(i)=='|'){
				pre=i;
			}
			leftBounds[i]=pre;
		}
		pre=-1;
		for(int i=l-1;i>=0;i--){
			if(s.charAt(i)=='|'){
				pre=i;
			}
			rightBounds[i]=pre;
		}
		for(List<Integer> range:ranges){
			int start=rightBounds[range.get(0)],end=leftBounds[range.get(1)];
			if(start!=-1 && end!=-1 && start<end){
				res.add(prefixSums.get(end)-prefixSums.get(start));
			}
			else{
				res.add(0);
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		List<List<Integer>> lst=new ArrayList<>();
		List<Integer> l1=new ArrayList<>();
		l1.add(1);
		l1.add(4);
		lst.add(l1);
		String s="*|**|**|";
		System.out.println(numberOfItems(s,lst));
	}
}
