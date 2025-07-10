package INFOSYS.SlidingWindowplusHashing;

import java.io.*;
import java.util.*;

/*1. Maximum sum contiguous subarray with all unique elements
Description: Given an array, find the contiguous subarray where all elements are distinct and the sum is maximum.
Type: max subarray sum with unique elements with no fixed length 
Example:
Input: [1, 2, 3, 3, 4, 5, 2, 1] → Output: 15, for subarray [3, 4, 5, 2, 1] 
 */

public class maxSumUniqueElements {

    public static int maxSumUnique(int[] arr,int n){
        Set<Integer> freq = new HashSet<>();
        int currsum = 0, maxsum = Integer.MIN_VALUE;
        int l = 0, r = 0;
        while(r<n){
            //new element - add to set and sum
            if(!freq.contains(arr[r])){
                freq.add(arr[r]);
                currsum+=arr[r];
                r++;
            }
            else{ // Duplicate found – shrink window from the left
                while(freq.contains(arr[r])){
                    freq.remove(arr[l]);
                    currsum-=arr[l];
                    l++;
                }
            }
            maxsum=Math.max(maxsum,currsum);
        }
        return n == 0 ? 0 : maxsum;
    }
    //using map
    // public static int maxSumUnique(int[] arr,int n){
    //     int currsum=0,maxsum=0;
    //     int l=0,r=0;
    //     Map<Integer,Integer> freq= new HashMap<>();
    //     for(r=0;r<n;r++){
    //         freq.put(arr[r],freq.getOrDefault(arr[r],0)+1);
    //         currsum+=arr[r];
    //         // if(freq.get(arr[r])==1){
    //         //     currsum+=arr[r];
    //         // }
    //         while(freq.get(arr[r])>1){
    //             freq.put(arr[l],freq.getOrDefault(arr[l],0)-1);
    //             currsum-=arr[l];
    //             if(freq.get(arr[l])==0){
    //                 freq.remove(arr[l]);
    //             }
    //             l++;
    //         }
    //         maxsum=Math.max(maxsum,currsum);
    //     }
    //     return maxsum;
    // }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int [] arr= new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(maxSumUnique(arr,n));
    }
}
