//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	   ArrayList<Integer> ans=new ArrayList<>();
	   int top=0,bottom=a.length-1,right=a[0].length-1,left=0;
	   while(top<=bottom && left<=right)
	   {
	       for(int i=left;i<=right;i++)
	       {
	           ans.add(a[top][i]);
	       }
	       top++;
	       for(int i=top;i<=bottom;i++)
	       {
	           ans.add(a[i][right]);
	       }
	       right--;
	       if(top<=bottom)
	       {
	           for(int i=right;i>=left;i--)
	           {
	               ans.add(a[bottom][i]);
	           }
	           bottom--;
	       }
	       if(left<=right)
	       {
	           for(int i=bottom;i>=top;i--)
	           {
	               ans.add(a[i][left]);
	           }
	           left++;
	       }
	   }
	   return ans.get(k-1);
	}
	
}