package ama_oa_2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class splitStringPrime {
	public static boolean[] getPrimes(){
		boolean[] isPrimes=new boolean[1000];
		Arrays.fill(isPrimes, true);
		isPrimes[0]=false;
		isPrimes[1]=false;
		for(int i=2;i*i<1000;i++){
			if(isPrimes[i]){
				for(int j=i*i;j<1000;j+=i){
					isPrimes[j]=false;
				}
			}
		}
		return isPrimes;
	}
	
	public static int splitPrimes(String str){
		int l=str.length();
		int[] dp=new int[l+1]; // number of ways to split till i-th digit into primes
		dp[0]=1;
		boolean[] isPrime=getPrimes();
		for(int i=1;i<=l;i++){
			if(str.charAt(i-1)!='0' && isPrime[Integer.valueOf(str.substring(i-1,i))]){
				dp[i]=dp[i-1];
			}
			if(i-2>=0 && str.charAt(i-2)!='0' && isPrime[Integer.valueOf(str.substring(i-2,i))]){
				dp[i]+=dp[i-2];
			}
			if(i-3>=0 && str.charAt(i-3)!='0' && isPrime[Integer.valueOf(str.substring(i-3,i))]){
				dp[i]+=dp[i-3];
			}
		}
		return dp[l];
	}
	
	public static void main(String[] args){
		int a=splitPrimes("311737");
		System.out.println(a);
	}
}
