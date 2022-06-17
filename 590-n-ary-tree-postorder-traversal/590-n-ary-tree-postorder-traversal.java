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
    public List<Integer> postorder(Node root) {
       Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        List<Integer> a=new ArrayList<>();
        if(root==null)
        {
            return a;
        }
        s1.push(root);
        while(!s1.isEmpty())
        {
            Node node=s1.pop();
            s2.push(node);
            for(int i=0;i<node.children.size();i++)
            {
                if(node.children.get(i)!=null)
                {
                    s1.push(node.children.get(i));
                }
            }
        }
        while(!s2.isEmpty())
        {
            a.add(s2.pop().val);
        }
        return a;
    }
}