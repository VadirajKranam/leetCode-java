class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> t=new ArrayList<>();
        function(0,s,t,ans);
        return ans;
    }
    public void function(int ind,String s,List<String> t,List<List<String>> ans)
    {
        if(ind==s.length())
        {
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i=ind;i<s.length();i++)
        {
            if(isPallindrome(ind,i,s))
            {
                t.add(s.substring(ind,i+1));
                function(i+1,s,t,ans);
                t.remove(t.size()-1);
            }
        }
    }
    public boolean isPallindrome(int st,int e,String s)
    {
        while(st<e)
        {
            if(s.charAt(st++)!=s.charAt(e--))
            {
                return false;
            }
            
        }
        return true;
    }
}