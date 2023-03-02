package dp.striver;

import java.util.List;

/**
 * Created by PRAKASH RANJAN on 11-02-2023
 */
public class Triangle {

    public static int recursive(List<List<Integer>> grid, int i, int j){
        int n = grid.size();
        if(i == n-1){
            return grid.get(n-1).get(j);
        }

        int down = grid.get(i).get(j) + recursive(grid, i+1, j);
        int diagonal = grid.get(i).get(j) + recursive(grid, i+ 1, j + 1);

        return Math.max(down, diagonal);
    }

    public static int memoization(List<List<Integer>> grid, int i, int j, int[][] dp){
        int n = grid.size();
        if(dp[i][j] != -1) return dp[i][j];
        if(i == n-1){
            return grid.get(n-1).get(j);
        }

        int down = grid.get(i).get(j) + memoization(grid, i+1, j, dp);
        int diagonal = grid.get(i).get(j) + memoization(grid, i+ 1, j + 1, dp);

        return dp[i][j] = Math.max(down, diagonal);
    }

    static int minimumPathSum(int[][] triangle, int n){
        int dp[][]= new int[n][n];

        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle[n-1][j];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){

                int down = triangle[i][j]+dp[i+1][j];
                int diagonal = triangle[i][j]+dp[i+1][j+1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];

    }

    static int minimumPathSum1(List<List<Integer>> list){
        int n = list.size();
        int dp[][]= new int[n][n];

        for(int j=0;j<n;j++){
            dp[n-1][j] = list.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){

                int down = list.get(i).get(j)+dp[i+1][j];
                int diagonal = list.get(i).get(j)+dp[i+1][j+1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];

    }

    public static void main(String args[]) {

        int triangle [][] = {{1},
                {2,3},
                {3,6,7},
                {8,9,6,10}};

        int n = triangle.length;

        System.out.println(minimumPathSum(triangle,n));
    }
}
