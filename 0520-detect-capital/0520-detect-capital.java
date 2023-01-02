class Solution {
    public boolean detectCapitalUse(String word) {
       if(word.charAt(0)>='a' && word.charAt(0)<='z')
       {
           for(int i=1;i<word.length();i++)
           {
               if(!(word.charAt(i)>='a' && word.charAt(i)<='z'))
               {
                   return false;
               }
           }
           return true;
       }
        if(word.charAt(0)>='A' && word.charAt(0)<='Z')
        {
            boolean allSmall=true;
            boolean allCaps=true;
            for(int i=1;i<word.length();i++)
            {
                if(!(word.charAt(i)>='a' && word.charAt(i)<='z'))
                {
                    allSmall=false;
                    break;
                }
            }
             for(int i=1;i<word.length();i++)
            {
                if(!(word.charAt(i)>='A' && word.charAt(i)<='Z'))
                {
                    allCaps=false;
                    break;
                }
            }
            return allSmall||allCaps;
        }
        return true;
    }
}