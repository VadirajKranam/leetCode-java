class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        int div=2;
        int sum=1;
        int num2=(int)(Math.sqrt(num));
        while(div<=num2)
        {
            if(num%div==0)
            {
                sum+=div;
                sum+=num/div;
            }
            div++;
            
        }
        
        return sum==num;
    }
}