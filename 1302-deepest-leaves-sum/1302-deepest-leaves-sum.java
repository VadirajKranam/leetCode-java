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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(root==null)
        {
            return 0;
        }
        TreeNode node=root;
        q.offer(node);
        while(!q.isEmpty())
        {
            List<Integer> sublist=new ArrayList<>();
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
                sublist.add(q.poll().val);
            }
            ans.add(sublist);
        }
        int sum=0;
        for(int i=ans.get(ans.size()-1).size()-1;i>=0;i--)
        {
            sum=sum+ans.get(ans.size()-1).get(i);
        }
        return sum;
    }
}