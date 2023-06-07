class Solution {
    public int minFlips(int a, int b, int c) {
      String a1=Integer.toBinaryString(a);
      String b1=Integer.toBinaryString(b);
      String c1=Integer.toBinaryString(c);
      int maxLength=Math.max(a1.length(),Math.max(b1.length(),c1.length()));
      String a2=String.format("%"+maxLength+"s",a1).replace(' ','0');
      String b2=String.format("%"+maxLength+"s",b1).replace(' ','0');
      String c2=String.format("%"+maxLength+"s",c1).replace(' ','0');
      int count=0;
        System.out.println(a2+" "+b2+" "+c2);
      for(int i=0;i<c2.length();i++)
      {
          if(c2.charAt(i)=='1')
          {
              if(a2.charAt(i)=='0' && b2.charAt(i)=='0')
              {
                  count++;
              }
          }
          else
          {
              if(a2.charAt(i)=='1' && b2.charAt(i)=='1')
              {
                  count+=2;
              }
              else if(a2.charAt(i)=='1' && b2.charAt(i)=='0')
              {
                  count++;
              }
              else if(a2.charAt(i)=='0' && b2.charAt(i)=='1')
              {
                  count++;
              }
          }
      }
        return count;
    }
}