//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        if (N % groupSize != 0) {
            return false; // Number of cards is not divisible by groupSize
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        
        while (!map.isEmpty()) {
            int firstCard = map.firstKey();
            
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                
                if (!map.containsKey(currentCard)) {
                    return false; // Missing consecutive card
                }
                
                int count = map.get(currentCard);
                
                if (count == 1) {
                    map.remove(currentCard);
                } else {
                    map.put(currentCard, count - 1);
                }
            }
        }
        
        return true;
    }
}
