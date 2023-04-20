/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node;
    int ind;
    Pair(TreeNode node,int ind)
    {
        this.node=node;
        this.ind=ind;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
         int ans=0;
        
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        { 
            int start=q.peek().ind;
            int end=0;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                end=q.peek().ind;
                TreeNode node=q.peek().node;
                q.poll();
                if(node.left!=null)
                {
                    q.offer(new Pair(node.left,2*(end)));
                }
                if(node.right!=null)
                {
                    q.offer(new Pair(node.right,2*end+1));
                }
            }
            ans=Math.max(ans,end-start+1);
        }
        return ans;
    }
}