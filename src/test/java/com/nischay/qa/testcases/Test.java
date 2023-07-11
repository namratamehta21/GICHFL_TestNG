package com.nischay.qa.testcases;

public class Test 
{

	public static void main(String[] args)
	
	{
		int[] arr= {1,0,2,1,1,0,2,2,0};
		int n=arr.length;
		int count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=1;j<n;j++)
			{
				if(arr[i]==arr[j])
				{
					count=count+1;
				}
			}
		}
		

	}

}
