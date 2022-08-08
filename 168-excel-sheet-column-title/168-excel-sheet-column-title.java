class Solution {
    public String convertToTitle(int columnNumber) {
     StringBuilder s=new StringBuilder();
        while(columnNumber>0)
        {
            int rem=columnNumber%26;
            if(rem==0)
            {
                s.append("Z");
                columnNumber=(columnNumber/26)-1;
            }
            else
            {
                s.append((char)((rem-1)+'A'));
                columnNumber/=26;
            }
        }
        return s.reverse().toString();
    }
}