package com.srm657;

import java.util.ArrayList;
import java.util.List;

public class EightRooks {
	
	public String isCorrect(String[] board){
		int rookCount = 0;
		String correct = "Correct";
		String incorrect = "Incorrect";
		int i,j;
		for(i =0 ; i < board.length ; i++){
			for(j = 0 ; j < board[i].length(); j++){
				if(board[i].charAt(j) == 'R')
					rookCount++;
			}
		}
		if(rookCount != 8) return incorrect;
		List<Integer> rowRooks = new ArrayList<Integer>();
		List<Integer> colRooks = new ArrayList<Integer>();
		for(i = 0 ; i < board.length; i++){
			for(j = 0 ; j < board[i].length() ; j++){
				if(board[i].charAt(j) == 'R'){
					if(rowRooks.contains(i) || colRooks.contains(j)) return incorrect;
					rowRooks.add(i); colRooks.add(j);
				}
			}
		}
		return correct;
	}

}
