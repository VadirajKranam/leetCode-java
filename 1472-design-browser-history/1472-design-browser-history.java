class BrowserHistory {
    Stack<String> history=new Stack<>();
    Stack<String> future;
    public BrowserHistory(String homepage) {
       history.push(homepage);
        future=new Stack<>();
    }
    
    public void visit(String url) {
        history.push(url);
        future=new Stack<>();
    }
    
    public String back(int steps) {
        while(steps>0 && history.size()>1)
        {
            future.push(history.pop());
            steps--;
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        while(steps>0 && future.size()>0)
        {
            history.push(future.pop());
            steps--;
        }
        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */