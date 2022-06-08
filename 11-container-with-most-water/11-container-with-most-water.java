class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j)
        {
            int h=Math.min(height[i],height[j]);
            int w=(j+1)-(i+1);
            if(w*h>max)
            {
                max=w*h;
            }
            if(height[j]<height[i])
            {
                j--;
            }
            else if(height[i]<height[j])
            {
                i++;
            }
            else
            {
                i++;
                j--;
            }
        }
        return max;
    }
}