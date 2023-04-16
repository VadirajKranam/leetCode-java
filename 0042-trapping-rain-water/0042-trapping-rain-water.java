import java.util.*;
class Solution {
    public int trap(int[] height) {
        int total=0;
        for(int i=0;i<height.length;i++)
        {
            int leftMax=0,rightMax=0;
            for(int k=0;k<=i;k++)
            {
                leftMax=Math.max(leftMax,height[k]);
            }
            
            for(int k=i;k<height.length;k++)
            {
                rightMax=Math.max(rightMax,height[k]);
            }
           
            total+=Math.min(leftMax,rightMax)-height[i];
            
        }
        return total;
    }
}