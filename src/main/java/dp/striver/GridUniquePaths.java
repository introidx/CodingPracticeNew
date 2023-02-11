package dp.striver;

/**
 * Created by PRAKASH RANJAN on 11-02-2023
 */
public class GridUniquePaths {


    public static int gridUniquePathsWithObstacle(int[][] points, int m, int n, int[][] dp){

        for (int i =0; i < m; i++){
            for (int j =0; j < n ; j++){
                if (points[i][j] == -1) dp[i][j] =0;
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }else{
                    int right =0, down = 0;
                    if(i > 0) down = dp[i-1][j];
                    if(j > 0) right = dp[i][j-1];
                    dp[i][j] = down + right;
                }

            }
        }
        return dp[m-1][n-1];
    }

    // tabulation
    public static int gridUniquePaths2( int m, int n, int[][] dp){

        for (int i =0; i < m; i++){
            for (int j =0; j < n ; j++){
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int right =0, down = 0;
                if(i > 0) down = dp[i-1][j];
                if(j > 0) right = dp[i][j-1];
                dp[i][j] = down + right;
            }
        }
        return dp[m-1][n-1];
    }
    // memoization
    //Time Complexity: O(M*N)
    //Reason: At max, there will be M*N calls of recursion.
    //Space Complexity: O((N-1)+(M-1)) + O(M*N)
    public static int gridUniquePaths( int i, int j, int[][] dp){
        if (i == 0  && j == 0){
            return 1;
        }
        if (i < 0 || j < 0) return 0;

        int up = gridUniquePaths( i-1, j , dp);
        int left = gridUniquePaths( i , j -1, dp);

        return dp[i][j] = up + left;

    }

    public static void main(String[] args) {
        int m=3;
        int n=3;

        int[][] dp = new int[m][n];
        int[][] points = {{0,0,0}, {0,-1, 0}, {0,0,0}};
        System.out.println(gridUniquePathsWithObstacle(points, m, n, dp));

    }
}
