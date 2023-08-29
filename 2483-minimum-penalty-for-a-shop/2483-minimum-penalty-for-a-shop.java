class Solution {
    public int bestClosingTime(String customers) {
        int[] left=new int[customers.length()+1];
        Arrays.fill(left,0);
        int countN=0;
        int countY=0;
        for(int i=0;i<customers.length();i++)
        {
             left[i]=countN;
            if(customers.charAt(i)=='N')
            {
                countN++; 
            }
        }
        left[left.length-1]=countN;
        int[] right=new int[customers.length()+1];
        Arrays.fill(right,0);
        for(int i=customers.length()-1;i>=0;i--)
        { 
            if(customers.charAt(i)=='Y')
            {
                countY++; 
            }
            right[i]=countY;
        }
        int max=Integer.MAX_VALUE;
        int minInd=0;
        for(int i=0;i<left.length;i++)
        {
            if(left[i]+right[i]<max)
            {
                max=left[i]+right[i];
                minInd=i;
            }
        }
        return minInd;
    }
}