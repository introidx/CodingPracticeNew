package dp.striver;

import java.time.chrono.MinguoDate;
import java.util.Arrays;

public class dp22_CoinChange2 {

    // recursion
    public int f(int index, int[] arr, int T){
        if(index == 0){
            return T % arr[0] == 0 ? 1 : 0;
        }

        int notTake = f(index -1, arr, T );
        int take  =0;
        if (arr[index] <= T){
            take = f(index, arr, T - arr[index]);
        }

        return take + notTake;
    }

    // Memoization
    public long fM(int index, int[] arr, int T,long[][] dp){
        if(index == 0){
            return T % arr[0] == 0 ? 1 : 0;
        }

        if (dp[index][T] != -1) return dp[index][T];

        long notTake = fM(index -1, arr, T , dp);
        long take  =0;
        if (arr[index] <= T){
            take = fM(index, arr, T - arr[index], dp);
        }

        return dp[index][T] = take + notTake;
    }

    long countWaysToMakeChange(int[] arr, int n, int T){

        long dp[][]=new long[n][T+1];
        for(long row[]: dp)
            Arrays.fill(row,-1);
        return fM(n-1, arr,  T, dp);
    }

    // tabulation
    static long countWaysToMakeChangeTabulation(int[] arr, int n, int T){
        int[][] dp = new int[n][T +1];

        for (int t =0 ; t <= T; t++){
            dp[0][t] = t % arr[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < n ; i++){
            for (int j = 0; j <= T ; j++){
                int notTake = dp[i -1][j];
                int take =0;
                if(arr[i] <= j){
                    take = dp[i][j - arr[i]];
                }
                dp[i][j] = take + notTake;
            }
        }

        return dp[n-1][T];
    }
}
