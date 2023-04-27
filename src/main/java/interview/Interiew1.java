package interview;

import com.sun.source.tree.Tree;

import java.util.*;

public class Interiew1 {

    public static void main(String[] args) {
        //pp(4,4);
        String s = "abacaba";
        System.out.println(partitionString(s));

    }

    // Input: nums = [1,3,1,1,2]
    public long[] distance(int[] nums) {
        long[] ans = new long[nums.length];
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList());
            }
            map.get(nums[i]).add(i);
        }


        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list.size() > 0) {
                for (int j = 0; j < list.size(); j++) {
                    if (i != list.get(j)) {
                        ans[i] += Math.abs(i - list.get(j));
                    }
                }
            } else {
                ans[i] = 0;
            }

        }
        return ans;

    }

    public static int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                res++;
                set = new HashSet<>();
                set.add(c);
            }
        }
        return set.isEmpty() ? res : res + 1;
    }


    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];

        int idx = 0;
        for (int i : nums) {
            arr[idx++] = String.valueOf(i);
        }
        printArrString(arr);

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        printArrString(arr);


        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        if (sb.toString().isEmpty() || sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();

    }

    public static void printArrString(String[] arr) {
        for (String s : arr) {
            System.out.print(s + "->");
        }
        System.out.println();
    }


}

