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
    public boolean findTarget(TreeNode root, int k) {
        List<List<Integer>> outer=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode t=root;
        q.offer(t);
        while(!q.isEmpty())
        {
            List<Integer> inner=new ArrayList<>();
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                if(q.peek().left!=null)
                {
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null)
                {
                    q.offer(q.peek().right);
                }
                inner.add(q.poll().val);
            }
            outer.add(inner);
        }
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<outer.size();i++)
        {
            for(int j=0;j<outer.get(i).size();j++)
            {
                a.add(outer.get(i).get(j));
            }
        }
        Collections.sort(a);
        int i=0,j=a.size()-1;
        while(i<j)
        {
            if(a.get(i)+a.get(j)==k)
            {
                return true;
            }
            else if(a.get(i)+a.get(j)<k)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return false;
    }
}