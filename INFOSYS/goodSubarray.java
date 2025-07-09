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

            maxsum = Math.max(maxsum,currsum);
        }
        return maxsum;
    }
    public static void main(String[] args) throws IOException{
        //fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine().trim());
        }

        System.out.println(maxSumGoodSubarray(A,n,k));
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
