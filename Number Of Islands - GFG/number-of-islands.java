//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java
class DisjointSet{
   List<Integer> rank=new ArrayList<>();
   List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
   DisjointSet(int n){
       for(int i=0;i<=n;i++){
           rank.add(0);
           parent.add(i);
           size.add(1);
       }
   }
   public int findUPar(int node){
       if(node==parent.get(node))
       {
           return node;
       }
       int ulp=findUPar(parent.get(node));
       parent.set(node,ulp);
       return parent.get(node);
   }
   public void unionByRank(int u,int v){
       int ulp_u=findUPar(u);
       int ulp_v=findUPar(v);
       if(ulp_u==ulp_v)
       {
           return;
       }
       else if(rank.get(ulp_u)<rank.get(ulp_v)){
           parent.set(ulp_u,ulp_v);
       }
       else if(rank.get(ulp_u)>rank.get(ulp_v)){
           parent.set(ulp_v,ulp_u);
       }
       else{
           parent.set(ulp_v,ulp_u);
           rank.set(ulp_u,rank.get(ulp_u)+1);
       }
   }
    public void unionBySize(int u,int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    boolean isValid(int adjR,int adjC,int n,int m)
    {
        return adjR>=0 && adjR<n && adjC>=0 && adjC<m;
    }
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        List<Integer> ans=new ArrayList<>();
        DisjointSet ds=new DisjointSet(n*m);
        int[][] vis=new int[n][m];
        int cnt=0;
         for(int i=0;i<operators.length;i++)
         {
             int row=operators[i][0];
             int col=operators[i][1];
             if(vis[row][col]==1)
             {
                 ans.add(cnt);
                 continue;
             }
             vis[row][col]=1;
             cnt++;
             int[] dr={-1,0,1,0};
             int[] dc={0,1,0,-1};
             for(int j=0;j<4;j++)
             {
                 int adjR=row+dr[j];
                 int adjC=col+dc[j];
                 if(isValid(adjR,adjC,n,m))
                 {
                     if(vis[adjR][adjC]==1)
                     {
                         int nodeNo=row*m+col;
                         int adjNodeNo=adjR*m+adjC;
                         if(ds.findUPar(nodeNo)!=ds.findUPar(adjNodeNo)){
                             cnt--;
                             ds.unionBySize(nodeNo,adjNodeNo);
                         }
                     }
                 }
             }
             ans.add(cnt);
         }
            return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends