class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26)
        {
            return false;
        }
        boolean[] ans=new boolean[26];
        for(int i=0;i<sentence.length();i++)
        {
            char c=sentence.charAt(i);
            ans[c-97]=true;
        }
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]==false)
            {
                return false;
            }
        }
        return true;
    }
}