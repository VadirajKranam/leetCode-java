//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

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
    public boolean isValid(int r,int c,int[][] grid)
    {
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length;
    }
    public int MaxConnection(int grid[][]) {
       DisjointSet ds=new DisjointSet(grid.length*grid.length);
       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[i].length;j++)
           {
               if(grid[i][j]==0)
               {
                   continue;
               }
               int[] dr={-1,0,1,0};
               int[] dc={0,-1,0,1};
              for(int ind=0;ind<4;ind++)
              {
                  int newr=i+dr[ind];
                  int newc=j+dc[ind];
                  if(isValid(newr,newc,grid) && grid[newr][newc]==1){
                      int nodeNo=i*grid.length+j;
                      int adjNode=newr*grid.length+newc;
                      ds.unionBySize(nodeNo,adjNode);
                  }
              }
           }
       }
       //step 2
       int mx=0;
       for(int row=0;row<grid.length;row++)
       {
           for(int col=0;col<grid[row].length;col++)
           {
               if(grid[row][col]==1)
               {
                   continue;
               }
                int[] dr={-1,0,1,0};
                int[] dc={0,-1,0,1};
                Set<Integer> components=new HashSet<>();
                for(int ind=0;ind<4;ind++)
                {
                    int newr=row+dr[ind];
                    int newc=col+dc[ind];
                    if(isValid(newr,newc,grid))
                    {
                        if(grid[newr][newc]==1)
                        {
                            components.add(ds.findUPar((newr*(grid.length)+newc)));
                        }
                    }
                }
                int sizeTotal=0;
                for(Integer parents:components){
                    sizeTotal+=ds.size.get(parents);
                }
                mx=Math.max(mx,sizeTotal+1);
           }
       }
       for(int cellNo=0;cellNo<grid.length*grid.length;cellNo++)
       {
           mx=Math.max(mx,ds.size.get(ds.findUPar(cellNo)));
       }
       return mx;
    }
    
}










