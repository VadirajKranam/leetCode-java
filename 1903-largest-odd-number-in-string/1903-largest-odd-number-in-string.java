class Solution {
    public String largestOddNumber(String num) {
        if((int)(num.charAt(num.length()-1))%2==1)
        {
            return num;
        }
        int i=num.length()-1;
        while(i>=0)
        {
            char ch=num.charAt(i);
            if((int)ch%2==1)
            {
                return num.substring(0,i+1);
            }
            i--;
        }
        return "";
    }
}