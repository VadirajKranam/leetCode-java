class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] ls=new int[heights.length];
        int[] rs=new int[heights.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<heights.length;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ls[i]=0;
            }
            else
            {
                ls[i]=st.peek()+1;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            st.pop();
        }
        for(int i=heights.length-1;i>=0;i--)
        {
             while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                rs[i]=heights.length-1;
            }
            else
            {
                rs[i]=st.peek()-1;
            }
            st.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<ls.length;i++)
        {
            max=Math.max(max,(rs[i]-ls[i]+1)*heights[i]);
        }
        return max;
    }
}