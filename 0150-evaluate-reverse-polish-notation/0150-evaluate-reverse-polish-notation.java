class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+"))
            {
                int k1=s.pop();
                int k2=s.pop();
                s.push(k1+k2);
            }
            else if(tokens[i].equals("-"))
            {
               int k1=s.pop();
                int k2=s.pop();
                s.push(k2-k1);  
            }
             else if(tokens[i].equals("*"))
            {
               int k1=s.pop();
                int k2=s.pop();
                s.push(k1*k2);  
            }
             else if(tokens[i].equals("/"))
            {
               int k1=s.pop();
                int k2=s.pop();
                s.push(k2/k1);  
            }
            else
            {
               
                int num=Integer.parseInt(tokens[i]);
                s.push(num);
            }
        }
        return s.pop();
    }
}