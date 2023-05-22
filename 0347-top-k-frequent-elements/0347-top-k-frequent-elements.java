class Pair{
    int num,freq;
    Pair(int num,int freq)
    {
        this.num=num;
        this.freq=freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Pair> temp=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:m.entrySet())
        {
            temp.add(new Pair(e.getKey(),e.getValue()));
        }
        Collections.sort(temp,new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b)
            {
                if(a.freq>b.freq)
                {
                    return -1;
                }
                else if(a.freq<b.freq)
                {
                    return 1;
                }
                return 0;
            }
        });
        int[] ans=new int[k];
        int i=0;
        while(i<k)
        {
            ans[i]=temp.get(i).num;
            i++;
        }
        return ans;
    }
}