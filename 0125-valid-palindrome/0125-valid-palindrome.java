class Solution {
    public boolean isPalindrome(String s) {
        String str="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                str+=s.charAt(i);
            }
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z')
            {
                str+=Character.toLowerCase(s.charAt(i));
            }
            else if(s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                str+=Character.toLowerCase(s.charAt(i));
            }
        }
        // if(str.length()==1)
        // {
        //     return false;
        // }
        return isPallindrome(str);
    }
    public boolean isPallindrome(String s)
    {
        int i=0,j=s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}