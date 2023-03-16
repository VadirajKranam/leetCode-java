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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return function(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode function(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd)
    {
        if(inStart>inEnd||postStart>postEnd)
        {
            return null;
        }
        TreeNode root=new TreeNode(postorder[postEnd]);
        int rootIndex=0;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==root.val)
            {
                rootIndex=i;
                break;
            }
        }
        int leftSize=rootIndex-inStart;
        int rightSize=inEnd-rootIndex;
        root.left=function(inorder,inStart,rootIndex-1,postorder,postStart,postStart+leftSize-1);
        root.right=function(inorder,rootIndex+1,inEnd,postorder,postEnd-rightSize,postEnd-1);
        return root;
    }
}