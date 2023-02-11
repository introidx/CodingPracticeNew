package design;

import java.util.EmptyStackException;

/**
 * Created by PRAKASH RANJAN on 10-02-2023
 */
public class StackArray {
    private int top;
    private int[] stack;
    private int size;

    public StackArray(int size) {
        this.top = -1;
        this.stack = new int[size];
        this.size = size;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size -1;
    }

    public void push(int item){
        if(isFull()){
            System.out.println("Stack Overflow");
        }else {
            stack[++top] = item;
        }
    }

    public int pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }else {
            return stack[top--];
        }
    }

    public int peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }else {
            return stack[top];
        }
    }


}
