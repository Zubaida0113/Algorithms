package INFOSYS;

import java.io.*;
import java.util.*;

public class goodSubarray {
    
    public static int maxSumGoodSubarray(int [] A, int n,int k){
        int l=0, r=0;
        int currsum = 0;
        int maxsum = 0;
        Map<Integer,Integer> freq= new HashMap<>();

        for(r=0;r<n;r++){
            freq.put(A[r], freq.getOrDefault(A[r],0)+1);
            currsum +=A[r];

            while(freq.size()>k){
                freq.put(A[l],freq.getOrDefault(A[l],0)-1);
                currsum -=A[l];

                if(freq.get(A[l])==0){
                    freq.remove(A[l]);
                }
                l++;
            }

            //negative case
            if(currsum<0){
                currsum=0;
                freq.clear();
                l=r+1;
          }

            maxsum = Math.max(maxsum,currsum);
        }
        return maxsum;
    }
    public static void main(String[] args) throws IOException{
        long start = System.nanoTime();  // Start timing

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        PrintWriter out = new PrintWriter(System.out);  // Fast output

        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());
        int[] A = new int[n];

        // Efficient input using StringTokenizer
        int i = 0;
        while (i < n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && i < n) {
                A[i++] = Integer.parseInt(st.nextToken());
            }
        }

        out.println(maxSumGoodSubarray(A, n, k));  // Fast output
        out.flush();  // Don't forget to flush
        long end = System.nanoTime();
System.out.println("Time taken: " + (end - start) / 1_000_000 + " ms");
        // this is for input like this 
        // 11
        // 2
        // 1 2 2 3 2 3 5 1 2 1 1

        // StringTokenizer st= new StringTokenizer(br.readLine());

        // int[]arr=new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i]=Integer.parseInt(st.nextToken());
        //     System.out.println();
        // }
        // int sum = goodSub(arr,n,k);
        // System.out.println(sum);
    }
}
// test case 1   o/p - 6    
// 5
// 5
// -1
// 1
// 3
// 2
// -1
// test case 2 o/p - 12
// 11   
// 2
// 1
// 2
// 2
// 3
// 2
// 3
// 5
// 1
// 2
// 1
// 1