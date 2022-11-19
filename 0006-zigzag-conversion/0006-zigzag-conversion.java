class Solution {
    public String convert(String s, int numRows) {
        String[] ans=new String[numRows];
        if(numRows==1)
        {
            return s;
        }
          for (int i=0;i<ans.length;i++)
        {
            ans[i]="";
        }
        int d=1;
        function(ans,0,0,numRows,d,s);
        String a="";
        for (int i=0;i<ans.length;i++)
        {
            a+=ans[i];
        }
        return a;
    }
    public  void function(String[] ans,int ind,int i,int numRow,int d,String s)
    {
        if(i==s.length())
        {
            return;
        }
        if(ind==0)
        {
            ans[ind]+=s.charAt(i);
            function(ans,ind+1,i+1,numRow,1,s);
            return;
        }
        if(ind==ans.length-1)
        {
            ans[ind]+=s.charAt(i);
            function(ans,ind-1,i+1,numRow,0,s);
            return;
        }
        if(d==1)
        {
            ans[ind]+=s.charAt(i);
            function(ans,ind+1,i+1,numRow,1,s);
            return;
        }
        if (d==0)
        {
            ans[ind]+=s.charAt(i);
            function(ans,ind-1,i+1,numRow,0,s);
            return;
        }
        return;
    }
}
  