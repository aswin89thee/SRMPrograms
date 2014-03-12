package com.srm612.div2;

public class LeftAndRightHandedDiv2 {
	
	public int count(String S)
	{
		int ret = 0;
		if(S.length() == 1) return ret;
		
		for(int i = 0; i < S.length()-1; i++)
		{
			if(S.charAt(i) == 'R' && S.charAt(i+1) == 'L')
				ret++;
		}
		
		return ret;
	}
	
	
	public static void main(String[] args)
	{
		LeftAndRightHandedDiv2 o = new LeftAndRightHandedDiv2();
		System.out.println(o.count("L"));
	}

}
