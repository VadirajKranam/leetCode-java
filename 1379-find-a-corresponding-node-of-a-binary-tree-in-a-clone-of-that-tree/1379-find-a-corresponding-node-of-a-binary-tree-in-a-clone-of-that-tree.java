/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        List<List<TreeNode>> wrap=new ArrayList<List<TreeNode>>();
        Queue<TreeNode> q=new LinkedList<>();
        if(target==null)
        {
            return null;
        }
        TreeNode node=cloned;
        q.offer(node);
        while(!q.isEmpty())
        {
            List<TreeNode> sublist=new ArrayList<TreeNode>();
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
                sublist.add(q.poll());
            }
           wrap.add(sublist); 
        }
        for(int i=0;i<wrap.size();i++)
        {
            for(int j=0;j<wrap.get(i).size();j++)
            {
                if(wrap.get(i).get(j).val==target.val)
                {
                    return wrap.get(i).get(j);
                }
            }
        }
        return null;
    }
}