class Solution {
    public int findContentChildren(int[] g, int[] s) {
       int count=0;
        for(int i=0;i<g.length;i++)
        {
           int min=Integer.MAX_VALUE;
            int ind=-1;
            for(int j=0;j<s.length;j++)
            {
                if(s[j]>=g[i] && s[j]<min)
                {
                    min=s[j];
                    ind=j;
                }
            }
            if(ind!=-1){
            s[ind]=Integer.MAX_VALUE;
            count++;
            }
        }
        return count;
    }
}