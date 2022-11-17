class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            int start=i,end=i,j=i+1;
            int count=1;
            while(j<s.length() && s.charAt(i)==s.charAt(j))
            {
                count++;
                j++;
            }
            end=j-1;
            i+=count-1;
            //System.out.println(count);
            if(count>=3)
            {
                List<Integer> sub=new ArrayList<>();
                sub.add(start);
                sub.add(end);
                ans.add(sub);
                
            }
        }
        return ans;
    }
}