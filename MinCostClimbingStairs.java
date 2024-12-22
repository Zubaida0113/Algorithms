public class MinCostClimbingStairs {
    // recursive solution
        public int minCostClimbingStairs(int[] cost) {
            // Start from step 0 or step 1 because 2 decision trees are being made
            return Math.min(minCost(0, cost), minCost(1, cost));
        }
    
        private int minCost(int i, int[] cost) {
            // Base case: If we go beyond the last step
            if (i >= cost.length) {
                return 0;
            }
            // Recursive case
            return cost[i] + Math.min(minCost(i + 1, cost), minCost(i + 2, cost));
        }
// Memoization(Top-Down) 
// Time Complexity (With Memoization):𝑂(𝑛)
// O(n): Each step is calculated only once.
// Space Complexity (With Memoization):𝑂(𝑛)
// O(n): Space for the memoization map and recursion stack.
        public int minCostClimbingStairs(int[] cost,int[]dp) {
            // Start from step 0 or step 1 because 2 decision trees are being made
            return Math.min(minCostDP(0, cost,dp), minCostDP(1, cost,dp));
        }
        private int minCostDP(int n, int[] cost,int[]dp) {
            // Base case: If we go beyond the last step
            if (n >= cost.length) {  // ex, n=3 after increment ,3>=3(cost.length) return 0
                return 0;
            }
            if(dp[n]!=0){
                return dp[n];
            }
            // Recursive case
            return dp[n]= cost[n] + Math.min(minCostDP(n + 1, cost,dp), minCostDP(n + 2, cost,dp));
        }
        // Tabulation
        public int minCostClimbingStairsDP(int[] cost) {
            int n = cost.length;
            int prev = 0, curr = 0;
    
            for (int i = 2; i <= n; i++) {
                int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
                prev = curr;
                curr = next;
            }
            return curr;
        }
        // Initialization:
    // prev = 0, curr = 0.
    // Iteration:𝑖=2
    // i=2:
    // next = Math.min(curr + cost[1], prev + cost[0])
    // next = Math.min(0 + 15, 0 + 10) = 10.
    // Update: prev = 0, curr = 10.
    // 𝑖= 3
    //  i=3:
    // next = Math.min(curr + cost[2], prev + cost[1])
    // next = Math.min(10 + 20, 0 + 15) = 15.
    // Update: prev = 10, curr = 15.
    // Final Result:
    // Return curr = 15.
    // The minimum cost to climb to the top of the staircase is 15.
    
    
        public static void main(String[] args) {
            MinCostClimbingStairs solution = new MinCostClimbingStairs();
            int[] cost = {10, 15, 20};
            int[] dp=new int[cost.length+1];
            System.out.println(solution.minCostClimbingStairs(cost)); // Output: 15
            System.out.println(solution.minCostClimbingStairs(cost,dp)); // Output: 15
            System.out.println(solution.minCostClimbingStairsDP(cost)); // Output: 15
        }
    }
    