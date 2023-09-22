//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        int l=0,h=arr.length-1,mid=-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(arr[m]==x)
            {
                mid=m;
                break;
            }
            else if(arr[m]>x)
            {
                h--;
            }
            else
            {
                l++;
            }
        }
        if(mid==-1)
        {
            //System.out.println(mid);
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int first=mid;
        while(first>=0 && arr[first]==x)
        {
            first--;
        }
        ans.add(first+1);
        int last=mid;
        while(last<arr.length && arr[last]==x)
        {
            last++;
        }
        ans.add(last-1);
        return ans;
    }
    
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends