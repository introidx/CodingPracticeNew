package design;

/**
 * Created by PRAKASH RANJAN on 10-02-2023
 */
import java.util.EmptyStackException;

public class MinStack {
    private Node top;

    private class Node {
        int data;
        int min;
        Node next;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int item) {
        Node oldTop = top;
        top = new Node();
        top.data = item;
        top.next = oldTop;
        if (isEmpty() || item <= oldTop.min) {
            top.min = item;
        } else {
            top.min = oldTop.min;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            int item = top.data;
            top = top.next;
            return item;
        }
    }

    public int getMin() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.min;
        }
    }
}

