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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        ArrayList<ArrayList<TreeNode>> bfs=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0;
        ArrayList<TreeNode> temp=new ArrayList<>();
        temp.add(root);
        bfs.add(temp);
        while(!q.isEmpty())
        {
            int size=q.size();
            ArrayList<TreeNode> b=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node.left!=null)
                {
                    q.offer(node.left);
                }
                if(node.right!=null)
                {
                    q.offer(node.right);
                }
                b.add(node.left);
                b.add(node.right);
            }
            bfs.add(b);
        }
        for(int i=0;i<bfs.size();i++)
        {
            for(int j=0;j<bfs.get(i).size();j++)
            {
                if(bfs.get(i).get(j)==null)
                {
                    System.out.print("null"+" ");
                    continue;
                }
                System.out.print(bfs.get(i).get(j).val+" ");
            }
            System.out.println();
        }
        for(int i=0;i<bfs.size()-2;i++)
        {
            for(int j=0;j<bfs.get(i).size();j++)
            {
                if(bfs.get(i).get(j)==null)
                {
                    return false;
                }
            }
        }
        for(int i=1;i<bfs.get(bfs.size()-2).size();i++)
        {
            if(bfs.get(bfs.size()-2).get(i-1)==null && bfs.get(bfs.size()-2).get(i)!=null)
            
            {
                return false;
            }
            
        }
        return true;
    }
}