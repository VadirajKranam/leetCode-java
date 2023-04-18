/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
       
        Queue<Node> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
         if(root==null)
        {
         return ans;   
        }
        q.offer(root);
        //ans.add(new ArrayList<>(root.val));
        int size=1;
        while(!q.isEmpty())
        {
            List<Integer> in=new ArrayList<>();
            List<Node> t=new ArrayList<>();
            while(size!=0)
            {
                t.add(q.peek());
                in.add(q.peek().val);
                size--;
                q.poll();
            }
            ans.add(in);
           for(int i=0;i<t.size();i++)
           {
               for(int j=0;j<t.get(i).children.size();j++)
               {
                   if(t.get(i).children.get(j)!=null)
                   {
                       q.offer(t.get(i).children.get(j));
                   }
               }
           }
            size=q.size();
        }
        return ans;
    }
}