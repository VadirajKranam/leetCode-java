//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans=new ArrayList<>();
        StringBuilder st=new StringBuilder();
        int[][] vis=new int[n][n];
        for(int[] v:vis)
        {
            Arrays.fill(v,-1);
        }
        function(m,st,ans,vis,0,0);
        return ans;
    }
    public static void function(int[][] m,StringBuilder st,ArrayList<String> ans,int[][] vis,int r,int c)
    {
        if(r>=m.length || c>=m.length ||r<0||c<0|| m[r][c]==0 || vis[r][c]==1 )
        {
            return;
        }
        if(r==m.length-1 && c==m.length-1 && m[r][c]==1)
        {
            ans.add(new String(st));
        }
        vis[r][c]=1;
        st.append('U');
        function(m,st,ans,vis,r-1,c);
        st.deleteCharAt(st.length()-1);
        st.append('D');
        function(m,st,ans,vis,r+1,c);
        st.deleteCharAt(st.length()-1);
        st.append('L');
        function(m,st,ans,vis,r,c-1);
        st.deleteCharAt(st.length()-1);
        st.append('R');
        function(m,st,ans,vis,r,c+1);
        st.deleteCharAt(st.length()-1);
        vis[r][c]=-1;
    }
}