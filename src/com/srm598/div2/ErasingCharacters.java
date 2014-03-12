package com.srm598.div2;

public class ErasingCharacters {
	
	
	public String simulate(String s)
	{
		String ret = "";
		StringBuffer buf = new StringBuffer(s);
		boolean changed = true;
		
		while(changed)
		{
			changed = false;
			for(int i = 0 ; i < buf.capacity(); i++)
			{
				if(buf.toString().length() == 0)
				{
					break;
				}
				else if(i == buf.toString().length() - 1)
				{
					break;
				}
				else if(buf.charAt(i) == buf.charAt(i+1))
				{
					buf.deleteCharAt(i+1);
					buf.deleteCharAt(i);
					changed = true;
					break;
				}
			}
		}
		ret = buf.toString();
		return ret;
	}


}
