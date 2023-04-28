class MinStack {
   int min;
    Stack<Integer> st;
    public MinStack() {
       min=Integer.MAX_VALUE;
       st=new Stack<>();
    }
    
    public void push(int val) {
        if(val<min)
        {
            min=val;
        }
        st.push(val);
        //System.out.println(st);
    }
    
    public void pop() {
        Stack<Integer> t=new Stack<>();
        st.pop();
        int temp=Integer.MAX_VALUE;
        while(!st.isEmpty())
        {
            temp=Math.min(temp,st.peek());
            t.push(st.pop());
        }
        min=temp;
        while(!t.isEmpty())
        {
            st.push(t.pop());
        }
        //System.out.println(min);
    }
    
    public int top() {
        //System.out.println(st);
        return st.peek();
    }
    
    public int getMin() {
        //System.out.println(st);
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */