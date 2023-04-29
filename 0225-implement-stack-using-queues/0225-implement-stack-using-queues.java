class MyStack {
   Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        this.q1=new LinkedList<>();
        this.q2=new LinkedList<>();;
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        while(q1.size()>1)
        {
            q2.offer(q1.poll());
        }
      int ans=q1.poll();
        while(q2.size()!=0)
        {
            q1.offer(q2.poll());
        }
        return ans;
    }
    
    public int top() {
        while(q1.size()>1)
        {
            q2.offer(q1.poll());
        }
      int ans=q1.poll();
        while(q2.size()!=0)
        {
            q1.offer(q2.poll());
        }
        q1.offer(ans);
        return ans;
    }
    
    public boolean empty() {
        if(q1.isEmpty())
        {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */