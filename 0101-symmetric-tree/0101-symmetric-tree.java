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
    public boolean isSymmetric(TreeNode root) {
        return function(root,root);
    }
    public boolean function(TreeNode left,TreeNode right)
    {
       if(left==null && right==null)
       {
           return true;
       }
        if(left==null || right==null)
        {
            return false;
        }
        if(left!=null && right!=null && left.val!=right.val)
        {
            return false;
        }
        boolean a1 = function(left.left,right.right);
        boolean a2=function(left.right,right.left);
        return a1&a2;
    }
}