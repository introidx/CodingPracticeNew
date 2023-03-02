package dp.striver;

import java.util.Arrays;

/**
 * Created by PRAKASH RANJAN on 10-02-2023
 */
public class dp7_NinjaTraining {

    public static void main(String[] args) {
        int[][] points = {{10,40,70},
                {20,50,80},
                {30,60,90}};


        int n = points.length;

        int[][] dp = new int[n][4];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(f(n-1, 3, points, dp));

    }

    // memoization
    public static int f(int day, int last, int[][] points, int[][] dp){
        if(dp[day][last] != -1) return dp[day][last];

        if(day == 0){
            int max =0;
            for (int i = 0; i < 3 ; i++){
                if(i != last){
                    max = Math.max(max, points[day][i] );
                }
            }
            return dp[day][last] = max;
        }

        int max =0;
        for (int i =0 ; i < 3 ; i++){
            if(i != last){
                int activity = points[day][i] + f(day -1, i, points, dp);
                max = Math.max(max, activity);
            }
        }
        return dp[day][last] = max;

    }
}
