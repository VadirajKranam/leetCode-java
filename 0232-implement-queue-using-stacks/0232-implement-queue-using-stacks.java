class MyQueue {
    Stack<Integer> s1;
    int top=-1;
    public MyQueue() {
       s1=new Stack<>();
    }
    
    public void push(int x) {
       if(s1.isEmpty())
       {
           top=x;
           s1.push(x);
           return;
       }
        s1.push(x);
    }
    
    public int pop() {
        Stack<Integer> t=new Stack<>();
        while(!s1.isEmpty())
        {
            t.push(s1.pop());
        }
        int ans=t.pop();
        if(t.isEmpty())
        {
            return ans;
        }
        top=t.peek();
        while(!t.isEmpty())
        {
            s1.push(t.pop());
        }
        return ans;
    }
    
    public int peek() {
        return top;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */