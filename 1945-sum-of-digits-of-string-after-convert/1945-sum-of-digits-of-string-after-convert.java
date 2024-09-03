class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sum=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sum.append((s.charAt(i)-'a'+1)+"");
        }
        int ans=0;
        while(k!=0){
            ans=0;
          for(int i=0;i<sum.length();i++){
              ans+=(sum.charAt(i)-'0');
          }
            sum=new StringBuilder(ans+"");
            k--;
        }
        return ans;
    }
}