//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(H[0]);
        for(int i=1;i<H.length;i++)
        {
            if(H[i]>ans.get(ans.size()-1))
            {
                ans.add(H[i]);
            }
            else
            {
                int ind=Collections.binarySearch(ans,H[i]);
                if(ind<0)
                {
                    int realInd=(ind+1)*-1;
                    if(realInd>ans.size()-1)
                    {
                        ans.add(H[i]);
                    }
                    else
                    {
                        ans.set(realInd,H[i]);
                    }
                }
                else
                {
                    ans.set(ind,H[i]);
                }
            }
        }
        return N-ans.size();
    }
};