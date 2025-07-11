package INFOSYS.Dijkstra;

import java.io.*;
import java.util.*;

public class dijkstra {

    public static int[] shortestPath(List<List<int[]>> adjList,int src, int V){
        //min-heap PQ {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)-> {
            //choosing criteria of shortest path at each step - greedy approach
            if(x[0] == y[0]) return x[1] - y[1];   //ascending order of node
            return x[0] - y[0]; //ascending order of distance
        });

        int[] dist= new int[V]; //distance array to store shortest distance from source to each node
        Arrays.fill(dist,(int)1e9); //initialize distances to infinity
        dist[src]=0; //distance from source to itself is 0

        pq.offer(new int[]{0,src}); //add source to the priority queue with distance 0

        while(!pq.isEmpty()){
            int[] curr= pq.poll(); //get shortest dist node out of PQ
            int distance =curr[0];
            int node = curr[1];

            for(int[] neighbor : adjList.get(node)){
                int nextNode = neighbor[0];
                int edgeWeightToNeighbor = neighbor[1];
                //relaxation step
                if(distance + edgeWeightToNeighbor < dist[nextNode]){
                    dist[nextNode] = distance + edgeWeightToNeighbor; //update distance to neighbor in dist[]
                    pq.offer(new int[]{dist[nextNode], nextNode}); //add updated distance to PQ
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V= Integer.parseInt(br.readLine().trim());
        int E= Integer.parseInt(br.readLine().trim());
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Read all edges
        for (int i = 0; i < E; i++) {
            String[] parts = br.readLine().trim().split(" ");
            int u = Integer.parseInt(parts[0]); // from node
            int v = Integer.parseInt(parts[1]); // to node
            int w = Integer.parseInt(parts[2]); // weight

            adjList.get(u).add(new int[]{v, w});
            // If undirected, also add reverse:
            // adjList.get(v).add(new int[]{u, w});
        }
         // Read source node
        int src = Integer.parseInt(br.readLine().trim());

        // Get shortest paths
        int[] distances = shortestPath(adjList, src, V);

        int mindist= Integer.MAX_VALUE;
        // Print distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To node " + i + ": " + (distances[i] == (int) 1e9 ? "INF" : distances[i]));
            mindist = Math.min(mindist, distances[i]);
        }
        System.out.println("Minimum distance from source to last node: " + mindist);
    }
}
