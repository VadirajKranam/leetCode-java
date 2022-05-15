class Solution {
    public boolean containsDuplicate(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                return true;
            }
        }
        return false;
    }
    public static void mergeSort(int[] nums,int l,int r)
    {
        if(l<r)
        {
            int m=l+(r-l)/2;
            mergeSort(nums,l,m);
            mergeSort(nums,m+1,r);
            merge(nums,l,m,r);
        }
    }
    public static void merge(int[] nums,int l,int m,int r)
    {
        int n1=m-l+1;
        int n2=r-m;
        int[] a1=new int[n1];
        int[] a2=new int[n2];
        for(int i=0;i<n1;i++)
        {
            a1[i]=nums[l+i];
        }
        for(int j=0;j<n2;j++)
        {
            a2[j]=nums[m+j+1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2)
        {
            if(a1[i]<=a2[j])
            {
                nums[k]=a1[i];
                i++;
            }
            else
            {
                nums[k]=a2[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            nums[k]=a1[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            nums[k]=a2[j];
            j++;
            k++;
        }
    }
}