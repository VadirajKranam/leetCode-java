class Solution {
    public int calPoints(String[] operations) {
       Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++)
        {
            if(operations[i].equals("+"))
            {
                int t1=st.pop();
                int t2=st.pop();
                int sum=t1+t2;
                st.push(t2);
                st.push(t1);
                st.push(sum);
            }
            else if(operations[i].equals("D"))
            {
                int t=st.peek();
                st.push(t*2);
            }
            else if(operations[i].equals("C"))
            {
                st.pop();
                continue;
            }
            else
            {
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int ans=0;
        while(!st.isEmpty())
        {
            ans+=st.pop();
        }
        return ans;
    }
}