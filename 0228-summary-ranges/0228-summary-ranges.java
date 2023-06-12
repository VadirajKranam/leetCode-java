class Solution {
    public List<String> summaryRanges(int[] nums) {
         List<String> ans=new ArrayList<>();
        if(nums.length==0)
        {
            return ans;
        }
      int prev=nums[0];
       
      StringBuilder st=new StringBuilder();
        int count=1;
        st.append(prev+"");
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==prev+1)
            {
                prev=nums[i];
                count++;
            }
            else
            {
                if(count==1)
                {
                    // st.append(prev+"");
                    // System.out.println(st);
                    ans.add(new String(st.toString()));
                    st=new StringBuilder();
                    prev=nums[i];
                     st.append(prev+""); 
                }
                else{
                st.append("->");
                st.append(prev+"");
                ans.add(new String(st.toString()));
                st=new StringBuilder();
                prev=nums[i];
                st.append(prev+""); 
                count=1;
                }
            }
        }
        if(count>1)
        {
           st.append("->");
         st.append(prev+"");
            ans.add(new String(st.toString()));
        }
        else
        {
            ans.add(new String(st.toString()));
                    st=new StringBuilder();
        }
        return ans;
    }
}