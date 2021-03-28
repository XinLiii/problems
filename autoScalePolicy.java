package ama_oa_2021;

import java.util.List;

public class autoScalePolicy {
	public int autoScale(List<Integer> averageUtils,int numInstances){
		int instances=numInstances;
		for(int i=0;i<averageUtils.size();i++){
			int util=averageUtils.get(i);
			if(util>60){
				if(instances<=Math.pow(10, 8)){
					instances*=2;
					i+=10;
				}
			}
			else if(util<25){
				if(instances>1){
					instances=(instances+1)/2;
					i+=10;
				}
			}
		}
		return instances;
	}
}
