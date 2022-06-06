class Solution {
public:
    string interpret(string command) {
        string ans;
        for(int i=0;i<command.size();i++)
        {
            if(command[i]=='(' && command[i+1]==')')
            {
                ans.push_back('o');
                i++;
            }
            else if(command[i]=='(' && command[i+1]=='a')
            {
                ans.push_back('a');
                ans.push_back('l');
                i+=2;
            }
            else if(command[i]=='G')
            {
                ans.push_back('G');
            }
        }
        return ans;
    }
};