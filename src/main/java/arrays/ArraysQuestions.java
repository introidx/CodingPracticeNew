package arrays;

import java.util.*;

class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}


public class ArraysQuestions {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        List<Pair<Integer, Integer>> pairs = findUniquePairs(arr);
        //System.out.println(pairs.size());
        for (Pair<Integer, Integer> pair : pairs) {
            //System.out.println("(" + pair.get(0) + ", " + pair.get(1) + ")");
            System.out.println(pair.getKey() + "  " + pair.getValue());
        }
    }


    public static List<Pair<Integer, Integer>> findUniquePairs(int[] arr) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                int power = (int) Math.round(Math.pow(sum, 1.0/3));

                if (Math.pow(power, 3) == sum) {
                    int complement = (3 * (int) Math.pow(power, 3) - sum) / 2;
                    if (map.containsKey(complement) && map.get(complement) > i) {
                        pairs.add(new Pair<>(arr[i], arr[j]));
                    }
                }
            }
        }

        for (Pair<Integer, Integer> pair : pairs) {
            System.out.println("(" + pair.getKey() + ", " + pair.getValue() + ")");
        }

        return pairs;
    }



    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int longest = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pathLength = dfs(matrix, i, j, dp, m, n);
                longest = Math.max(pathLength, longest);
            }
        }
        return longest;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int dfs(int[][] matrix, int i, int j, int[][] dp, int m, int n) {
        if (dp[i][j] > 0) return dp[i][j];
        int max = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, x, y, dp, m, n));
            }
        }
        dp[i][j] = max + 1;
        return max + 1;

    }


    static int[] separatePositiveAndNegative(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums;

        int start = 0;
        int end = nums.length - 1;
        int index = 0;

        while (index <= end && start < end) {
            if (nums[index] < 0) {
                int temp = nums[index];
                nums[index] = nums[start];
                nums[start] = temp;
                start++;
                index++;
            } else {
                index++;
            }
        }
        return nums;
    }

    public static int[] nge(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;

        ans[n - 1] = -1;
        stack.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int max = -1;
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                max = stack.peek();
            }
            stack.push(arr[i]);
            ans[i] = max;
        }
        return ans;
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int rem = i - j * j;
                if (dp[rem] < min) {
                    min = dp[rem];
                }
            }
            dp[i] = 1 + min;
        }
        return dp[n];
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 0;

        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return -1;
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int hLen = horizontalCuts.length;
        int vLen = verticalCuts.length;

        int maxHeight = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[hLen - 1]);
        for (int i = 1; i < hLen; i++) {
            int yDiff = horizontalCuts[i] - horizontalCuts[i - 1];
            maxHeight = Math.max(yDiff, maxHeight);
        }

        int maxWidth = Math.max(verticalCuts[0] - 0, w - verticalCuts[vLen - 1]);
        for (int i = 1; i < vLen; i++) {
            int xDiff = verticalCuts[i] - verticalCuts[i - 1];
            maxWidth = Math.max(maxWidth, xDiff);
        }

        return maxHeight * maxWidth;

    }

    public long countExcellentPairs(int[] nums, int k) {

        long count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int n = set.size();


        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                long x = countSetBits1(nums[i] & nums[j]) + countSetBits1(nums[i] | nums[j]);
                if (x >= k) count++;
            }
        }
        return count;
    }

    public int countSetBits1(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
// time - O(m +n)

    public static void findUnion(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            map.put(i, 1);
        }

        for (int i : arr2) {
            if (map.containsKey(i)) {
                System.out.println(i);
                map.remove(i);
            }
        }

//        for (int i : map.keySet()){
//
//        }
/*
        int n = arr1.length, m = arr2.length;
        int i =0,j =0;

        while (i < n && j < m){
            if(arr1[i] < arr2[j]){
                System.out.println(arr1[i++]);
            }else if(arr1[i] > arr2[j]){
                System.out.println(arr2[j++]);
            }else{
                System.out.println(arr1[i++]);
                j++;
            }
        }

        while (i < n){
            System.out.println(arr1[i++]);
        }
        while (j < m){
            System.out.println(arr2[j++]);
        }

 */

    }

    public int maximumGood(int[][] s) {
        int n = s.length;
        if (n == 2) {
            return callFortwo(s);
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j] == 0) {
                    arr[s[i][j]]--;
                } else if (s[i][j] == 1) {
                    arr[s[i][j]]++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;

    }

    private int callFortwo(int[][] s) {
        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s[i][j] == 0) {
                    arr[s[i][j]]--;
                } else if (s[i][j] == 1) {
                    arr[s[i][j]]++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int theOther = (60 - t % 60) % 60;
            ans += count.getOrDefault(theOther, 0); // in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); // update the number of t % 60.
        }
        return ans;

    }

    public void someFun() {

    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // swap the columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        Arrays.sort(intervals, (arr1, arr2) -> arr2[0] - arr1[0]);

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1])
                // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a != 0 || b != 0 || c != 0) {
            int A = a & 1;
            int B = b & 1;
            int C = c & 1;
            if (C == 1) {
                if (A == 0 && B == 0) {
                    count++;
                }
            } else {
                if (A == 1 && B == 1) {
                    count += 2;
                } else if (A == 1 || B == 1) {
                    count++;
                }
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return count;
    }

    public static int reversePairs(int[] nums) {
        int pairs = 0;
        int n = nums.length;
        int mod = (int) 1e9;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if ((nums[i]) % mod > (2 * nums[j]) % mod) {
//                    System.out.println(2 * nums[j]);
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];


        Arrays.fill(candies, 1);

        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        sum += candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;

    }

    /**
     * @param arr = [11,13,21,3]
     */
    public static int[] printNGE(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nge;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        if (n < 2) return nums[0];

        return Math.max(
                rob(new int[n], nums, 0, n - 1),
                rob(new int[n], nums, 1, n)
        );


    }

    /**
     * rob 0, n-2
     * rob 1 , n-1
     */
    public int rob(int[] arr, int[] nums, int start, int end) {
        if (start == 0) {
            arr[0] = nums[0];
            arr[1] = Math.max(nums[0], nums[1]);
        } else {
            arr[1] = nums[1];
        }

        for (int i = 2; i < end; i++) {
            arr[i] = Math.max(nums[i] + arr[i - 2], arr[i - 1]);
        }
        return arr[end - 1];
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry e = pq.poll();
            res[i] = (int) e.getKey();
        }
        return res;
    }

    public int longestPalindromeSubseq(String str) {
        int n = str.length();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; i < n; i++) {
                if (str.charAt(i) == str.charAt(j)) {
                    arr[i][j] = 2 + arr[i + 1][j];
                } else {
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[0][n - 1];
    }

    public int[] sortArray(int[] nums) {
        if (nums.length == 0) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = nums[(start + end) % 2];
        int left = start, right = end;

        while (left <= right) {
            while (left <= right && pivot > nums[left])
                left++;

            while (left <= right && pivot > nums[right])
                right--;

            while (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int product = 1;
        int result = 0;

        while (right <= nums.length) {
            product = product * nums[right];
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;

    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
            int setBits = countSetBits(i);
            map.put(i, setBits);
        }

        Collections.sort(list, (a, b) ->
                map.get(a) == map.get(b) ?
                        a - b :
                        map.get(a) - map.get(b));

        // list has sorted keys according to count values
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public int minOperations(int n) {
        // arr[i] =(2 * i) +1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (2 * i) + 1;
        }

        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left <= right) {
            while (arr[left] != arr[right]) {
                arr[left] += 1;
                arr[right] -= 1;
                count++;
            }
            left++;
            right--;
        }
        return count;
    }

    public int[][] restoreMatrix(int[] row, int[] col) {
        int m = row.length;
        int n = col.length;
        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = Math.min(row[i], col[j]);
                row[i] -= mat[i][j];
                col[j] -= mat[i][j];
            }
        }

        return mat;

    }


    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid > 0 && mid < high && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid > 0 && mid < nums.length - 1 && nums[mid] == nums[mid - 1] && (mid - 1) % 2 == 0 ||
                    mid > 0 && mid < nums.length - 1 && nums[mid] == nums[mid + 1] && (mid + 1) % 2 != 0
            ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nums[low];


    }


    public static void printArray(int[][] arr) {
        //m -rows
        // n - cols
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int longestConsecutive(int[] nums) {
        //  Input: nums = [100,4,200,1,3,2]
        //  Output: 4
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);

        int maxStreak = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int current = i;
                int currentStreak = 1;

                while (set.contains(current + 1)) {
                    current = current + 1;
                    currentStreak++;
                }

                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }
        return maxStreak;
    }

    public static boolean canReach(int nums[], int start) {
        if (nums[start] == 0) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (queue.size() > 0) {
            int curr = queue.poll();
            if (nums[curr] == 0) {
                return true;
            }
            int index = curr - nums[curr];
            if (index >= 0 && !visited.contains(index)) {
                visited.add(index);
                queue.offer(index);
            }
            index = curr + nums[curr];
            if (index < nums.length && !visited.contains(index)) {
                visited.add(index);
                queue.offer(index);
            }
        }
        return false;
    }

    // [3, 2, -2, 5, -3]
    public static int findK(int[] arr) {
        Arrays.sort(arr);
        // -3,-2, 2, 3,5
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            if (arr[i] == -arr[j]) {
                return arr[j];
            }
            if (arr[j] > -arr[i]) {
                j--;
            } else {
                i++;
            }

        }
        return 0;


    }

    public static int step(Integer[] input) {
        if (input == null || input.length == 0) return 0;
        int steps = 0;
        Arrays.sort(input, Collections.reverseOrder());

        for (int i = 1; i < input.length; i++) {
            if (input[i] != input[i - 1]) {
                steps += i;
            }
        }

        return steps;

    }

    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;

        int start = 0;
        int end = nums.length - 1;
        int index = 0;

        while (index <= end && start < end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;

            } else {
                index++;
            }
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) end--;
                else start++;

                if (Math.abs(sum - target) < Math.abs(target - result))
                    result = sum;
            }
        }

        return result;
    }

    public static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingLong(arr -> arr[0]));
        int max = 0;
        if (events.length == 1) return events[0][2];
        if (events.length == 2) {
//            System.out.println("i am here");
            int[] event1 = events[0];
            int[] event2 = events[1];

            boolean isNotOver =
                    isNotOverlapping(event1[0], event1[1],
                            event2[0], event2[1]);

            if (isNotOver) {
                int maxEither = Math.max(event1[2], event1[2]);
                int sum = event1[2] + event2[2];
                max = Math.max(maxEither, sum);
                return max;
            } else {
                return Math.max(event1[2], event2[2]);
            }
        }


        for (int i = 0; i < events.length - 1; i++) {
            int[] event1 = events[i];
            int currMax = event1[2];
            max = Math.max(max, currMax);

            for (int j = i + 1; j < events.length; j++) {
                int[] event2 = events[j];

                boolean isNotOver =
                        isNotOverlapping(event1[0], event1[1],
                                event2[0], event2[1]);

                if (isNotOver) {
//                    System.out.println(isNotOver);
                    currMax = event1[2] + event2[2];
//                    System.out.println(currMax);
                    max = Math.max(max, currMax);
                }
            }
        }

        return max;

    }

    public static boolean isNotOverlapping(long start1, long end1, long start2, long end2) {
        if (start2 > start1 && end2 > end1 && start2 > end1 && end2 > start1 && end1 < start2) {
//            System.out.println("start1 = " + start1 + " end1= "+end1 + " start2 = " + start2 + " end2 = " + end2);
            return true;
        }
        return false;
    }


}
