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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ans1=new ArrayList<>();
        ArrayList<Integer> ans2=new ArrayList<>();
         preOrder(root1,ans1);
         preOrder(root2,ans2);
       if(ans1.size()!=ans2.size())
       {
           return false;
       }
        for(int i=0;i<ans1.size();i++)
        {
            if(ans1.get(i)!=ans2.get(i))
            {
                return false;
            }
        }
        return true;
    }
    public static void preOrder(TreeNode root,ArrayList<Integer> ans)
    {
        if(root==null)
        {
           return; 
        }
        if(root.left==null && root.right==null)
        {
            ans.add(root.val);
        }
        preOrder(root.left,ans);
        preOrder(root.right,ans);
    }
}