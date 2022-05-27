class Solution {
     int numberOfSteps(int num) {
        int count=0;
     return answer(num,count);
    }
    int answer(int n,int steps)
    {
        if(n<=0)
        {
            return steps;
        }
        else if(n%2==0)
        {
           return answer(n/2,steps+1);
        }
        return answer(n-1,steps+1);
    }
}