package ama_oa_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class musicPairs {
	public static int numPairs(List<Integer> songs){
		int res=0;
		Map<Integer,Integer> map=new HashMap<>();
		for(int song:songs){
			song%=60;
			res+=map.getOrDefault(60-song, 0);
			map.put(song, map.getOrDefault(songs, 0)+1);
		}
		return res;
	}
	
	public static void main(String[] args){
		List<Integer> songs=new ArrayList<>();
		songs.add(30);
		songs.add(20);
		songs.add(150);
		songs.add(100);
		songs.add(40);
		System.out.println(numPairs(songs));
	}
}
