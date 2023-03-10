package dp.striver;

import java.util.Arrays;

public class dp24_RodCuttingProblem {

    public int f(int index, int[] price, int N) {
        // N == target
        // base case

        if (index == 0) {
            return price[0] * N;
        }


        int notTake = 0 + f(index - 1, price, N);
        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= N) {
            take = price[index] + f(index, price, N - rodLength);
        }

        return Math.max(take, notTake);
    }

    static int cutRodUtil(int[] price, int ind, int N, int[][] dp) {
        //Time Complexity: O(N*N)
        //Reason: There are N*(N+1) states therefore at max ‘N*(N+1)’ new problems will be solved.
        //Space Complexity: O(N*N) + O(N)

        if (ind == 0) {
            return N * price[0];
        }

        if (dp[ind][N] != -1)
            return dp[ind][N];

        int notTaken = 0 + cutRodUtil(price, ind - 1, N, dp);

        int taken = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= N)
            taken = price[ind] + cutRodUtil(price, ind, N - rodLength, dp);

        return dp[ind][N] = Math.max(notTaken, taken);
    }


    static int cutRod(int[] price, int N) {


        int dp[][] = new int[N][N + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return cutRodUtil(price, N - 1, N, dp);
    }

    // Tabulation
    static int cutRodTabulation(int[] price,int N) {

        int dp[][]=new int[N][N+1];

        for(int row[]:dp)
            Arrays.fill(row,-1);

        for(int i=0; i<=N; i++){
            dp[0][i] = i*price[0];
        }

        for(int ind=1; ind<N; ind++){
            for(int length =0; length<=N; length++){

                int notTaken = 0 + dp[ind-1][length];

                int taken = Integer.MIN_VALUE;
                int rodLength = ind+1;
                if(rodLength <= length)
                    taken = price[ind] + dp[ind][length-rodLength];

                dp[ind][length] = Math.max(notTaken,taken);
            }
        }

        return dp[N-1][N];
    }
}
