class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++)
        {
            int j=0,k=i;
            while(j<needle.length() && k<haystack.length() && haystack.charAt(k)==needle.charAt(j))
            {
                k++;
                j++;
            }
            if(j==needle.length())
            {
                return i; 
            }
        }
        return -1;
    }
}