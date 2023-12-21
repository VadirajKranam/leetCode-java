class Solution {
    public String reverseWords(String s) {
        String s1=s.trim();
        ArrayList<String> arr=new ArrayList<>();
        StringBuilder t=new StringBuilder();
        int i=0;
        for(i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)==' ')
            {
                if(t.toString().trim().length()>0){
                arr.add(t.toString().trim());
                }
                t=new StringBuilder();
            }
            else
            {
                t.append(s1.charAt(i));
            }
        }
        arr.add(t.toString().trim());
        StringBuilder ans=new StringBuilder();
        for(i=arr.size()-1;i>0;i--)
        {
            for(int j=0;j<arr.get(i).length();j++)
            {
                if(arr.get(i).charAt(j)!=' '){
                ans.append(arr.get(i).charAt(j));
                }
            }
            ans.append(' ');
        }
        if(arr.size()>0)
        {
          for(int j=0;j<arr.get(0).length();j++)
            {
                if(arr.get(0).charAt(j)!=' '){
                ans.append(arr.get(0).charAt(j));
                }
            }
        }
        return ans.toString();
    }
}