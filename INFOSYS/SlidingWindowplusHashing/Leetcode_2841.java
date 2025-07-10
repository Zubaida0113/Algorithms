package INFOSYS.SlidingWindowplusHashing;
import java.io.*;
import java.util.*;
/*2841. Maximum Sum of Almost Unique Subarray
You are given an integer array nums and two positive integers m and k.
Return the maximum sum out of all almost unique subarrays of length k of nums. If no such subarray exists, return 0.
A subarray of nums is almost unique if it contains at least m distinct elements.
Type : max subarray sum with unique elements with k fixed length and atleast m distinct elements or more.
*/

public class Leetcode_2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        int l=0,r=0;
        long currsum=0,maxsum=0;
        int n= nums.size();
        Map<Integer,Integer> freq=new HashMap<>();

        for(r=0;r<k;r++){
            freq.put(nums.get(r),freq.getOrDefault(nums.get(r),0)+1);
            currsum+=nums.get(r);
        }
        if(freq.size()>=m){
            maxsum=currsum;
        }
        for(r=k;r<n;r++){
            freq.put(nums.get(r),freq.getOrDefault(nums.get(r),0)+1);
            currsum+=nums.get(r);

            freq.put(nums.get(l),freq.get(nums.get(l))-1);
            currsum-=nums.get(l);
            l++;
            if(freq.get(l)==0){
                freq.remove(nums.get(l));
            }
            if (freq.size() >= m) {
                maxsum = Math.max(maxsum, currsum);
            }
        }
        return maxsum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n= Integer.parseInt(br.readLine().trim());
        int m= Integer.parseInt(br.readLine().trim());
        int k= Integer.parseInt(br.readLine().trim());
        List<Integer> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Leetcode_2841 solution = new Leetcode_2841();
        long result = solution.maxSum(nums, m, k);
        out.println(result);
        out.flush();
        br.close();
    }
}
