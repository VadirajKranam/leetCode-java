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
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Node node=root;
        st1.push(node);
        while(!st1.isEmpty())
        {
            node=st1.pop();
            st2.push(node);
            for(int i=0;i<node.children.size();i++)
            {
                if(node.children.get(i)!=null)
                {
                    st1.push(node.children.get(i));
                }
            }
        }
        while(!st2.isEmpty())
        {
            ans.add(st2.pop().val);
        }
        return ans;
    }
}



