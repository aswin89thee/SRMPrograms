package com.srm659.div2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilipTheFrog {

	public int countReachableIslands(int[] positions, int L){
		if(positions.length <= 1) return positions.length;
		Set<Integer> reachable = new HashSet<Integer>();
		List<Integer> myList = new ArrayList<Integer>();
		for(int cur : positions){
			myList.add(cur);
		}
		reachable.add(positions[0]);
		while(true){
			int before = reachable.size();
			Set<Integer> tempSet = new HashSet<Integer>();
			for(Integer cur : reachable){
				for(int j = 0 ; j <= L ; j++){
					int plus = cur+j;
					int minus = cur-j;
					if(myList.contains(plus)) tempSet.add(plus);
					if(myList.contains(minus)) tempSet.add(minus);
				}
			}
			if(tempSet.size() > 0){
				for(Integer cur : tempSet){
					reachable.add(cur);
				}
			}
			int after = reachable.size();
			if(before == after)
				break;
		}
		
		return reachable.size();
	}
	
	
}
