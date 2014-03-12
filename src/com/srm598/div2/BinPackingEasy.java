package com.srm598.div2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinPackingEasy {
	
	public int minBins(int[] item)
	{
		int minBins = 0;
		int bins = 0;
		Arrays.sort(item);
		ArrayList itemList = new ArrayList();
		for(int i = 0 ; i < item.length ; i++)
		{
			itemList.add(item[i]);
		}
		
		for(int i = 0 ; i < item.length ; i++)
		{
			if(itemList.size() == 1)
			{
				bins++;
				break;
			}
			if(itemList.size() == 0) { break; }
			if(fillABin(itemList))
			{
				bins++;
			}
		}
		minBins = bins;
		return minBins;
	}
	
	boolean fillABin(List itemList)
	{
		boolean filled = true;
		boolean foundAMatch = false; 
		int largestMatch = 0;
		int a = (int) itemList.get(itemList.size()-1);
		int aindex = itemList.size()-1;
		int largestMatchIndex = -1;
		for(int j = itemList.size()-2 ; j >= 0 ; j--)
		{
			int b = (int) itemList.get(j);
			if(a+b <= 300)
			{
				foundAMatch = true;
				if(b > largestMatch)
				{
					largestMatch = b;
					largestMatchIndex = j;
				}
			}
		}
		
		if(foundAMatch)
		{
			if(aindex != largestMatchIndex)
			{
				itemList.remove(aindex);
				itemList.remove(largestMatchIndex);
				filled = true;
			}
			else
			{
				itemList.remove(aindex);
			}
		}
		else
		{
			itemList.remove(aindex);
		}
		
		return filled;
	}
	
	
	public static void main(String[] args)
	{
		BinPackingEasy obj = new BinPackingEasy();
		int[] item = {123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198};
		System.out.println("Ans: " + obj.minBins(item));
	}

}
