public class HouseRobCircle {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // No houses
        if (n == 1) return nums[0]; // Only one house

        // Solve for both cases
        int case1 = robRecursive(nums, 0, n - 2); // Exclude the last house
        int case2 = robRecursive(nums, 1, n - 1); // Exclude the first house

        return Math.max(case1, case2); // Take the maximum of the two cases
    }

    private int robRecursive(int[] nums, int start, int end) {
        if (start > end) return 0; // Base case: no houses to rob

        // Recursive relation: rob the current house or skip it
        return Math.max(nums[start] + robRecursive(nums, start + 2, end), 
                        robRecursive(nums, start + 1, end));
    }

    public int robDP(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // No houses
        if (n == 1) return nums[0]; // Only one house
        
        // Case 1: Exclude the last house
        int case1 = robLinear(nums, 0, n - 2);
        // Case 2: Exclude the first house
        int case2 = robLinear(nums, 1, n - 1);
        
        // Return the maximum of the two cases
        return Math.max(case1, case2);
    }
    int robLinear(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0; // dp[i-2], dp[i-1]
        
        for (int i = start; i <= end; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1; // Maximum robbed amount
    }

    public static void main(String[] args) {
        HouseRobCircle houseRobber = new HouseRobCircle();
        int[] nums = {2, 3, 2}; // Example input

        int maxRobRecursive = houseRobber.rob(nums);
        int maxRobDP = houseRobber.robDP(nums);

        System.out.println("Maximum amount robbed (Recursive): " + maxRobRecursive);
        System.out.println("Maximum amount robbed (Dynamic Programming): " + maxRobDP);
    }
}
