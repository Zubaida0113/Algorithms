package DP;

public class fibonnaci {
    //memoization approach to calculate Fibonacci numbers(Top-down approach)
    // Time Complexity: O(n)
    // Space Complexity: O(n) due to the memoization array
    static int fib(int n, int[] memo) {
        // Using memoization to store previously computed Fibonacci numbers
        if(n<=1){
            return n;
        }
        // Initialize dp array with -1 to indicate uncomputed values
        for(int i=0;i<=n;i++){
            memo[i]=-1;
        }
        memo[n]=fib(n-1, memo)+fib(n-2, memo);
        return memo[n];
    }
    
    public static void main(String[] args) {
        int n = 5; // Example input
        int memo[]=new int[n+1];
        System.out.println("Fibonacci of " + n + " using memozization is: " + fib(n,memo));
        System.out.println("Fibonacci of " + n + " using tabulation is: " + fib2(n));
        System.out.println("Fibonacci of " + n + " using space optimization is: " + fib3(n));
    }

        // Tabulation approach to calculate Fibonacci numbers (Bottom-up approach)
        // Time Complexity: O(n)
        // Space Complexity: O(n) due to the dp array
    static int fib2(int n){
        
    
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    static int fib3(int n){
        // Space optimized approach to calculate Fibonacci numbers
        // Time Complexity: O(n)
        // Space Complexity: O(1) as we are using only two variables
        
        int a=0,b=1,c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
