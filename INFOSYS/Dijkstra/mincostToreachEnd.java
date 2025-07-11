package INFOSYS.Dijkstra;

import java.io.*;
import java.util.*;

public class mincostToreachEnd {
    public static int minCostToReachEnd(int[] A) {
        int n = A.length;
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); below line means same as above line
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0}); // {index, cost}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[0];
            int c = current[1];

            if (c > cost[i]) continue;

            // Move to next index (i + 1) with cost 1
            if (i + 1 < n && c + 1 < cost[i + 1]) {
                cost[i + 1] = c + 1;
                pq.offer(new int[]{i + 1, cost[i + 1]});
            }

            // Jump to any j > i such that A[j] % A[i] == 0
            for (int j = 2 * (i + 1) - 1; j < n; j += (i + 1)) {
                if (A[j] % A[i] == 0) {
                    int jumpCost = c + A[i];
                    if (jumpCost < cost[j]) {
                        cost[j] = jumpCost;
                        A[j]++; // Increase A[j] by 1 as per rule
                        pq.offer(new int[]{j, jumpCost});
                    }
                }
            }
        }

        return cost[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        pw.println(minCostToReachEnd(A));
        pw.flush();
    }
}
