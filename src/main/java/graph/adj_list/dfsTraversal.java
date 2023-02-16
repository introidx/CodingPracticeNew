package graph.adj_list;

import java.util.*;
import java.util.Scanner;

public class dfsTraversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // vertex
        int e = sc.nextInt(); // edge

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            adj.get(s).add(d);
        }

        ArrayList<Integer> res = dfsTraversal(v, adj);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> dfsTraversal(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v + 1];
        ArrayList<Integer> storeDfs = new ArrayList<>();

        for (int i = 1; i <= v; i++) {
            if (vis[i] == false) {
                dfs(i, storeDfs, vis, adj);
            }
        }
        return storeDfs;
    }

    private static void dfs(int node, ArrayList<Integer> storeDfs, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        storeDfs.add(node);
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, storeDfs, vis, adj);
            }
        }
    }

    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] graph, boolean[] visited, int i) {
        for (int j = 0; j < graph[0].length; j++) {
            if (graph[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(graph, visited, j);
            }
        }

    }
}
