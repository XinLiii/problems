package ama_oa_2021;

import java.util.ArrayList;
import java.util.List;

public class numOfOption {
	public int numberOfOption(List<Integer> a,List<Integer> b,List<Integer> c,List<Integer> d,int limit){
		List<Integer> a_b=new ArrayList<>();
		for(int i=0;i<a.size();i++){
			for(int j=0;j<b.size();j++){
				a_b.add(a.get(i)+b.get(j));
			}
		}
	}
}
