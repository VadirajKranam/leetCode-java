class Solution {
    public boolean checkString(String s) {
       int i=0;
        while(i<s.length() && s.charAt(i)!='b')
        {
            i++;
        }
        while(i<s.length())
        {
            if(s.charAt(i)!='b')
            {
                return false;
            }
            i++;
        }
        return true;
    }
}