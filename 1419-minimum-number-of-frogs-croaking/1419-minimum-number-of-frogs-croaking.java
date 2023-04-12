class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int ans=0;
        int c=0,r=0,o=0,a=0,k=0;
        int activeFrogs=0;
        for(char ch:croakOfFrogs.toCharArray())
        {
            switch(ch)
            {
                case 'c':
                    c++;
                    activeFrogs++;
                    break;
                case 'r':
                      r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'k':
                    k++;
                    activeFrogs--;
                    break;
            }
            ans=Math.max(ans,activeFrogs);
            if(c<r || r<o || o<a || a<k)
            {
                return -1;
            }
        }
        return activeFrogs==0?ans:-1;
    }
}