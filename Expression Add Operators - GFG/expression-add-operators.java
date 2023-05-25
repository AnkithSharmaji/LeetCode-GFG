//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> addOperators(String S, int target) {
        // code here
       List<String> result = new ArrayList<>();
        backtrack(result, S, target, "", 0, 0, 0);
        return new ArrayList<>(result);
    }

    private static void backtrack(List<String> result, String num, int target, String expression, int index, long eval, long prevNum) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break; // Avoid leading zeros
            }

            long currentNum = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                backtrack(result, num, target, expression + currentNum, i + 1, currentNum, currentNum);
            } else {
                backtrack(result, num, target, expression + "+" + currentNum, i + 1, eval + currentNum, currentNum);
                backtrack(result, num, target, expression + "-" + currentNum, i + 1, eval - currentNum, -currentNum);
                backtrack(result, num, target, expression + "*" + currentNum, i + 1, eval - prevNum + prevNum * currentNum, prevNum * currentNum);
            }
        }
    }
}