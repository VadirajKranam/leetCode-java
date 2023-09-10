//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals("N")) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            int key = Integer.parseInt(br.readLine().trim());
            Solution T = new Solution();
            root = T.insert(root, key);
            inorder(root);
            System.out.println();
            t--;
        }
    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to insert a node in a BST.
    boolean findIt(Node root,int k)
    {
       if(root==null)
       {
           return false;
       }
       if(root.data==k)
       {
           return true;
       }
       return findIt(root.left,k)||findIt(root.right,k);
    }
    void insertIt(Node root,int k)
    {
        if(root.left==null && root.data>k)
        {
            Node newNode=new Node(k);
            root.left=newNode;
            newNode.left=null;
            newNode.right=null;
            return;
        }
        else if(root.right==null && root.data<k)
        {
           Node newNode=new Node(k);
            root.right=newNode;
            newNode.left=null;
            newNode.right=null;
            return; 
        }
        if(root.data<k)
        {
            insertIt(root.right,k);
            return;
        }
        insertIt(root.left,k);
    }
    Node insert(Node root, int Key) {
        if(findIt(root,Key))
        {
            return root;
        }
        insertIt(root,Key);
        return root;
    }
}