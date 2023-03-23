//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] c = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.minimumConnections(n, m, c);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node)
    {
        if(node==parent.get(node))
        {
            return node;
        }
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v)
    {
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v)
        {
            return;
        }
        else if(size.get(ulp_u)<size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else
        {
             parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    public static int minimumConnections(int n, int m, int[][] c) {
        DisjointSet ds=new DisjointSet(n);
        int cntExtra=0;
        for(int i=0;i<m;i++)
        {
            int u=c[i][0];
            int v=c[i][1];
            if(ds.findUPar(u)==ds.findUPar(v))
            {
                cntExtra++;
            }
            else
            {
                ds.unionBySize(u,v);
            }
        }
        int cntC=0;
        for(int i=0;i<n;i++)
        {
            if(ds.parent.get(i)==i)
            {
                cntC++;
            }
        }
        int ans=cntC-1;
        if(ans>cntExtra)
        {
            return -1;
        }
        return ans;
    }
}
        
