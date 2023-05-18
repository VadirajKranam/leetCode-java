class Solution {
    public boolean check(int[] nums) {
        int ind=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                ind=i+1;
                break;
            }
        }
        ArrayList<Integer> a=new ArrayList<>();
        int t=ind;
        while(t<nums.length)
        {
            a.add(nums[t]);
            t++;
        }
        t=0;
        while(t<ind)
        {
            a.add(nums[t]);
            t++;
        }
        for(int i=0;i<a.size()-1;i++)
        {
            if(a.get(i)>a.get(i+1))
            {
                return false;
            }
        }
        return true;
        
    }
}