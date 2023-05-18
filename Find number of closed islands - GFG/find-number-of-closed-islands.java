//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public int bfs(int a, int b, int[][] vis, int[][] grid, int n, int m) {
        vis[a][b] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        int i, j, f = 1;
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            a = p[0];
            b = p[1];
            for (i = 0; i < 4; i++) {
                int r = a + row[i];
                int c = b + col[i];
                if (grid[r][c] == 1 && vis[r][c] == 0) {
                    if (r == 0 || r == n - 1 || c == 0 || c == m - 1)
                        f = 0;
                    else {
                        vis[r][c] = 1;
                        q.offer(new int[]{r, c});
                    }
                }
            }
        }
        return f;
    }
    
    public int closedIslands(int[][] grid, int N, int M) {
        int i, j, n = grid.length, m = grid[0].length, c = 0;
        int[][] vis = new int[n][m];
        for (i = 1; i < n - 1; i++) {
            for (j = 1; j < m - 1; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    c += bfs(i, j, vis, grid, n, m);
                }
            }
        }
        return c;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[][] matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            Solution obj = new Solution();
            int ans = obj.closedIslands(matrix, N, M);
            System.out.println(ans);
        }
        scanner.close();
    }
}