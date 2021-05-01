package ama_oa_2021;

public class RemoveLettersMakeFreqUnique {
	public int minDeletions(String s) {
        int[] letter=new int[26];
        int max=0;
        for(int i=0;i<s.length();i++){
            letter[s.charAt(i)-'a']++;
            max=Math.max(max,letter[s.charAt(i)-'a']);
        }
        int[] contain=new int[max+1];
        for(int i=0;i<26;i++){
            if(letter[i]!=0) contain[letter[i]]++;
        }
        int res=0;
        for(int i=max;i>0;i--){
            if(contain[i]>0){
                int extra=contain[i]-1;
                res+=extra;
                contain[i-1]+=extra;
            }
        }
        // if(contain[0]!=0) res+=contain[0]-1;
        return res;
    }
	
	public static void main(String[] args){
		System.out.println(4444&1);
	}
}
