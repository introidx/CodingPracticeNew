package graph.adj_list;

import java.util.*;

public class bfsTraversal {

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

        ArrayList<Integer> res = bfsTraversal(v, adj);
        for (int i : res) {
            System.out.println(i);
        }


    }

    public static ArrayList<Integer> bfsTraversal(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        vis[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int i : adj.get(node)) {
                if (vis[i] == false) {
                    vis[i] = true;
                    q.add(i);
                }
            }

        }
        return res;

    }

    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int count =0;

        for (int i =0; i < n ; i++){
            if (!visited[i]){
                bfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }

    private void bfs(int[][] graph, boolean[] visited, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()){
            int curr = q.poll();
            for(int j =0; j < graph[0].length; j++){
                if (graph[curr][j] == 1 && !visited[j]){
                    q.add(j);
                    bfs(graph, visited, j);
                }
            }

        }
    }


}
