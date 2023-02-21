package design;

import java.util.*;

public class QueueUsingStack<T> {

    Stack<T> enqStack;
    Stack<T> deqStack;

    public QueueUsingStack() {
        this.enqStack = new Stack<>();
        this.deqStack = new Stack<>();
    }

    public void enque(T item){
        enqStack.push(item);

    }

    public T deque(){
        if(deqStack.isEmpty()){
            while (!enqStack.isEmpty()){
                deqStack.push(enqStack.pop());
            }
        }
        return deqStack.pop();
    }

    public T top(){
        if(deqStack.isEmpty()){
            while (!enqStack.isEmpty()){
                deqStack.push(enqStack.pop());
            }
        }
        return deqStack.peek();
    }

    public boolean isEmpty(){
        return enqStack.isEmpty() && deqStack.isEmpty();
    }

    public int size(){
        return enqStack.size() + deqStack.size();
    }

    public static void main(String[] args) {
        QueueUsingStack<Integer> q = new QueueUsingStack<>();
        q.enque(1);
        q.enque(2);
        q.enque(3);

        System.out.println(q.deque());
        System.out.println(q.deque());
        q.enque(4);
        System.out.println(q.top());
    }
}
