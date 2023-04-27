package graph;

import java.util.*;

/**
 * Created by PRAKASH RANJAN on 11-07-2022
 */

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class GeneralGraphProblems {
    public static void main(String[] args) {


    }


    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(map.containsKey(node.val)) return map.get(node.val);

        Node newnode = new Node(node.val, new ArrayList<>());
        map.put(newnode.val, newnode);

        for (Node neighbour : node.neighbors){
            newnode.neighbors.add(cloneGraph(neighbour));
        }

        return newnode;
    }



    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        final int[][] directions = {{1,0}, {-1,0}, {0,1} , {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int target = image[sr][sc];

        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for (int[] d : directions){
                int row = curr[0] + d[0];
                int col = curr[1] + d [1];

                if(isValid(row, col, image, target)){
                    image[row][col] = newColor;
                    queue.add(new int[]{row, col});

                }
            }
        }
        return image;

    }

    private boolean isValid(int row, int col, int[][] image, int target) {
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != target ) return false;
        return true;
    }

    /*
    [[1,1,1]
    [1,1,0]
    [1,0,1]]
     */
}

class Test{
    protected int x, y;
}
