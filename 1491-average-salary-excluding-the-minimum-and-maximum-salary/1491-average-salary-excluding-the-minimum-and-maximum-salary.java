class Solution {
    public double average(int[] salary) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<salary.length;i++)
        {
            max=Math.max(max,salary[i]);
            min=Math.min(min,salary[i]);
        }
        int sum=0;
        int count=0;
        for(int i=0;i<salary.length;i++)
        {
            if(salary[i]!=min && salary[i]!=max)
            {
                sum+=salary[i];
                count++;
            }
        }
        return (double)(sum)/(double)(count);
    }
}