//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
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
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<ArrayList<String>> ans=new ArrayList<>();
    String b;
     Map<String,Integer> m=new HashMap<>();
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Set<String> s=new HashSet<>();
        for(String st:wordList)
        {
            s.add(st);
        }
        b=new String(startWord);
       
        Queue<String> q=new LinkedList<>();
        q.offer(startWord);
        s.remove(startWord);
        m.put(startWord,1);
        int sz=startWord.length();
        while(!q.isEmpty())
        {
            String w=q.poll();
            int steps=m.get(w);
            if(w.equals(targetWord))
            {
                break;
            }
            for(int i=0;i<sz;i++)
            {
                
               
                for(char c='a';c<='z';c++)
                {
                    char[] charArray=w.toCharArray();
                    charArray[i]=c;
                    String temp=new String(charArray);
                    if(s.contains(temp))
                    {
                        q.offer(temp);
                        m.put(temp,steps+1);
                        s.remove(temp);
                    }
                }
            }
        }
        if(m.containsKey(targetWord))
        {
            ArrayList<String> sq=new ArrayList<>();
            sq.add(targetWord);
            dfs(targetWord,sq);
 
        }
        return ans;
    }
    private void dfs(String word,ArrayList<String> sq)
    {
        if(word.equals(b))
        {
           
            ArrayList<String> dup=new ArrayList<>(sq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int sz=word.length();
        int steps=m.get(word);
         for(int i=0;i<sz;i++)
            {
                
               
                for(char c='a';c<='z';c++)
                {
                    char[] charArray=word.toCharArray();
                    charArray[i]=c;
                    String temp=new String(charArray);
                    if(m.containsKey(temp) && m.get(temp)+1==steps)
                    {
                        sq.add(temp);
                        dfs(temp,sq);
                        sq.remove(sq.size()-1);
                    }
                }
                
            }
    }
}





