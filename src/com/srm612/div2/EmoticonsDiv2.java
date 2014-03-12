package com.srm612.div2;

public class EmoticonsDiv2 {
	
	
	public 
	int printSmiles(int smiles)
	{
		int ret = 0;
		ret = getSmiles(smiles,1,0,1);
		return ret;
	}
	
	
	private int getSmiles(int smiles, int k, int curCost, int prevVal) {
		if(k==smiles) return curCost;
		if(k > smiles) return -1;
		curCost++;
		int path2 = getSmiles(smiles,2*k,curCost+1,k);
		if(path2 != -1) return path2;
		int path1 = getSmiles(smiles,k+prevVal,curCost,prevVal);
		if(path1 != -1) return path1;
		return -1;
	}

	public static void main(String[] args) {
		
		EmoticonsDiv2 o = new EmoticonsDiv2();
		System.out.println(o.printSmiles(1000));

	}

}
