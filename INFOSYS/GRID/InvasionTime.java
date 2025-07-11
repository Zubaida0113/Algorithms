package INFOSYS.GRID;

import java.io.*;
import java.util.*;

public class InvasionTime {

    static int[] dx = {0, 0, 1, -1}; // Right, Left, Down, Up
    static int[] dy = {1, -1, 0, 0};

    public static int minTimeToInvadeAll(char[][] grid, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        int totalE = 0;

        // Step 1: Find all 'A' and count 'E'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    q.offer(new int[]{i, j, 0}); // x, y, time
                }
                if (grid[i][j] == 'E') {
                    totalE++;
                }
            }
        }

        int maxTime = 0;

        // Step 2: Multi-source BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1], t = curr[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 'E') {
                    grid[nx][ny] = 'A'; // invaded
                    totalE--;
                    q.offer(new int[]{nx, ny, t + 1});
                    maxTime = t + 1;
                }
            }
        }

        return (totalE == 0) ? maxTime : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().trim().toCharArray();
        }

        System.out.println(minTimeToInvadeAll(grid, n, m));
    }
}
