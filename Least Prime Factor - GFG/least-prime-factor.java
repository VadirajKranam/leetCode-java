//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        boolean[] primes=new boolean[n+1];
        Arrays.fill(primes,true);
        for(int p=2;p*p<=n;p++)
        {
            if(primes[p]==true)
            {
                for(int i=p*p;i<=n;i+=p)
                {
                   primes[i]=false; 
                }
            }
        }
        ArrayList<Integer> p=new ArrayList<>();
        for(int i=0;i<primes.length;i++)
        {
            if(primes[i] && i>1)
            {
                p.add(i);
            }
        }
        int[] ans=new int[n+1];
        ans[0]=0;
        ans[1]=1;
        for(int i=2;i<ans.length;i++)
        {
            for(int j=0;j<p.size();j++)
            {
                if(i%p.get(j)==0)
                {
                    ans[i]=p.get(j);
                    break;
                }
            }
        }
        return ans;
    }
}