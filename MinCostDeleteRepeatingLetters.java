package ama_oa_2021;

public class MinCostDeleteRepeatingLetters {
	public int minCost(String s, int[] cost) {
		int maxCost=0,total=0,cnt=0,res=0;
        for(int i=0;i<cost.length;i++){
            cnt+=1;
            total+=cost[i];
            maxCost=Math.max(maxCost,cost[i]);
            if(i+1<cost.length && s.charAt(i)==s.charAt(i+1)){
                continue;
            }
            else{
                if(cnt>1){
                    res+=total-maxCost;
                }
                cnt=0;
                maxCost=0;
                total=0;
            }
        }
        if(cnt>1) res+=total-maxCost;
        return res;
    }
}
