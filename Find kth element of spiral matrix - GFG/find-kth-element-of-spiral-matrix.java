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
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int s)
    {
	   	ArrayList<Integer> arr=new ArrayList<>();
	   	int r=n,c=m;
	   	int l=0,k=0;
	   	while(k<r && l<c)
	   	{
	   	    for(int i=l;i<c;i++)
	   	    {
	   	        arr.add(A[k][i]);
	   	    }
	   	    k++;
	   	    for(int i=k;i<r;i++)
	   	    {
	   	        arr.add(A[i][c-1]);
	   	    }
	   	    c--;
	   	    if(k<r)
	   	    {
	   	        for(int i=c-1;i>=l;i--)
	   	        {
	   	            arr.add(A[r-1][i]);
	   	        }
	   	        r--;
	   	    }
	   	    if(l<c)
	   	    {
	   	        for(int i=r-1;i>=k;i--)
	   	        {
	   	            arr.add(A[i][l]);
	   	        }
	   	        l++;
	   	    }
	   	}
        //System.out.println(arr);
	   	return arr.get(s-1);
    }
}