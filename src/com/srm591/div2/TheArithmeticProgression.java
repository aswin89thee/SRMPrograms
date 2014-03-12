package com.srm591.div2;

public class TheArithmeticProgression {

	public double minimumChange(int a, int b, int c)
	{
		double minChange = 0;
		
		if(b-a == c-b)
		{
			minChange = 0;
		}
		else
		{
			double sub = 0;
			if(c >= a)
			{
				sub = ((double)c-a)/2.0;
				minChange = b - a - sub;
			}
			else
			{
				sub = ((double)a-c)/2.0;
				minChange = b - c - sub;
			}
		}
		
		return Math.abs(minChange);
	}
}
