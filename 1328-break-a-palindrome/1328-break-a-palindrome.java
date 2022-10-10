class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<2)
        {
            return "";
        }
        char[] a=palindrome.toCharArray();
        for(int i=0;i<a.length/2;i++)
        {
            if(a[i]!='a')
            {
                a[i]='a';
                return String.valueOf(a);
            }
        }
        a[a.length-1]='b';
        return String.valueOf(a);
    }
    
}