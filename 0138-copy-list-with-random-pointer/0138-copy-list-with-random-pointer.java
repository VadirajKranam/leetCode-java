/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> m=new HashMap<>();
        Node temp=head;
        Node head2=null;
        int len=0;
        while(temp!=null)
        {
            Node newNode=new Node(temp.val);
            m.put(temp,newNode);
            if(len==0)
            {
                head2=newNode;
            }
            len++;
            temp=temp.next;
        }
        for(Map.Entry<Node,Node> e:m.entrySet())
        {
            e.getValue().next=m.get(e.getKey().next);
            e.getValue().random=m.get(e.getKey().random);
        }
        return head2;
    }
}