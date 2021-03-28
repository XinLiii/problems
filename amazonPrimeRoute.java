package ama_oa_2021;

//time complexity O(n*m)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class amazonPrimeRoute {
	public List<List<Integer>> getPairs(List<List<Integer>> a,List<List<Integer>> b,int target){
		Collections.sort(a,(x,y)->(x.get(1)-y.get(1)));
	    Collections.sort(b,(x,y)->(y.get(1)-x.get(1)));
	    List<List<Integer>> res=new ArrayList<>();
	    int i=0,j=0,maxSum=0;
	    while(i<a.size() && j<b.size()){
	    		List<Integer> lstA=a.get(i),lstB=b.get(j);
	    		int curSum=lstA.get(1)+lstB.get(1);
	    		if(curSum>target){
	    			j--;
	    		}
	    		else{
	    			if(curSum>maxSum){
	    				maxSum=curSum;
	    				res.clear();
	    			}
	    			for(int k=j;k<b.size();k++){
	    				List<Integer> tmp=b.get(k);
	    				if(tmp.get(1)!=lstB.get(1)){
	    					break;
	    				}
	    				List<Integer> oneRes=new ArrayList<>();
	    				oneRes.add(lstA.get(0));
	    				oneRes.add(lstB.get(0));
	    				res.add(oneRes);
	    			}
	    		}
	    }
	    return res;
	}
}
