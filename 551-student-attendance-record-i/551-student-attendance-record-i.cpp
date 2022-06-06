class Solution {
public:
    bool checkRecord(string s) {
        int acount=0;
        int pcount=0;
        int lcount=0;
        for(int i=0;i<s.size();i++)
        {
            if(s[i]=='A')
            {
                lcount=0;
                acount++;
            }
            else if(s[i]=='P')
            {
                lcount=0;
                pcount++;
            }
            else if(s[i]=='L')
            {
                lcount++;
            }
            if(lcount==3)
            {
                return false;
            }
        }
        if(acount>=2)
        {
            return false;
        }
        return  true;
    }
};