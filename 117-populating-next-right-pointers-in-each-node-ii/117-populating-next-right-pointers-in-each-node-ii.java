/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
        {
            return root;
        }
        List<List<Node>> list=new LinkedList<List<Node>>();
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int level=q.size();
            List<Node> sublist=new LinkedList<>();
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
            list.add(sublist);
        }
        for(int i=0;i<list.size();i++)
        {
            int j=0;
            for(j=0;j<list.get(i).size()-1;j++)
            {
                list.get(i).get(j).next=list.get(i).get(j+1);
            }
            list.get(i).get(j).next=null;
        }
        return root;
    }
}