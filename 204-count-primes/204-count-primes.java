class Solution {
    public int countPrimes(int n) {
        if(n<=1)
        {
            return 0;
        }
        boolean[] primes=sieve(n);
        int count=0;
        for(int i=0;i<primes.length;i++)
        {
            if(primes[i]==true)
            {
                count++;
            }
        }
        return count;
    }
    static boolean[] sieve(int n)
    {
        boolean[] primes=new boolean[n];
        Arrays.fill(primes,true);
        primes[0]=false;
        primes[1]=false;
        for(int i=2;i*i<n;i++)
        {
            for(int j=i*2;j<n;j+=i)
            {
                primes[j]=false;
            }
        }
        return primes;
    }
}