package dp.striver;

import java.util.Arrays;

public class dp3_FrogJump {

    // https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
    public int frogJump(int[] arr, int index){
        if(index == 0) return 0;
        int one = frogJump(arr, index -1) + Math.abs(arr[index] - arr[index-1]);
        int two =0;
        if (index > 1){
            two = frogJump(arr, index -2) + Math.abs(arr[index] - arr[index-2]);
        }
        return Math.min(one, two);
    }

    /**
     *
     * @param arr -> Given array
     * @param dp -> initialised with -1
     * @param index
     * @return
     */
    public int frogJumpDp(int[] arr,int[] dp, int index){
        if(index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        int one = frogJumpDp(arr, dp, index -1) + Math.abs(arr[index] - arr[index-1]);
        int two =0;
        if (index > 1){
            two = frogJumpDp(arr, dp, index -2) + Math.abs(arr[index] - arr[index-2]);
        }
        return dp[index] = Math.min(one, two);
    }

    public int frogJumpDpTabulation(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int i =1; i < n ; i++){
            int one = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int two = 0;
            if (i > 1){
                two = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }

            dp[i] = Math.min(one, two);
        }

        return dp[n-1];
    }

    public int frogJumpSpaceOptimised(int[] arr){
        int height[]={30,10,60,10,60,50};
        int n=height.length;
        int prev=0;
        int prev2=0;
        for(int i=1;i<n;i++){

            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= prev + Math.abs(height[i]-height[i-1]);
            if(i>1)
                jumpTwo = prev2 + Math.abs(height[i]-height[i-2]);

            int cur_i=Math.min(jumpOne, jumpTwo);
            prev2=prev;
            prev=cur_i;

        }
        return prev;
    }


}
