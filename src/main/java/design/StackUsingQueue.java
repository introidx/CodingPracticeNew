package design;

import java.util.*;


class StackWithTwoQueues<T> {
    Queue<T> q1;
    Queue<T> q2;

    public StackWithTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(T item) {
        q2.add(item);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public T pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return q1.remove();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }

    public static void main(String[] args) {
        StackWithTwoQueues<Integer> stack = new StackWithTwoQueues<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class StackWithSingleQueue<T> {
    Queue<T> queue;

    public StackWithSingleQueue() {
        queue = new LinkedList<>();
    }

    public void push(T item) {
        int size = queue.size();
        queue.add(item);
        for (int i = 0; i < size; i++) {
            T x = queue.remove();
            queue.add(x);
        }
    }

    public T pop() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        StackWithSingleQueue<Integer> stack = new StackWithSingleQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

