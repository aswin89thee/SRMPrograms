package com.srm659.div2;

//Wrong logic
public class PublicTransit {
	int startRow,startCol,endRow,endCol;
	int[][] dist;
	int R, C;
	public int minimumLongestDistance(int R, int C){
		this.R = R;
		this.C = C;
		dist = new int[R][C];
		for(int i = 0 ; i < R ; i++){
			for(int j = 0 ; j < C ; j++){
				dist[i][j] = -1;
			}
		}
		dist[R-1][C-1] = 0;
		int minDist = Integer.MIN_VALUE;
//		for(int k = 0 ; k <= R/4 ; k++){
//			for(int l = 0 ; l <= C/4 ; l++){
//				startRow = k; startCol = l;
//				endRow = R-k-1;endCol = C-l-1;
//				int curDist = getDistance(0,0);
//				minDist = curDist > minDist ? curDist : minDist;
//			}
//		}
		startRow = R/4; startCol = C/4;
		endRow = R-R/4-1; endCol = C-C/4-1;
		minDist = getDistance(0,0);
		return minDist;
	}
	private int getDistance(int i, int j) {
		if( i < 0 || i >= R || j < 0 || j >= C) return Integer.MAX_VALUE-1;
		if(dist[i][j] != -1) return dist[i][j];
		if(i==startRow && j==startCol){
			return 1+getDistance(endRow,endCol);
		}
		int right = 1 + getDistance(i,j+1);
		int down = 1 + getDistance(i+1,j);
		int minDist = right < down ? right : down;
		return minDist;
	}
	
	public static void main(String[] args){
		PublicTransit obj = new PublicTransit();
		System.out.println(obj.minimumLongestDistance(8,2));
	}
}
