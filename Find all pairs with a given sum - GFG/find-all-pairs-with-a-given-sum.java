//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

// class pair  {  
//     long first, second;  
//     public pair(long first, long second)  
//     {  
//         this.first = first;  
//         this.second = second;  
//     }  
// }


class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        ArrayList<ArrayList<Long>> t=new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++)
        {
            long key=X-A[i];
            int l=0,h=B.length-1;
            while(l<=h)
            {
                int mid=l+(h-l)/2;
                if(B[mid]==key)
                {
                    ArrayList<Long> a=new ArrayList<>();
                    
                        
                        a.add(A[i]);
                        a.add(B[mid]);
                    // System.out.println(t);
                   
                    t.add(a);
                    break;
                }
                else if(B[mid]<key)
                {
                    l=mid+1;
                }
                else
                {
                    h=mid-1;
                }
            }
        }
        Comparator<ArrayList<Long>> myComparator = new Comparator<ArrayList<Long>>() {
        @Override
        public int compare(ArrayList<Long> o1, ArrayList<Long> o2) {
            return o1.get(0).compareTo(o2.get(0));
        }
    };
    Collections.sort(t, myComparator);
         pair[] ans=new pair[t.size()];
        for(int i=0;i<t.size();i++)
        {
            ans[i]=new pair(t.get(i).get(0),t.get(i).get(1));
        }
        return ans;
    }
}