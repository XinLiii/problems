package ama_oa_2021;

import java.util.Arrays;
import java.util.Comparator;

// time complexity
// sort O(nlogn)
// compare each string O(len)

public class reorderLog {
	public String[] reorderLogFiles(String[] logs){
		Comparator<String> compa=new Comparator<String>(){
			@Override
			public int compare(String s1,String s2){
				int i1=s1.indexOf(' '),i2=s2.indexOf(' ');
				char c1=s1.charAt(i1+1),c2=s2.charAt(i2+1);
				boolean isDigit1=Character.isDigit(c1),isDigit2=Character.isDigit(c2);
				if(isDigit1 && isDigit2){
					return 0;
				}
				else if(isDigit1 && !isDigit2){
					return 1;
				}
				else if(!isDigit1 && isDigit2){
					return -1;
				}
				else{
					int order=s1.substring(i1+1).compareTo(s2.substring(i2+1));
					return order==0?s1.substring(0,i1).compareTo(s2.substring(0,i2)):order;
				}
			}
		};
		Arrays.sort(logs,compa);
		return logs;
	}
}
