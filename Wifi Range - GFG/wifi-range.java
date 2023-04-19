//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        int[] reach=new int[S.length()];
        Arrays.fill(reach,-1);
        int temp=0;
        for(int i=0;i<S.length();i++)
        {
            if(temp>0 &&  S.charAt(i)=='0')
            {
                reach[i]=1;
                temp--;
            }
            else if(S.charAt(i)=='1')
            {
                reach[i]=1;
                temp=X;
            }
        }
        temp=0;
         for(int i=S.length()-1;i>=0;i--)
        {
            if(temp>0 &&  S.charAt(i)=='0')
            {
                reach[i]=1;
                temp--;
            }
            else if(S.charAt(i)=='1')
            {
                reach[i]=1;
                temp=X;
            }
        }
        for(int i=0;i<reach.length;i++)
        {
            if(reach[i]==-1)
            {
                return false;
            }
        }
        return true;
    }
} 