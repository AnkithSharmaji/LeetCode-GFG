//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
    public static String kthPermutation(int n,int k) {
        // code here
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // Create a list of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int[] factorials = new int[n + 1];
        factorials[0] = 1;

        // Calculate factorials of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        k--; // Convert K to 0-based index

        // Generate the kth permutation
        for (int i = n; i >= 1; i--) {
            int index = k / factorials[i - 1];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= factorials[i - 1];
        }

        return sb.toString();
    }
}
        


//{ Driver Code Starts.

class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends