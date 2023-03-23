//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   static int res=Integer.MIN_VALUE;
    public static int maxDifferenceBST(Node root,int target)
    {
          Node curNode=root;
          int sum=0;
          while(curNode!=null)
          {
              if(curNode.data==target)
              {
                  break;
              }
              if(target>curNode.data)
              {
                  sum+=curNode.data;
                  curNode=curNode.right;
              }
              else
              {
                  sum+=curNode.data;
                  curNode=curNode.left;
              }
          }
          if(curNode==null)
          {
              return -1;
          }
          else{
         if(curNode.left==null && curNode.right==null)
         {
             return sum;
         }
         res=Integer.MIN_VALUE;
         if(curNode.left!=null)
         {
           solve(curNode.left,0,sum);  
         }
           if(curNode.right!=null)
         {
           solve(curNode.right,0,sum);  
         }
          }
         return res;
    }
    static void solve(Node root,int path_sum,int sum)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            res=Math.max(res,sum-(path_sum+root.data));
            return;
        }
        solve(root.left,path_sum+root.data,sum);
        solve(root.right,path_sum+root.data,sum);
    }
}