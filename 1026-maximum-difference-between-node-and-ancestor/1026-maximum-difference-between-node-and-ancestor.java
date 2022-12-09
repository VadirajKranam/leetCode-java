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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        ArrayList<ArrayList<TreeNode>> b=new ArrayList<>();
        ArrayList<TreeNode> tem=new ArrayList<>();
        tem.add(root);
        b.add(tem);
        int level=1;
        while(!q.isEmpty())
        {
             level=q.size();
            ArrayList<TreeNode> in=new ArrayList<>();
            for(int i=0;i<level;i++)
            {
                TreeNode t=q.poll();
                if(t.left!=null)
                {
                    q.offer(t.left);
                    in.add(t.left);
                }
                if(t.right!=null)
                {
                    q.offer(t.right);
                    in.add(t.right);
                }
            }
           
            b.add(in);
        }
       Map<TreeNode,ArrayList<Integer>> m=new HashMap<>();
       for(int i=0;i<b.size();i++)
       {
           for(int j=0;j<b.get(i).size();j++)
           {
               ArrayList<Integer> childs=new ArrayList<>();
               dfs(b.get(i).get(j),childs);
               m.put(b.get(i).get(j),childs);
           }
       }
        int max=0;
        for(Map.Entry<TreeNode,ArrayList<Integer>> e:m.entrySet())
        {
           
           int anc=e.getKey().val;
            ArrayList<Integer> childs=e.getValue();
             
            for(int i=0;i<childs.size();i++)
            {
                max=Math.max(max,Math.abs(anc-childs.get(i)));
            }
        }
        return max%100000007;
    }
    public void dfs(TreeNode node,ArrayList<Integer> c)
    {
        if(node.left!=null)
        {
            c.add(node.left.val);
            dfs(node.left,c);
        }
        if(node.right!=null)
        {
            c.add(node.right.val);
            dfs(node.right,c);
        }
        return;
    }
}