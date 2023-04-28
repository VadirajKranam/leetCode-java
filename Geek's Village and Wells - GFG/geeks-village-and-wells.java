//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Trio{
    int a,b,c;
    Trio(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
class Solution
{
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int[][] ans=new int[c.length][c[0].length];
        for(int[] a:ans)
        {
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        boolean[][] vis=new boolean[c.length][c[0].length];
        Queue<Trio> q=new LinkedList<>();
        for(int i=0;i<c.length;i++)
        {
            for(int j=0;j<c[i].length;j++)
            {
                if(c[i][j]=='W')
                {
                    vis[i][j]=true;
                    ans[i][j]=0;
                    q.offer(new Trio(i,j,0));
                }
            }
        }
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        while(!q.isEmpty())
        {
            Trio p=q.poll();
            for(int i=0;i<4;i++)
            {
                int x=p.a+dx[i],y=p.b+dy[i];
                if(x>=0 && x<c.length && y>=0 && y<c[x].length && !vis[x][y] && c[x][y]!='N')
                {
                    q.offer(new Trio(x,y,p.c+1));
                    vis[x][y]=true;
                    ans[x][y]=p.c+1;
                }
            }
        }
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[i].length;j++)
            {
                if(c[i][j]=='.' || c[i][j]=='N')
                {
                    ans[i][j]=0;
                }
                else if(ans[i][j]==Integer.MAX_VALUE)
                {
                    ans[i][j]=-1;
                }
                else 
                {
                    ans[i][j]*=2;
                }
            }
        }
        return ans;
    }
}



