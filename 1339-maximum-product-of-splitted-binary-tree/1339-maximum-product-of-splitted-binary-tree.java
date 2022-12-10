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
    public int getSum(TreeNode root,ArrayList<Integer> a)
    {
        if(root==null)
        {
            return 0;
        }
        int ls=getSum(root.left,a);
        int rs=getSum(root.right,a);
        int ts=root.val+ls+rs;
        a.add(ts);
        return ts;
    }
    public int maxProduct(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        long max=0;
        ArrayList<Integer> a=new ArrayList<>();
        int sum=getSum(root,a);
        for(long t:a)
        {
            long pro=t*(sum-t);
            max=Math.max(max,pro);
        }
        return (int)(max%1000000007);
    }
}