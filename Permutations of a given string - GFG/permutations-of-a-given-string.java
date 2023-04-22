//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
          List<String> ans=new ArrayList<>();
          char[] s2=S.toCharArray();
          Arrays.sort(s2);
          function(0,s2,ans);
          Collections.sort(ans);
          return ans;
    }
    public void function(int ind,char[] s,List<String> ans)
    {
        if(ind==s.length)
        {
            ans.add(new String(s));
            return;
        }
        for(int i=ind;i<s.length;i++)
        {
            if(i>ind && s[i]==s[i-1])
            {
                continue;
            }
            swap(i,ind,s);
            function(ind+1,s,ans);
            swap(i,ind,s);
        }
    }
    public void swap(int i1,int i2,char[] s)
    {
        char t=s[i1];
        s[i1]=s[i2];
        s[i2]=t;
    }
}