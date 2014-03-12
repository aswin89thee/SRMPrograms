package com.srm592.div2;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * This is what happens when you attempt a problem at 7 am half asleep.
 * Instead of sorting, I did all this
 *
 */
public class LittleElephantAndBooks {
	
	public int getNumber(int[] pages, int number)
	{
		int ret = 0;
		ArrayList<Integer> pagesRead = new ArrayList<Integer>();
		
		for(int i = 0; i < number ; i++)
		{
			int smallest = pages[0];
			for(int k = 0  ; k < pages.length ; k++)
			{
				if(!pagesRead.contains(pages[k]))
				{
					smallest = pages[k];
					break;
				}
			}
			
			
			for(int j = 0 ; j < pages.length ; j++)
			{
				if(pages[j] < smallest)
				{
					if(!pagesRead.contains(pages[j]))
						smallest = pages[j];
				}
			}
			
			for(int k = 0 ; k < pages.length ; k ++)
			{
				if(pages[k] == smallest)
				{
					if(pagesRead.size() < number)
					{
						pagesRead.add(pages[k]);
					}
				}
			}
		}
		
		
		
		int largestPage = pagesRead.get(0);
		Iterator<Integer> iter = pagesRead.iterator();
		while(iter.hasNext())
		{
			int curPages = iter.next();
			if(curPages > largestPage)
			{
				largestPage = curPages;
			}
		}
//		System.out.println("LargestPage " + largestPage);
		int m = largestPage;
		for(int i = 0 ; i < pages.length ; i ++)
		{
			if(pages[i] > largestPage)
				m = pages[i];
		}
		for(int i = 0 ; i < pages.length ; i++)
		{
			if(pages[i] < largestPage)
				continue;
			if(pages[i] > largestPage && pages[i] < m)
				m = pages[i];
		}

		Integer[] subset = (Integer[]) pagesRead.toArray(new Integer[0]);
//		System.out.println("Array: "+subset[0]);
		int index = pagesRead.indexOf(largestPage);
		subset[index] = m;
//		pagesRead.remove(largestPage);
//		pagesRead.add(m);
		
		ret = 0;
		for(int i = 0 ; i < subset.length ; i ++)
		{
			ret += subset[i];
		}
		
		return ret;
	}
	
//	public static void main(String[] args)
//	{
//		int[] pages = {3, 1, 9, 7, 2, 8, 6, 4, 5};
//		int number = 7;
//		int r = (new LittleElephantAndBooks()).getNumber(pages, number);
//		System.out.println("Ret val: " + r);
//	}

}
