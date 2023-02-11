class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;
        int top=-1;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        if(s1.isEmpty())
        {
            top=x;
        }
        s1.push(x);
    }
    
    public int pop() {
        int size=s1.size();
        while(size!=1)
        {
            int x=s1.pop();
            s2.push(x);
            size--;
            top=x;
        }
        int ele=s1.pop();
    
        while(!s2.isEmpty())
        {
            int x=s2.pop();
            s1.push(x);
        }
        return ele;
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