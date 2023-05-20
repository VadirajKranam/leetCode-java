class Solution {
    public String findDifferentBinaryString(String[] nums) {
       int maxNum=0;
       int i=0;
        while(i<nums.length)
        {
            maxNum=maxNum+(int)Math.pow(2,i);
            i++;
        }
        int[] vis=new int[maxNum+1];
        Arrays.fill(vis,-1);
        for(int j=0;j<nums.length;j++)
        {
            int n=Integer.parseInt(nums[j],2);
            vis[n]=1;
        }
        int j=0;
        for(j=0;j<vis.length;j++)
        {
            if(vis[j]==-1)
            {
                break;
            }
        }
        StringBuilder ans=new StringBuilder();
        while(j!=0)
        {
            ans.append(j%2);
            j/=2;
        }
        while(ans.length()!=nums.length)
        {
            ans.append('0');
        }
        return ans.reverse().toString();
    }
}