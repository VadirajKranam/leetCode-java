class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        Arrays.parallelPrefix(nums,Integer::sum);
        for(int i=0;i<queries.length;i++)
        {
            int pos=Arrays.binarySearch(nums,queries[i]+1);
            queries[i]=pos<0?~pos:pos;
        }
        return queries;
    }
}