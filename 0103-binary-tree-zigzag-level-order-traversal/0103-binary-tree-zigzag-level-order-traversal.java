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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans1=new LinkedList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null)
        {
            return ans1;
        }
      queue.offer(root);
        while(!queue.isEmpty())
        {
            int level=queue.size();
            List<Integer> sublist=new LinkedList<Integer>();
            for(int i=0;i<level;i++)
            {
                if(queue.peek().left!=null)
                {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null)
                {
                    queue.offer(queue.peek().right);
                }
                sublist.add(queue.poll().val);
            }
            ans1.add(sublist);
        }
    
        for(int i=0;i<ans1.size();i++)
        {
            if(i%2==1)
            {
                Collections.reverse(ans1.get(i));
            }
           
        }
        return ans1;
    }
}


