package design;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int SIZE;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.SIZE = capacity;
    }

    public int get(int kay) {
        if (map.containsKey(kay)) {
            int value = map.remove(kay);
            map.put(kay, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() + 1 > SIZE) {
            map.remove(map.keySet().iterator().next());
        }

        map.put(key, value);

    }

}
