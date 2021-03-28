package ama_oa_2021;
//time complexity O(n*logn)
import java.util.Collections;
import java.util.List;

public class storageOptimization {
	public int storageOpt(int n,int m,List<Integer> h,List<Integer> v){
		return (maxStorage(h)+1)*(maxStorage(v)+1);
	}
	
	public int maxStorage(List<Integer> list){
		Collections.sort(list);
		int pre=-1;
		int len=0;
		int maxLen=0;
		for(int val:list){
			if(val!=pre+1){
				len=0;
			}
			len++;
			pre=val;
			maxLen=Math.max(maxLen, len);
		}
		return maxLen;
	}
}
