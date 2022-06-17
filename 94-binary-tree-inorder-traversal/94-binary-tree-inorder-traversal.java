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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        if(root==null)
        {
            return ans;
        }
        TreeNode node=root;
        while(true)
        {
            if(node!=null)
            {
                s.push(node);
                node=node.left;
            }
            else
            {
                if(s.isEmpty())
                {
                    break;
                }
                node=s.pop();
                ans.add(node.val);
                node=node.right;
            }
        }
        return ans;
    }
}