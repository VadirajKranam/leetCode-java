class Pair{
    int f,s;
    Pair(int a,int b)
    {
        this.f=a;
        this.s=b;
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b)
            {
                return Integer.compare(a[0],b[0]);
            }
        });
        Stack<Pair> s=new Stack<>();
        s.push(new Pair(points[0][0],points[0][1]));
        for(int i=0;i<points.length;i++)
        {
            Pair t=s.peek();
            if(points[i][0]<=t.s)
            {
                s.pop();
                s.push(new Pair(t.f,Math.min(points[i][1],t.s)));
            }
            else
            {
                s.push(new Pair(points[i][0],points[i][1]));
            }
        }
        return s.size();
    }
}