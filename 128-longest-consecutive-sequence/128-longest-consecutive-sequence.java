class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs=new HashSet<Integer>();
        for(int num:nums)
        {
            hs.add(num);
        }
        int longestLength=0;
      for(int num:nums)
      {
          int totalLength=0;
          if(!hs.contains(num))
          {
              continue;
          }
          else
          {
              hs.remove(num);
              int leftLength=0;
              int j=num-1;
              while(hs.contains(j))
              {
                  hs.remove(j--);
                  leftLength++;
              }
              int rightLength=0;
              j=num+1;
              while(hs.contains(j))
              {
                  hs.remove(j++);
                  rightLength++;
              }
               totalLength=1+leftLength+rightLength;
          }
          longestLength=(int)(Math.max(longestLength,totalLength));
      }
        return longestLength;
    }
}