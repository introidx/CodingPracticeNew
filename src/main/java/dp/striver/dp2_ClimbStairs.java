package dp.striver;

public class dp2_ClimbStairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2){return n;}
        int[] arr = new int[n];
        arr[0] =1;
        arr[1] =2;
        for (int i =2; i< n ; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }

      public int climbStairsSpaceOptimised(int n) {
          if(n == 0 || n == 1 || n == 2){return n;}
          int a = 1;
          int b = 2;
          int c = 0;

          for (int i =2; i < n ; i++){
              c = a+ b;
              a= b;
              b= c;
          }
           return b;
      }


    // Recursion will give TLE
     public int climbStairsRecursion(int n) {
         if(n == 0 || n == 1 || n == 2){return n;}
         return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
     }
}
