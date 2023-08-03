class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     List<List<String>> ans=new ArrayList<>();
        Map<String,ArrayList<String>> m=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] t=strs[i].toCharArray();
            Arrays.sort(t);
            String t2=new String(t);
            if(!m.containsKey(t2))
            {
                m.put(t2,new ArrayList<>());
            }
            m.get(t2).add(strs[i]);
        }
        for(Map.Entry<String,ArrayList<String>> e:m.entrySet())
        {
            ans.add(e.getValue());
        }
        return ans;
    }
}