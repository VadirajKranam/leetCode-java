// { Driver Code Starts
//Initial Template for C++


#include<bits/stdc++.h>
using namespace std;


string reverseWord(string str);


int main() {
	
	int t;
	cin>>t;
	while(t--)
	{
	string s;
	cin >> s;
	
	cout << reverseWord(s) << endl;
	}
	return 0;
	
}

// } Driver Code Ends


//User function Template for C++

string reverseWord(string str){
    if(str.size()<=1)
    {
        return str;
    }
  for(int i=0;i<=str.size()/2-1;i++)
  {
      char c=str[i];
      str[i]=str[str.size()-i-1];
      str[str.size()-i-1]=c;
  }
  return str;
}