class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        vector<int>d;
        for(int i=0;i<nums.size()-1;i++)
        {
            if(nums[i]!=nums[i+1])
            {
                d.push_back(nums[i]);
            }
        }
        d.push_back(nums[nums.size()-1]);
       for(int i=0;i<d.size();i++)
       {
           nums[i]=d[i];
       }
        return d.size();
    }
};