class Solution {
    public int[] rearrangeArray(int[] arr) {
         ArrayList<Integer> pos=new ArrayList<>();
       ArrayList<Integer> neg=new ArrayList<>();
       for(int i=0;i<arr.length;i++)
       {
           if(arr[i]>=0)
           {
               pos.add(arr[i]);
           }
           else
           {
               neg.add(arr[i]);
           }
       }
       int i=0,j=0,k=0;
       while(i<pos.size() && j<neg.size())
       {
           arr[k++]=pos.get(i);
           arr[k++]=neg.get(j);
           i++;
           j++;
       }
       while(i<pos.size())
       {
           arr[k++]=pos.get(i);
           i++;
       }
       while(j<neg.size())
       {
           arr[k++]=neg.get(j);
           j++;
       }
        return arr;
    }
}