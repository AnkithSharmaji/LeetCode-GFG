//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        List<int[]> mergedRanges = mergeRanges(range);

        for (int query : queries) {
            int kthSmallest = findKthSmallest(mergedRanges, query);
            result.add(kthSmallest);
        }

        return result;
    }

    private static List<int[]> mergeRanges(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedRanges = new ArrayList<>();

        int[] currentRange = ranges[0];
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] <= currentRange[1]) {
                currentRange[1] = Math.max(currentRange[1], ranges[i][1]);
            } else {
                mergedRanges.add(currentRange);
                currentRange = ranges[i];
            }
        }
        mergedRanges.add(currentRange);

        return mergedRanges;
    }

    private static int findKthSmallest(List<int[]> ranges, int k) {
        for (int[] range : ranges) {
            int length = range[1] - range[0] + 1;
            if (k <= length) {
                return range[0] + k - 1;
            }
            k -= length;
        }
        return -1;
    }
}

        
