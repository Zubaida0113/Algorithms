// Example of 1-D memoization
// Time complexity - O(N)
// Space complexity - O(N)

// Find the nth fibonacci number
import java.util.*;
public class fibonacci_DP {
    static final long MOD = 1000000007; // Use modulus to handle large values.

    static long topDown(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return topDownHelper(n, dp);
    }

    static long topDownHelper(int n, long[] dp) {
        if (n <= 1) {
            return n;
        }
    // if topDownHelper(n) has already 
    // been computed we do not
    // do further recursive 
    // calls and hence reduce 
    // the number of repeated
    // work
        if (dp[n] != -1) {
            return dp[n];
        }
        // store the computed value
        // of topDownHelper(n) in an array 
        // dp at index n to so that 
        // it does not needs to be 
        // precomputed again
        dp[n] = (topDownHelper(n - 1, dp) % MOD + topDownHelper(n - 2, dp) % MOD) % MOD;

        return dp[n];
    }

    static long bottomUp(int n) {
        if (n <= 1) {
            return n;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            while (T-- > 0) {
                int n = sc.nextInt();
                
                long topDownans = topDown(n);
                long bottomUpans = bottomUp(n);
                if (topDownans != bottomUpans)
                    System.out.println("Not equal"+ (-1));
                else
                    System.out.println("Answer "+topDownans);

                System.out.println("~");
            }
        }
    }
}

// 1ms time compexity  TOP-DOWN
class Solution {
    int[] dp=new int[100000];;
    public int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
       return dp[n]= fib(n-1)+fib(n-2);
        }
}
// 0ms time complexity TABULATION
class Solution1 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
           dp[i]= dp[i-1]+dp[i-2];
         }
        return dp[n];
    }
}