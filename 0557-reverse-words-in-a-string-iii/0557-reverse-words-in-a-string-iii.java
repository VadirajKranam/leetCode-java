class Solution {
    public String reverseWords(String s) {
       //int i=0;
        StringBuilder st=new StringBuilder();
        ArrayList<String> words=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                String t2=st.reverse().toString();
                st=new StringBuilder();
                words.add(t2);
                continue;
            }else{
             st.append(s.charAt(i));
            }
            //System.out.println(st);
        }
        //st.deleteCharAt(st.length()-1);
        String t2=st.reverse().toString();
        words.add(t2);
        //System.out.println(words);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<words.size();i++)
        {
            ans.append(words.get(i));
            if(i!=words.size()-1){
            ans.append(' ');
            }
        }
        return ans.toString();
    }
}