package dp.striver;

/**
 * Created by PRAKASH RANJAN on 11-02-2023
 */
public class MaximumMinimumFallingPathSum {

    // Problem Link :  https://takeuforward.org/data-structure/minimum-maximum-falling-path-sum-dp-12/

    // recursive
    // TC- O(3^m)
    // Space - O(M)
    private static int findMaximumFallingSum(int i, int j , int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(j < 0 || j >= n) return (int) -1e9;
        if(i == 0) return grid[i][j];

        int up = grid[i][j] + findMaximumFallingSum(i-1, j, grid);
        int leftDiagonal = grid[i][j] + findMaximumFallingSum(i-1, j-1, grid);
        int rightDiagonal = grid[i][j] + findMaximumFallingSum(i-1, j+1, grid);

        return maximumOfThreeNumbers(up, leftDiagonal, rightDiagonal);
    }

    public static int maximumOfThreeNumbers(int a, int b, int c){
        return Math.max(a, Math.max(b,c));
    }

    // dp initialized with -1
    // tc -O(mxn)
    // Space = O(mxn) + O(M)(Recursion Stack Space)
    private static int findMaximumFallingSumMemoization(int i, int j , int[][] grid, int[][] dp){
        int m = grid.length;
        int n = grid[0].length;

        if(dp[i][j] != -1) return dp[i][j];

        if(j < 0 || j >= n) return (int) -1e9;
        if(i == 0) return grid[i][j];

        int up = grid[i][j] + findMaximumFallingSumMemoization(i-1, j, grid, dp);
        int leftDiagonal = grid[i][j] + findMaximumFallingSumMemoization(i-1, j-1, grid, dp);
        int rightDiagonal = grid[i][j] + findMaximumFallingSumMemoization(i-1, j+1, grid, dp);

        return dp[i][j] = maximumOfThreeNumbers(up, leftDiagonal, rightDiagonal);
    }

    // tabulation
    // Time Complexity: O(N*M)
    //Reason: There are two nested loops
    //Space Complexity: O(N*M)
    static int getMaxPathSum(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing first row - base condition
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = matrix[i][j] + dp[i-1][j];

                int leftDiagonal= matrix[i][j];
                if(j-1>=0) leftDiagonal += dp[i-1][j-1];
                else leftDiagonal += (int)Math.pow(-10,9);

                int rightDiagonal = matrix[i][j];
                if(j+1<m) rightDiagonal += dp[i-1][j+1];
                else rightDiagonal += (int)Math.pow(-10,9);

                dp[i][j] = Math.max(up, Math.max(leftDiagonal,rightDiagonal));

            }
        }

        int maxi = Integer.MIN_VALUE;

        for(int j=0; j<m;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }

        return maxi;
    }

}
