package com.srm305.div2;

public class MultiRead {
	
	public int minCycles(String trace, int procs)
	{
		int cycles = 0;
		int i = 0;
		while(i < trace.length())
		{
			if(trace.charAt(i) == 'W')
			{
				cycles++;
				i++;
				continue;
			}
			else{
				for(int j = 0 ; (j < procs && i < trace.length() && trace.charAt(i) != 'W') ; j++)
				{
					i++;
				}
				cycles++;
			}
		}
		return cycles;
	}
}
