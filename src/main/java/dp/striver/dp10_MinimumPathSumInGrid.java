package dp.striver;

/**
 * Created by PRAKASH RANJAN on 11-02-2023
 */
public class dp10_MinimumPathSumInGrid {

    public static int recursive(int i , int j , int[][] grid){
        // max path sum
        if(i == 0 && j == 0) return grid[i][j];
        if(i <0 || j < 0) return Integer.MAX_VALUE;

        int up = grid[i][j] + recursive(i-1, j, grid);
        int left = grid[i][j] + recursive(i, j-1, grid);

        return Math.max(up, left);

    }

    public static int memoization(int i, int j , int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[i][j];
        if(i <0 || j < 0) return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + memoization(i-1, j, grid, dp);
        int left = grid[i][j] + memoization(i, j-1, grid, dp);

        return dp[i][j] = Math.max(up, left);
    }

    public static int tabulation(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i =0; i < m ; i++){
            for (int j =0; j < n ; j++){
                dp[i][j] += grid[i][j];
                if(i > 0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j] , dp[i][j-1]);
                }else if(i > 0){
                    dp[i][j] += dp[i-1][j];
                }else if(j > 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
