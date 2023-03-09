//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a1[] = new long[(int)(n)];
            long a2[] = new long[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Compute obj = new Compute();
            System.out.println(obj.isSubset( a1, a2, n, m));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        
        Map<Long,Long> m1=new HashMap<>();
        Map<Long,Long> m2=new HashMap<>();
        for(int i=0;i<a1.length;i++)
        {
            if(m1.get(a1[i])!=null)
            {
                m1.put(a1[i],m1.get(a1[i])+1);
                continue;
            }
            m1.put(a1[i],(long)1);
        }
         for(int i=0;i<a2.length;i++)
        {
            if(m2.get(a2[i])!=null)
            {
                m2.put(a2[i],m2.get(a2[i])+1);
                continue;
            }
            m2.put(a2[i],(long)1);
        }
        for(Map.Entry<Long,Long> e:m2.entrySet())
        {
            if(!m1.containsKey(e.getKey()))
            {
                return "No";
            }
            else if(m1.get(e.getKey())<e.getValue())
            {
                return "No";
            }
        }
        return "Yes";
    }
}