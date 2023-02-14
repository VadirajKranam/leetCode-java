class Solution {
    public String addBinary(String a, String b) {
        String ans="";
        int i=a.length()-1,j=b.length()-1;
        int carry=0;
        while(i>=0 || j>=0)
        {
            int sum=carry;
            if(i>=0)
            {
                sum+=(a.charAt(i)-'0');
                i--;
            }
            if(j>=0)
            {
                sum+=(b.charAt(j)-'0');
                j--;
            }
            ans+=(sum%2);
            carry=sum/2;
        }
        if(carry!=0)
        {
            ans+=(carry);
        }
        StringBuilder act=new StringBuilder(ans);
        return act.reverse().toString();
    }
}