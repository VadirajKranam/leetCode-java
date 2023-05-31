//{ Driver Code Starts
//Initial Template for Java
import java.util.*;

class GFG 
{
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++)
		     arr[i] = sc.nextInt();
		     
		    Geeks obj = new Geeks();
		    obj.SortedDuplicates(arr, n);
		    System.out.println();  // print the newline
		    
		}
	}
}




// } Driver Code Ends
//User function Template for Java

/* Helper class containing function SortedDuplicates
containg arguments
arr[]: the duplicated array
n: size of the array
*/
class Geeks
{
    // print the elements which appear more than
    // once in the array in sorted order
    public static void SortedDuplicates(int arr[], int n)
    {
       Map<Integer,Integer> m=new HashMap<>();
       for(int i=0;i<arr.length;i++)
       {
           m.put(arr[i],m.getOrDefault(arr[i],0)+1);
       }
       ArrayList<Integer> s=new ArrayList<>();
       for(Map.Entry<Integer,Integer> e:m.entrySet())
       {
           if(e.getValue()>1)
           {
               s.add(e.getKey());
           }
       }
       //System.out.println(s.size());
       if(s.size()==0)
       {
           System.out.print(-1);
           return;
       }
       Collections.sort(s);
       
       for(int n1:s)
       {
           System.out.print(n1+" ");
       }
     }
    
}
   

//{ Driver Code Starts.

// } Driver Code Ends