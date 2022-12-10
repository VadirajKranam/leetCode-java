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
    long max=0;
    long sum=0;
    public int maxProduct(TreeNode root) {
        sum=dfs(root);
        solve(root);
        return (int)(max%1000000007);
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return root.val=root.val+dfs(root.left)+dfs(root.right);
    }
    public void solve(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        max=Math.max(max,root.val*(sum-root.val));
        solve(root.left);
        solve(root.right);
    }
}