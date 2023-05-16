/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        vector<ListNode*> a;
        ListNode *t=head;
        while(t!=NULL)
        {
            a.push_back(t);
            t=t->next;
        }
        if(a.size()<=1)
        {
            return head;
        }
        for(int i=0;i<a.size()-1;i+=2)
        {
            ListNode *t1=a[i];
            a[i]=a[i+1];
            a[i+1]=t1;
        }
        a[a.size()-1]->next=NULL;
        head=a[0];
        t=head;
        for(int i=1;i<a.size();i++)
        {
            t->next=a[i];
            t=t->next;
        }
        return head;
    }
};