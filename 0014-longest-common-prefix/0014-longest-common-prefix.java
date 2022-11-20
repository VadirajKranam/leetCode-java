class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        int l=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++)
        {
            l=Math.min(l,strs[i].length());
        }
        if(l==0)
        {
            return ans;
        }
        int c=0;
        while(c!=l)
        {
            char ch=strs[0].charAt(c);
            boolean check=true;
            for(int i=0;i<strs.length;i++)
            {
                if(strs[i].charAt(c)!=ch)
                {
                    check=false;
                    break;
                }
            }
            if(!check)
            {
                break;
            }
            else
            {
                ans+=ch;
            }
            c++;
        }
        return ans;
    }
}