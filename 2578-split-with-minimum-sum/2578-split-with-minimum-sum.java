class Solution {
    public int splitNum(int num) {
        char[] ar=String.valueOf(num).toCharArray();
        Arrays.sort(ar);
        StringBuilder num1=new StringBuilder();
        StringBuilder num2=new StringBuilder();
        for(int i=0;i<ar.length;i+=2)
        {
            num1.append(ar[i]);
            if(i+1<ar.length){
            num2.append(ar[i+1]);
            }
        }
        return Integer.parseInt(num1.toString())+Integer.parseInt(num2.toString());
    }
}