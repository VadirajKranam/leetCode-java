//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Solution().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java
class Pair{
    int num,freq;
    Pair(int num,int freq)
    {
        this.num=num;
        this.freq=freq;
    }
}
class Solution
{
    //Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        Map<Integer,Integer> m=new HashMap<>();
        ArrayList<Pair> a=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e:m.entrySet())
        {
            a.add(new Pair(e.getKey(),e.getValue()));
        }
        Collections.sort(a,new Comparator<Pair>(){
            @Override
            public int compare(Pair p1,Pair p2)
            {
                if(p1.freq<p2.freq)
                {
                    return 1;
                }
                if(p1.freq>p2.freq)
                {
                    return -1;
                }
                if(p1.num>p2.num)
                {
                    return 1;
                }
                return -1;
            }
        });
        ArrayList<Integer> ans=new ArrayList<>();
        for(Pair p:a)
        {
            int count=m.get(p.num);
            while(count>0)
            {
                ans.add(p.num);
                count--;
            }
        }
        return ans;
    }
}