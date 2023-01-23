class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==1)
        {
            return trust[0][1];
        }
       int notThere=0;
        boolean check=true;
        ArrayList<Integer> catcher=new ArrayList<>();
        for(int num=1;num<=n;num++)
        {
            check=true;
            for(int i=0;i<trust.length;i++)
            {
                if(trust[i][0]==num)
                {
                    check=false;
                    break;
                }
            }
            int count=0;
            if(check==true)
            {
               for(int i=0;i<trust.length;i++)
               {
                   if(trust[i][1]==num)
                   {
                       count++;
                   }
               }
                if(count==n-1)
                {
                    catcher.add(num);
                }
            }
        }
        if(catcher.size()==0 || catcher.size()>1)
        {
            return -1;
        }
        int ans=catcher.get(0);
        return ans;
    }
}