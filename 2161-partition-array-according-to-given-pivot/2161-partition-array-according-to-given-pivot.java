class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
         ArrayList<Integer> a3=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            {
                a1.add(nums[i]);
            }
            else if(nums[i]==pivot)
            {
                a2.add(nums[i]);
            }
            else
            {
                a3.add(nums[i]);
            }
        }
        int j=0;
        for(int i=0;i<a1.size();i++)
        {
            nums[j]=a1.get(i);
            j++;
        }
        for(int i=0;i<a2.size();i++)
        {
            nums[j]=a2.get(i);
            j++;
        }
        for(int i=0;i<a3.size();i++)
        {
            nums[j]=a3.get(i);
            j++;
        }
        return nums;
    }
}