package graph;

import java.util.*;

/**
 * Created by PRAKASH RANJAN on 11-07-2022
 */
public class GeneralGraphProblems {
    public static void main(String[] args) {
//        static int x =0;
        Test t = new Test();
        System.out.println(t.x + " " + t.y);
        HashMap<Integer, Integer> map = new HashMap<>();


//        System.out.println(20);
//        Integer[] arr = {1,2,3,4,5};
//        Arrays.sort(arr, Comparator.reverseOrder());
//
//        for (int i : arr){
//            System.out.println(i);
//        }

    }

//    static int fun(){
//        static int c= 0;
//        return ++c;
//    }

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
