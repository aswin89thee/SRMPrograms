package com.srm590.div2;

public class FoxAndGomoku {
	
	public String win(String[] board)
	{
		String result = "";
		boolean res = false;
		int n  = board.length;
		int i = 0 , j = 0;
		
		for(i = 0 ; i < n ; i++ )
		{
			for(j = 0 ; j < n ; j++)
			{
				if(board[i].charAt(j) == '.')
				{	continue;  }
				else if (board[i].charAt(j) == 'o')
				{
					boolean horizResult = checkHorizontal(board,i,j);
					boolean verticalResult = checkVertical(board,i,j);
					boolean leftRightDiagonal = checkLeftRightDiagonal(board,i,j);
					boolean rightLeftDiagonal = checkRightLeftDiagonal(board,i,j);
					res = horizResult || verticalResult || leftRightDiagonal || rightLeftDiagonal ;
					if(res == true)
						break;
				}
			}
			if(res == true)
				break;
		}
		
		result = res ? "found" : "not found";
		
		return result;
	}

	private boolean checkRightLeftDiagonal(String[] board, int i, int j) {
		boolean res = false;
		int count = 0;
		int n = board.length;
		for(int k = 0 ; k < 5 ; k++)
		{
			if( (i+k < 0) || (j-k < 0))
			{
				break;
			}
			if(board[i+k].charAt(j-k) == 'o')
				count++;
			else 
				break;
		}
		if(count >= 5)
			res = true;
		return res;
	}

	private boolean checkLeftRightDiagonal(String[] board, int i, int j) {
		boolean res = false;
		int count = 0;
		int n = board.length;
		for(int k = 0 ; k < 5 ; k++)
		{
			if( (i+k >= n) || (j+k >=n))
			{
				break;
			}
			if(board[i+k].charAt(j+k) == 'o')
				count++;
			else 
				break;
		}
		if(count >= 5)
			res = true;
		return res;
	}

	private boolean checkVertical(String[] board, int i, int j) {
		int count = 0;
		int n = board.length;
		boolean res = false;
		for(int k = 0 ; k < 5 ; k++)
		{
			if(i+k >= n)
				break;
			if(board[i+k].charAt(j) == 'o')
				count++;
			else 
				break;
		}
		if(count >= 5)
			res = true;
		return res;
	}

	private boolean checkHorizontal(String[] board, int i, int j) {
		int count = 0;
		int n = board.length;
		boolean res = false;
		for(int k = 0 ; k < 5 ; k++)
		{
			if(j+k >= n)
				break;
			if(board[i].charAt(j+k) == 'o')
				count++;
			else
				break;
		}
		if(count >= 5)
			res = true;
		return res;
	}

	public static void main(String[] args) {
		
		String[] board = {"....o.",
						  "...o..",
						  "..o...",
						  ".o....",
						  "o.....",
				 		  "......"};
		
		(new FoxAndGomoku()).win(board);

	}

}
