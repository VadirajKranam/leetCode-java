//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	   String s1="pr";
	   String s2="rp";
	   if(X<Y)
	   {
	       int temp=X;
	       X=Y;
	       Y=temp;
	       String t=s1;
	       s1=s2;
	       s2=t;
	   }
	   Stack<Character> st=new Stack<>();
	   long ans=0;
	   
	   for(int i=S.length()-1;i>=0;i--)
        {
            if(st.isEmpty())
            {
                st.push(S.charAt(i));
                continue;
            }
            if(S.charAt(i)==s1.charAt(0) && st.peek()==s1.charAt(1))
            {
                ans+=X;
                st.pop();
            }
            else
            {
                st.push(S.charAt(i));
            }
        }
       StringBuilder temp=new StringBuilder();
       while(!st.isEmpty())
       {
           temp.append(st.pop());
       }
       S=temp.toString();
       
       for(int i=temp.length()-1;i>=0;i--)
        {
            if(st.isEmpty())
            {
                st.push(temp.charAt(i));
                continue;
            }
            if(temp.charAt(i)==s2.charAt(0) && st.peek()==s2.charAt(1))
            {
                ans+=Y;
                st.pop();
            }
            else
            {
                st.push(temp.charAt(i));
            }
        }
        return ans;
	}
} 
