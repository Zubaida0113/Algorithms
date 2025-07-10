package INFOSYS.SlidingWindowplusHashing;

import java.io.*;
import java.util.*;

/*2. LeetCode 2461 – Maximum Sum of Distinct Subarrays With Length K
Problem: Given nums[] and integer k, find the max subarray sum of exactly length k with all distinct elements.
Type: max subarray sum with unique elements with k fixed length 
Example:
[1,5,4,2,9,9,9], k = 3 → Best is [4,2,9], sum = 15 
Core Idea: Sliding window of size k + frequency map to check distinctness */
public class Leetcode_2461 {
    static int maxSumDistinctSubarray(int[] arr, int n ,int k){
        int l = 0, r = 0;
        int currsum = 0, maxsum = 0;
        Set<Integer> set = new HashSet<>();
        for ( r = 0; r < n; r++) {
        // Shrink window to make elements distinct
        while (set.contains(arr[r])) {
            set.remove(arr[l]);
            currsum -= arr[l];
            l++;
        }

        // Expand window
        set.add(arr[r]);
        currsum += arr[r];

        // Check if window size is exactly k
        if (r - l + 1 == k) {
            maxsum = Math.max(maxsum, currsum);

            // Slide window forward
            set.remove(arr[l]);
            currsum -= arr[l];
            l++;
        }   
        }
        return maxsum >= 0 ? maxsum : -1; // Return -1 if no valid subarray found
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken()); 
        }
        out.println(maxSumDistinctSubarray(nums, n, k));
        out.flush();
    }
}
