//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends




//User function Template for Java

class Solution
{
    //static int count=0;
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        boolean noEmpty=false;
        int r=-1;
        int c=-1;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==0)
                {
                    r=i;
                    c=j;
                    noEmpty=true;
                    break;
                }
            }
            if(noEmpty)
            {
                break;
            }
        }
        if(!noEmpty)
        {
            //count+=1;
            //printGrid(grid);
            return true;
        }
        for(int num=1;num<=9;num++)
        {
            if(isValid(r,c,num,grid))
            {
                grid[r][c]=num;
                if(SolveSudoku(grid))
                {
                    return true;
                }
                else{
                grid[r][c]=0;
                }
            }
        }
        return false;
    }
    static boolean isValid(int r,int c,int num,int[][] grid)
    {
        for(int i=0;i<grid.length;i++)
        {
            if(grid[r][i]==num)
            {
                return false;
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][c]==num)
            {
                return false;
            }
        }
        int sqrt=(int)Math.sqrt(grid.length);
        int sr=r-r%sqrt;
        int sc=c-c%sqrt;
        for(int i=sr;i<sr+sqrt;i++)
        {
            for(int j=sc;j<sc+sqrt;j++)
            {
                if(grid[i][j]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {

       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[i].length;j++)
           {
               System.out.print(grid[i][j]+" ");
           }
       }
    }
}