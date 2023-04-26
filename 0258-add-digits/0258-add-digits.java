class Solution {
    public int addDigits(int num) {
        if(num<10)
        {
            return num;
        }
        while((int)Math.floor(Math.log10(num)+1)>1)
        {
            int sum=0;
            while(num!=0)
            {
                sum+=num%10;
                num/=10;
            }
            num=sum;
        }
        return num;
    }
}