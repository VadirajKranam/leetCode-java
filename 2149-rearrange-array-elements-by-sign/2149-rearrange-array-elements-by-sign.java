class Solution {
    public int[] rearrangeArray(int[] arr) {
         ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<0)
            {
                neg.add(arr[i]);
            }
            else
            {
                pos.add(arr[i]);
            }
        }
        ArrayList<Integer> ar=new ArrayList<>();
        boolean c=true;
        int i=0,j=0;
        while(i<pos.size() && j<neg.size())
        {
            if(c)
            {
                ar.add(pos.get(i));
                i++;
                c=false;
            }
            else
            {
                ar.add(neg.get(j));
                j++;
                c=true;
            }
        }
        while(i<pos.size())
        {
           ar.add(pos.get(i));
                i++; 
        }
        while(j<neg.size())
        {
            ar.add(neg.get(j));
            j++;
        }
        for(int h=0;h<ar.size();h++)
        {
            arr[h]=ar.get(h);
        }
        return arr;
    }
}