class Solution {
    public int[] numberOfLines(int[] widths, String s) {
       int line=0;
        int pixel=0;
        for(int i=0;i<s.length();i++)
        {
            if(pixel+widths[s.charAt(i)-'a']>100)
            {
                pixel=widths[s.charAt(i)-'a'];
                line+=1;
            }
            else
            {
                pixel+=widths[s.charAt(i)-'a'];
            }
        }
        return new int[]{line+1,pixel};
    }
}