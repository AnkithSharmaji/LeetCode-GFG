//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestPalin(String s) {
        int index = 0;
        int mxl = 0;
        for (int i = 0; i < s.length(); i++) {
            int value1 = palindrome(s, i, i + 1); // for even length substring
            int value2 = palindrome(s, i, i); // for odd length substring
            int maxy = Math.max(value1, value2);
            if (maxy > mxl) {
                mxl = maxy;
                index = i - (maxy - 1) / 2;
            }
        }
        return s.substring(index, index + mxl);
    }

    static int palindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            } else {
                j++;
                i--;
            }
        }
        return j - i - 1;
    }
}
