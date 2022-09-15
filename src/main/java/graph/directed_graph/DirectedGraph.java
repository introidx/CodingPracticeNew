package graph.directed_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by PRAKASH RANJAN on 07-07-2022
 */
class Edge {
    int source;
    int neighbour;

    Edge(int source, int neighbour) {
        this.source = source;
        this.neighbour = neighbour;
    }

}

public class DirectedGraph {

    class Abc{
        int a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }

        // code for topological sort
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for (int v = 0; v < vertices; v++) {
            if (visited[v] == false) {
                topologicalSort(graph, v, visited, stack);

            }
        }

        // print the stack
        while (!stack.isEmpty()){
            System.out.println(stack.pop());

        }

    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int source, boolean[] visited, Stack<Integer> stack) {
        visited[source] = true;
        for (Edge e : graph[source]) {
            if (visited[e.neighbour] == false) {
                topologicalSort(graph, e.neighbour, visited, stack);
            }
        }
        stack.push(source);
    }


}
