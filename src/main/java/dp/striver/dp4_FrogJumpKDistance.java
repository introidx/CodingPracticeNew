package dp.striver;

public class dp4_FrogJumpKDistance {

    //https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
    static int solveUtil(int ind, int[] height, int[] dp, int k){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if(ind-j>=0){
                int jump = solveUtil(ind-j, height, dp, k)+ Math.abs(height[ind]-
                        height[ind-j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }
        return dp[ind]= mmSteps;

    }

    static int solveUtilTabulation(int n, int[] height, int[] dp, int k){
        dp[0]=0;
        for(int i=1;i<n;i++){
            int mmSteps = Integer.MAX_VALUE;

            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump = dp[i-j]+ Math.abs(height[i]- height[i-j]);
                    mmSteps= Math.min(jump, mmSteps);
                }
            }
            dp[i]= mmSteps;
        }
        return dp[n-1];

    }
}
