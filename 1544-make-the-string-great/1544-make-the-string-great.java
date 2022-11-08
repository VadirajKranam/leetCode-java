class Solution {
    public String makeGood(String s) {
       Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(st.isEmpty()||Math.abs(s.charAt(i)-st.peek())!=32)
            {
                st.push(s.charAt(i));
            }
            else if(Math.abs(s.charAt(i)-st.peek())==32)
            {
                st.pop();
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}