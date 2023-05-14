//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String p, String s)
    {
        int[][] dp=new int[p.length()][s.length()];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(p.length()-1,s.length()-1,p,s,dp)?1:0;
    }
    boolean function(int i1,int i2,String p,String s,int[][] dp)
    {
        if(i1<0 && i2<0)
        {
            return true;
        }
        if(i1<0 && i2>=0)
        {
            return false;
        }
        if(i1>=0 && i2<0)
        {
            while(i1>=0)
            {
                if(p.charAt(i1)!='*')
                {
                    return false;
                }
                i1--;
            }
            return true;
        }
        if(dp[i1][i2]!=-1)
        {
            return dp[i1][i2]==1;
        }
        if(p.charAt(i1)==s.charAt(i2) || p.charAt(i1)=='?')
        {
            dp[i1][i2]=1;
            return function(i1-1,i2-1,p,s,dp);
        }
        else if(p.charAt(i1)=='*')
        {
            boolean f1=function(i1-1,i2,p,s,dp);
            boolean f2=function(i1,i2-1,p,s,dp);
            if(f1||f2)
            {
                dp[i1][i2]=1;
            }
            else
            {
                dp[i1][i2]=0;
            }
            return f1||f2;
        }
        dp[i1][i2]=0;
        return p.charAt(i1)==s.charAt(i2);
    }
}
