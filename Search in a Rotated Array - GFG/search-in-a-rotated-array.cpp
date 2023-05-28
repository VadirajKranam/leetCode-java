//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    public:
    int search(int a[], int l, int h, int key){
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(a[m]==key)
            {
                return m;
            }
            else if(a[l]<=a[m])
            {
                if(a[l]<=key && a[m]>=key)
                {
                    h=m-1;
                }
                else
                {
                    l=m+1;
                }
            }
            else
            {
                if(a[m]<=key && key<=a[h])
                {
                    l=m+1;
                }
                else
                {
                    h=m-1;
                }
            }
        }
        return -1;
    }
};

//{ Driver Code Starts. 
int main() {
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        int A[n];
        for(int i = 0; i < n; i++)
            cin >> A[i];
        int key;
        cin >> key;
        Solution ob;
        cout << ob.search(A, 0, n - 1, key) << endl;
    }
return 0;
}
// } Driver Code Ends