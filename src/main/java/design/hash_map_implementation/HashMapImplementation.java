package design.hash_map_implementation;

import java.util.Objects;

/**
 * Created by PRAKASH RANJAN on 23-07-2022
 */

class Node {
    int key;
    int value;
    int hash;
    Node next;

    public Node(int key, int value, int hash, Node next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key == node.key && value == node.value && hash == node.hash && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, hash, next);
    }
}

public class HashMapImplementation {
    static Node[] hashNode = new Node[10];
    static int mod = 10;
    static int[] list1 = {12, 13, 14, 22};
    static int[] list2 = {2, 3, 4, 5};

    public static void main(String[] args) {
        // [12 -> 2] [13-> 3] [14 -> 4]
        for (int i = 0; i < list1.length; i++) {
            putValue(i);
        }
        System.out.println(getValue(12));
    }

    public static void putValue(int i) {
        int hash = list1[i] % mod;
        Node newNode = new Node(list1[i], list2[i], hash, null);
        if (hashNode[hash] == null) {
            hashNode[hash] = newNode;
        } else {
            Node prev = hashNode[hash];
            hashNode[hash] = newNode;
            hashNode[hash].next = prev;
        }
    }

    public static int getValue(int key) {
        int hash = key % mod;
        if (hashNode[hash].next == null && key == hashNode[hash].key) {
            return hashNode[hash].value;
        } else {
            Node temp = hashNode[hash];
            while (temp != null) {
                if (temp.key == key) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return -1;
    }
}
