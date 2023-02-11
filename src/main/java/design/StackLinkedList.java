package design;

import java.util.EmptyStackException;

/**
 * Created by PRAKASH RANJAN on 10-02-2023
 */
public class StackLinkedList {
    private Node top;

    private class Node{
        int data;
        Node next;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int item){
        Node old = top;
        top = new Node();
        top.data = item;
        top.next = old;
    }

    public int pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }else {
            int item = top.data;
            top = top.next;
            return item;
        }
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }else {
            return top.data;
        }
    }
}
