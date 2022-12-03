class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] a1=new int[26];
        int[] a2=new int[26];
        Arrays.fill(a1,0);
        Arrays.fill(a2,0);
       for(char ch:word1.toCharArray())
       {
           a1[ch-'a']++;
       }
       for(char ch:word2.toCharArray())
       {
           a2[ch-'a']++;
       }
        for(int i=0;i<a1.length;i++)
        {
            if(a1[i]==a2[i])
            {
                continue;
            }
            if(a1[i]==0 || a2[i]==0)
            {
                return false;
            }
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        for(int i=0;i<a1.length;i++)
        {
            if(a1[i]!=a2[i])
            {
                return false;
            }
        }
        return true;
    }
}