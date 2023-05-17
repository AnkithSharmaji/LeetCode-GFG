//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
        // code here
        int t_l =  0; int t_r= 0; int t_u =0; int t_d=0;// max consecutive l,r,ud
        int f_lr =0; int f_ud=0;
            for(int i = 0;i < s.length();i++){
        if(s.charAt(i) == 'L')
                f_lr++;
            else if(s.charAt(i) == 'R')
                f_lr--;
            else if(s.charAt(i) == 'U')
                f_ud++;
            else
                f_ud--;

                if(f_lr>=0) //more left than right
                t_l = Math.max(t_l, f_lr);
                else
                t_r = Math.min(t_r, f_lr);

                if(f_ud>=0) t_u = Math.max(t_u, f_ud);
                else t_d =Math.min(t_d, f_ud);
            }
        if(t_l-t_r<m && t_u-t_d<n)
        return 1;

        return 0;
    }
}