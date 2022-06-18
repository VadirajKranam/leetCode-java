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
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode one,TreeNode other)
    {
        if(one==null && other==null)
        {
            return true;
        }
        else if(one==null || other==null)
        {
            return false;
        }
        else if(one!=null && other!=null && one.val!=other.val)
        {
            return false;
        }
        boolean checkleft=isMirror(one.left,other.right);
        boolean checkright=isMirror(one.right,other.left);
        return checkleft&checkright;
    }
}