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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        function(root,ans);
        return ans;
    }
    public void function(TreeNode root,List<Integer> ans)
    {
        if(root==null)
        {
            return;
        }
        ans.add(root.val);
        function(root.left,ans);
        function(root.right,ans);
        
    }
}