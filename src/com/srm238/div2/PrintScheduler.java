package com.srm238.div2;

public class PrintScheduler {
	public String getOutput(String[] threads, String[] slices)
	{
		String output = "";
		int i = 0;
		int nthreads = threads.length;
		int[] position = new int[nthreads];
		//initialize position in threads to zero
		for(i = 0 ; i < nthreads ; i++)
		{
			position[i] = 0;
		}
		
		//begin processing
		for(i = 0 ; i < slices.length ; i++)
		{
			String[] pair = slices[i].split(" ");
			int threadno = Integer.parseInt(pair[0]);
			int frequency = Integer.parseInt(pair[1]);
//			System.out.println("Executing " + threadno +"th thread " + frequency + " times");
			for(int j = 0 ; j < frequency ; j++)
			{
				output += threads[threadno].charAt(position[threadno]);
				position[threadno] = (position[threadno] + 1) % (threads[threadno].length());
			}
		}
		return output;
	}
}
