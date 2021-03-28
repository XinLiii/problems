package ama_oa_2021;

// time complexity O(n*logn)
import java.util.Arrays;

public class maxAreaOfCuts {
	public int maxArea(int h,int w,int[] horiCuts,int[] vertiCuts){
		long MOD=1000000007;
		long area=maxCut(h,horiCuts)*maxCut(w,vertiCuts);
		int res=(int)(area%MOD);
		return res;
	}
	
	public long maxCut(int l, int[] cuts){
		Arrays.sort(cuts);
		int maxCut=cuts[0];
		for(int i=0;i<cuts.length-1;i++){
			maxCut=Math.max(maxCut, cuts[i+1]-cuts[i]);
		}
		maxCut=Math.max(maxCut, l-cuts[cuts.length-1]);
		return maxCut;
	}
}
