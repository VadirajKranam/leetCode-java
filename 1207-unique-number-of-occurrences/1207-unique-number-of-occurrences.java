class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> m=new HashMap<>();
       for(int i=0;i<arr.length;i++)
       {
           if(m.get(arr[i])==null)
           {
               m.put(arr[i],1);
           }
           else
           {
               m.put(arr[i],m.get(arr[i])+1);
           }
       }
        ArrayList<Integer> a=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:m.entrySet())
        {
            a.add(e.getValue());
        }
        for(int i=0;i<a.size();i++)
        {
            for(int j=i+1;j<a.size();j++)
            {
                if(a.get(i)==a.get(j))
                {
                    return false;
                }
            }
        }
        return true;
    }
}