class Solution {
    public boolean validPalindrome(String s) {
        boolean check=true;
        int i=0,j=s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                check=false;
                break;
            }
            i++;
            j--;
        }
        if(check)
        {
            return true;
        }
        int i1=i+1;
        int j1=j;
        int i2=i;
        int j2=j-1;
        boolean check1=true,check2=true;
        
        while(i1<=j1)
        {
            if(s.charAt(i1)!=s.charAt(j1))
            {
                check1=false;
                break;
            }
            i1++;
            j1--;
        }
        while(i2<=j2)
        {
            if(s.charAt(i2)!=s.charAt(j2))
            {
                check2=false;
                break;
            }
            i2++;
            j2--;
        }
        return check1||check2;
    }
}