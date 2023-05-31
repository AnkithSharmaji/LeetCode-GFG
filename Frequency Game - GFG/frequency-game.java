//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

// Position this line where user code will be pasted.

// Driver class with main function
class GFG {
    // Main function
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        // Iterating over testcases
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int arr[] = new int[n];

            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Helper class to find largest number with minimum frequency
class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxElement = Integer.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        // Calculate the frequency of each element
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
            maxElement = Math.max(maxElement, element);
        }

        // Find the largest element with minimum frequency
        for (int element : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(element);
            if (frequency < minFrequency) {
                minFrequency = frequency;
                maxElement = element;
            } else if (frequency == minFrequency && element > maxElement) {
                maxElement = element;
            }
        }

        return maxElement;
    }
}