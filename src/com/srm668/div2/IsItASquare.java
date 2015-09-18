package com.srm668.div2;

public class IsItASquare {
	
	public String isSquare(int[] x, int[] y)
	{
		double d12 = dist(x[0],y[0],x[1],y[1]);
		double d13 = dist(x[0],y[0],x[2],y[2]);
		double d14 = dist(x[0],y[0],x[3],y[3]);
		double d34 = dist(x[2],y[2],x[3],y[3]);
		double d23 = dist(x[1],y[1],x[2],y[2]);
		double d24 = dist(x[1],y[1],x[3],y[3]);
		if(d12 != d13 && d12 != d14)
			return "Not a square";
		if(d12 == d13)
		{
			if(d24 == d34 && d24 == d12 && isPythagoras(d12,d13,d23))
				return "It's a square";
			return "Not a square";
		}
		else if(d12 == d14)
		{
			if(d23 == d34 && d23 == d12 && isPythagoras(d12, d14, d24))
				return "It's a square";
			return "Not a square";
		}
		return "Not a square";
	}
	
	boolean isPythagoras(double a, double b, double c)
	{
		double csq = Math.pow(c, 2);
		double asq = Math.pow(a, 2);
		double bsq = Math.pow(b, 2);
		return (Math.round(csq) == Math.round(asq + bsq));
	}
	
	double dist(int x1, int y1, int x2, int y2)
	{
		double d1 = Math.pow((x2-x1), 2);
		double d2 = Math.pow((y2-y1), 2);
		double dist = Math.sqrt(d1+d2);
		return dist;
	}

	public static void main(String[] args) {
		int[] a = {0, 0, 2, 2};
		int[] b = {0, 2, 0, 2};
		IsItASquare obj = new IsItASquare();
		System.out.println(obj.isSquare(a, b));
	}

}
