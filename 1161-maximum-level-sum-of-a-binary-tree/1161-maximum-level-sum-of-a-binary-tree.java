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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        int ans=0;
        int v=Integer.MIN_VALUE;
        if(root==null)
        {
            return 0;
        }
        q.offer(root);
        int k=0;
        while(!q.isEmpty())
        {
            int sum=0;
            int level=q.size();
            for(int i=0;i<level;i++)
            {
                if(q.peek().left!=null)
                {
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null)
                {
                    q.offer(q.peek().right);
                }
                sum=sum+q.poll().val;
            }
            k++;
            if(sum>v)
            {
                v=sum;
                ans=k;
            }
        }
        return ans;
    }
}