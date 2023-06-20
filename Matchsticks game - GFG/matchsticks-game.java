//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.matchGame(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int matchGame(long N) {
        // Check if N is divisible by 5
        if (N % 5 == 0) {
            // If N is divisible by 5, it's impossible for A to win
            return -1;
        } else {
            // Otherwise, A can guarantee a win by picking the remainder of N divided by 5
            return (int) (N % 5);
        }
    }
}
