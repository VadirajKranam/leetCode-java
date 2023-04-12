//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting{
    int s,e,p;
    Meeting(int s,int e,int p)
    {
        this.s=s;
        this.e=e;
        this.p=p;
    }
}
class meetingSort implements Comparator<Meeting>
{
    @Override
    public int compare(Meeting o1,Meeting o2)
    {
        if(o1.e<o2.e)
        {
            return -1;
        }
        else if(o1.e>o2.e)
        {
            return 1;
        }
        else if(o1.p<o2.p)
        {
            return -1;
        }
        return 1;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meeting> ar=new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
            ar.add(new Meeting(start[i],end[i],i+1));
        }
        Collections.sort(ar,new meetingSort());
        int ans=1;
        int limit=ar.get(0).e;
        for(int i=1;i<ar.size();i++)
        {
            if(ar.get(i).s>limit)
            {
                ans++;
                limit=ar.get(i).e;
            }
        }
        return ans;
    }
}
