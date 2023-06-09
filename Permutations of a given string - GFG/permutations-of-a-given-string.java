//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> permutations = new ArrayList<>();
        char[] chars = S.toCharArray();
        backtrack(chars, 0, permutations);
        Collections.sort(permutations);
        return permutations;
    }
    
    private void backtrack(char[] chars, int index, List<String> permutations) {
        if (index == chars.length - 1) {
            permutations.add(String.valueOf(chars));
            return;
        }
        
        for (int i = index; i < chars.length; i++) {
            if (isUnique(chars, index, i)) {
                swap(chars, index, i);
                backtrack(chars, index + 1, permutations);
                swap(chars, index, i);
            }
        }
    }
    
    private boolean isUnique(char[] chars, int start, int end) {
        for (int i = start; i < end; i++) {
            if (chars[i] == chars[end]) {
                return false;
            }
        }
        return true;
    }
    
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}