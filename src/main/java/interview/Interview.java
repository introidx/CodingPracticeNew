package interview;

import java.util.*;


public class Interview {
    public static void main(String[] args) {


    }

    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : changed){
            map.put(i, 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : changed){
            if(map.containsKey(i)){
                if(map.containsKey(i * 2)){
                    list.add(i);
                    map.remove(i);
                    map.remove(i * 2);
                }
            }
        }
        for (int i : map.keySet()){
            list.add(i);
        }

        Collections.sort(list);
        int[] res = new int[list.size()];
        int i=0;
        for (int x : list){
            res[i++] = x;
        }
        return res;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> { // Ascending ordering on the first column and if the values are same then sort descending order on the second column
            if(a[0]==b[0])
                return (a[1]>b[1])? -1: 1; // Returning -1, saying the sort function not to swap - Ordering the bigger values first ie., descending
            // Another way to write : return (b[1]>a[1]) ? 1:-1;  swap the entries so b entry is ordered first
            return (a[0] < b[0])? -1: 1;  // Returning -1, saying the sort function not to swap - Ordering the smaller values first ie., ascending
        });

        return 1;
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Long> list = new ArrayList<>();
        Map<Integer, Num> map = new HashMap();
        map.put(2, new Num(10, 99));
        map.put(3, new Num(100, 999));
        map.put(4, new Num(1000, 9999));
        map.put(5, new Num(10000, 99999));
        map.put(6, new Num(100000, 999999));
        map.put(7, new Num(1000000, 9999999));
        map.put(8, new Num(10000000, 99999999));
        map.put(9, new Num(100000000, 999999999));

        int lowerBound = map.get(n).low;
        int upperBound = map.get(n).high;

        for (long i = lowerBound; i <= upperBound; i++){
            String s = "" + i;
            boolean isValid = true;
            for (int j = 1; j < s.length(); j++){
                int diff = Math.abs(s.charAt(j) - s.charAt(j-1));
                if (diff != k){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        int p=0;
        for (Long i : list){
            res[p++] = Math.toIntExact(i);
        }

        return res;
    }

    class Num{
        int low;
        int high;


        public Num(int low, int high){
            this.low = low;
            this.high = high;
        }

    }

}

















