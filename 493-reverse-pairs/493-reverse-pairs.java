class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public static int mergeSort(int[] nums,int low,int high)
    {
        if(low>=high)
        {
            return 0;
        }
        int mid=low+(high-low)/2;
        int inv=mergeSort(nums,low,mid);
        inv+=mergeSort(nums,mid+1,high);
        inv+=merge(nums,low,mid,high);
        return inv;
    }
    public static int merge(int[] num,int low,int mid,int high)
    {
        int count=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++)
        {
            while(j<=high && ((long)num[i])>((long)2*num[j]))
            {
                j++;
            }
            count+=(j-(mid+1));
        }
        int left=low,right=mid+1;
        ArrayList<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high)
        {
            if(num[left]<=num[right])
            {
                temp.add(num[left++]);
            }
            else
            {
                temp.add(num[right++]);
            }
        }
        while(left<=mid)
        {
            temp.add(num[left++]);
        }
        while(right<=high)
        {
            temp.add(num[right++]);
        }
        for(int i=low;i<=high;i++)
        {
            num[i]=temp.get(i-low);
        }
        return count;
    }
}