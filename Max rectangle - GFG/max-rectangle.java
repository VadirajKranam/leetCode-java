//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        int[] hist=new int[m];
        Arrays.fill(hist,0);
        int max=0;
        for(int i=0;i<M.length;i++)
        {
            for(int j=0;j<M[i].length;j++)
            {
                if(M[i][j]==1)
                {
                    hist[j]++;
                }
                else
                {
                    hist[j]=0;
                }
            }
            max=Math.max(max,function(hist));
        }
        return max;
    }
    public int function(int[] hist)
    {
        Stack<Integer> st=new Stack<>();
        int[] ls=new int[hist.length];
        int[] rs=new int[hist.length];
        Arrays.fill(ls,0);
        Arrays.fill(rs,0);
        for(int i=0;i<hist.length;i++)
        {
            while(!st.isEmpty() && hist[st.peek()]>=hist[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ls[i]=0;
            }
            else
            {
                ls[i]=st.peek()+1;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            st.pop();
        }
        for(int i=hist.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && hist[st.peek()]>=hist[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                rs[i]=hist.length-1;
            }
            else
            {
                rs[i]=st.peek()-1;
            }
            st.push(i);
        }
        int maxAns=0;
        for(int i=0;i<ls.length;i++)
        {
            maxAns=Math.max(maxAns,(rs[i]-ls[i]+1)*hist[i]);
        }
        return maxAns;
    }
}