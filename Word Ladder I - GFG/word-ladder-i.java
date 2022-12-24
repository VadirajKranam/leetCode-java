//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    String f="";
    int s;
    Pair(String f,int s)
    {
        this.f+=f;
        this.s=s;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> s=new HashSet<>();
        for(String w:wordList)
        {
            s.add(w);
        }
        s.remove(startWord);
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(startWord,1));
        int min=0;
        while(!q.isEmpty())
        {
            String word=q.peek().f;
            int steps=q.peek().s;
            q.poll();
            if(word.equals(targetWord))
            {
                return steps;
            }
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] rca=word.toCharArray();
                    rca[i]=ch;
                    String rw=new String(rca);
                    if(s.contains(rw))
                    {
                        s.remove(rw);
                        q.offer(new Pair(rw,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}