class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int>d(nums1.begin(),nums1.begin()+m);
        for(int i=0;i<n;i++)
            d.push_back(nums2[i]);
        sort(d.begin(),d.end());
       for(int i=0;i<d.size();i++)
           nums1[i]=d[i];
    }
};