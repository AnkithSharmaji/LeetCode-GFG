//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true; // All characters of the word have been found
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(k)) {
            return false; // Out of bounds or current cell does not match the word
        }
        
        char temp = board[i][j];
        board[i][j] = '#'; // Mark the current cell as visited
        
        // Recursively check the neighboring cells
        boolean found = dfs(board, word, i - 1, j, k + 1) ||
                        dfs(board, word, i + 1, j, k + 1) ||
                        dfs(board, word, i, j - 1, k + 1) ||
                        dfs(board, word, i, j + 1, k + 1);
        
        board[i][j] = temp; // Restore the original value
        
        return found;
    }
}