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
class Solution {
    int max=0;
    public int longestZigZag(TreeNode root) {
        if(root==null)
        {
            return -1;
        }
        max=0;
        helper(root.right,1,true);
        helper(root.left,1,false);
        return max;
    }
    public void helper(TreeNode node,int steps,boolean isRight)
    {
        if(node==null)
        {
            return;
        }
        max=Math.max(max,steps);
        if(isRight)
        {
          helper(node.left,steps+1,false);
          helper(node.right,1,true);
        }
        else
        {
           helper(node.right,steps+1,true);
          helper(node.left,1,false); 
        }
    }
}