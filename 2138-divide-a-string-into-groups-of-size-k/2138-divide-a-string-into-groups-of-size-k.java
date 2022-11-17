class Solution {
    public String[] divideString(String s, int k, char fill) {
        String temp="";
        int nox=0;
        if(s.length()%k!=0)
        {
            nox=k-(s.length()%k);
        }
        
        for(int i=0;i<s.length();i++)
        {
            temp+=s.charAt(i);
        }
        while(nox!=0)
        {
            temp+=fill;
            nox--;
        }
        String[] ans=new String[temp.length()/k];
        int i=0,j=0,l=0;
        while(j<temp.length())
        {
            String t="";
            l=k;
            while(l!=0)
            {
                t+=temp.charAt(j);
                j++;
                l--;
            }
            ans[i]=t;
            i++;
        }
        return ans;
    }
}