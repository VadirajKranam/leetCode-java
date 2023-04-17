class Solution {
    public int countEven(int num) {
        int count=0;
        int n=1;
        while(n<=num)
        {
            int sum=0;
            String st=String.valueOf(n);
            for(int i=0;i<st.length();i++)
            {
                sum+=st.charAt(i)-'0';
            }
            if(sum%2==0)
            {
                count++;
            }
            n++;
        }
        return count;
    }
}