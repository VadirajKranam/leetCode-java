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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        StringBuilder ans=new StringBuilder();
        int[] count=new int[26];
        Arrays.fill(count,0);
        //ans.append(A.charAt(0));
        //count[A.charAt(0)-97]+=1;
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<A.length();i++)
        {
            if(!m.containsKey(A.charAt(i)))
            {
                m.put(A.charAt(i),i);
            }
        }
        
        for(int i=0;i<A.length();i++)
        {
            count[A.charAt(i)-97]+=1;
            int idx=-1,max=A.length()-1;
            for(int j=0;j<count.length;j++)
            {
                if(count[j]==1 && m.get((char)(j+97))<=max)
                {
                    idx=j;
                    max=m.get((char)(j+97));
                }
            }
            
            if(idx!=-1)
            {
                char ch=(char)(idx+97);
                ans.append(ch);
            }
            else
            {
                ans.append('#');
            }
        }
      
        return ans.toString();
    }
}