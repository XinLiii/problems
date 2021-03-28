package ama_oa_2021;

public class robotBounded {
	public boolean isRobotBounded(String instructions){
		int x=0,y=0,dir=0;
		int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};
		for(char c:instructions.toCharArray()){
			if(c=='G'){
				x+=dirs[dir][0];
				y+=dirs[dir][1];
			}
			else if(c=='L'){
				dir=(dir+1)%4;
			}
			else{
				dir=(dir+3)%4;
			}
		}
		if(x==0 && y==0) return true;
		if((x!=0 || y!=0) && dir==0) return false;
		return true;
	}
}
