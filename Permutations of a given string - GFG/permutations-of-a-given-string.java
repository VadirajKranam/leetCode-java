//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        List<String> ans=new ArrayList<>();
        // char[] s1=S.tocharArray();
        permute(S,0,S.length()-1,ans);
        Set<String> ans2=new HashSet<>(ans);
        List<String> ans3=new ArrayList<>(ans2);
        Collections.sort(ans3);
        return ans3;
    }
    public void permute(String s,int l,int r,List<String> ans)
    {
        if(l==r)
        {
            ans.add(s);
            return;
        }
        for(int i=l;i<=r;i++)
        {
            s=swap(s,l,i);
            permute(s,l+1,r,ans);
            s=swap(s,l,i);
        }
    }
    public String swap(String s,int i,int j)
    {
        char t;
        char[] temp=s.toCharArray();
        t=temp[i];
        temp[i]=temp[j];
        temp[j]=t;
        return String.valueOf(temp);
    }
}