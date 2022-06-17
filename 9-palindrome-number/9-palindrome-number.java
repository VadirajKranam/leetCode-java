class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        int rev=0;
        int n=x;
        while(n!=0)
        {
            rev=rev*10+n%10;
            n/=10;
        }
        if(rev==x)
        {
            return true;
        }
        return false;
    }
}