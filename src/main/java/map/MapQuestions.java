package map;

import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.util.*;

public class MapQuestions {
    public static void main(String[] args) {



        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
        int k = 3;

        kSmallestPairs(nums1, nums2, k);


    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<pair>pq = new PriorityQueue<>();
        for(int i=0; i<nums1.length; i++){
            pq.add(new pair(nums1[i],nums2[0],nums1[i]+nums2[0],0));
        }
        List<List<Integer>>ans = new ArrayList<>();
        while(k>0 && pq.size()>0){
            pair a = pq.remove();
            List<Integer>aa = new ArrayList<>();
            aa.add(a.d1);
            aa.add(a.d2);
            ans.add(aa);
            int index = a.idx;
            //if the element which is removed has more elements after itself(from nums2 array) than add //that element into the priority queue
            if(index < nums2.length-1){
                pq.add(new pair(a.d1,nums2[index+1],a.d1+nums2[index+1],index+1));
            }
            k--;
        }
        return ans;
    }

    //comparing according to the sum of elements and returning the min sum from priority queue
    public static class pair implements Comparable<pair>{
        int d1;
        int d2;
        int sum;
        int idx;
        pair(int d1,int d2,int s,int idx){
            this.d1 = d1;
            this.d2 = d2;
            this.sum = s;
            this.idx = idx;
        }
        public int compareTo(pair other){
            return this.sum-other.sum;
        }
    }

    public static List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i =0; i < nums1.length; i++){
            for (int j =0; j < nums2.length; j++){
                int sum = nums1[i] + nums2[j];
                map.put(sum, new ArrayList<>());
                map.get(sum).add(nums1[i]);
                map.get(sum).add(nums2[j]);
            }
        }

//        PriorityQueue<Map.Entry<Integer, List<Integer>>> pq = new PriorityQueue<>((a,b) -> a.getKey() - b.getKey());
//        pq.addAll(map.entrySet());

        List<Integer> sortedKeys
                = new ArrayList<Integer>(map.keySet());

        Collections.sort(sortedKeys);

        List<List<Integer>> res = new ArrayList<>();
        for (int i =0; i < k ; i++){
            List<Integer> list = map.get(sortedKeys.get(i));
            res.add(list);
        }
        return res;
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i =0; i < k ; i++){
//            Map.Entry e = pq.poll();
//            res.add((List<Integer>) e.getValue());
//        }
//
//        return res;

//        for (Map.Entry e : pq){
//            int key = (int)e.getKey();
//            List<Integer> val = (List<Integer>) e.getValue();
//            System.out.print(key + " --> value: ");
//            for (int i: val){
//                System.out.print(i + " ");
//            }
//            System.out.println();
//
//        }
//        return null;

    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        //[1,1,1,2,2,2,2,3], k = 2
        // 1 -> 3
        // 2 -> 4
        // 3 -> 1

        // 2, 1, 3
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        int[] ans = new int[k];
        int i =0;
        for (Map.Entry e : pq){
            int key = (int)e.getKey();
            int value = (int)e.getValue();
            if (i < k){
                ans[i++] = key;
            }else {
                break;
            }
            //System.out.println(key + " --" + value);
        }
        return ans;

    }

    public static int minDeletions(String s) {
        int count =0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i =0; i < s.length() ; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        //for s "ceabaacb"
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(entry.getValue());
        }
        // queue will look like
        // 3
        // 2
        // 2
        // 1

        while (pq.size() > 0){
            int current = pq.remove();
            if(pq.isEmpty()){
                return count;
            }

            int next = pq.peek();
            if(current == next){
                if (current > 1){
                    pq.add(current -1);
                }
                count++;
            }

        }
        return count;
    }
}
