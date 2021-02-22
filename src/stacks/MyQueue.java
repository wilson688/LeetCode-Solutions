package stacks;

import java.util.Stack;

class MyQueue {

    private static Stack<Integer> myStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        myStack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        myStack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!myStack.isEmpty()) {
           //first reverse and then do it
            Stack<Integer> tempStack = new Stack<Integer>();
            tempStack.addAll(invertStack(myStack));

            if(myStack.isEmpty() && !tempStack.isEmpty()) {
                int poppedElement = tempStack.pop();
                myStack.addAll(invertStack(tempStack));
                //reverse it back before you return for the next pop
                return poppedElement;
            }
        }

        return -1;
    }

    public Stack<Integer> invertStack(Stack<Integer> inStack) {
        Stack<Integer> innerStack = new Stack<Integer>();
        while(!inStack.isEmpty()) {
            int currInt = inStack.pop();
            innerStack.add(currInt);
        }

        return innerStack;
    }

    /** Get the front element. */
    public int peek() {
        int currPeek = 0;
        if(!myStack.isEmpty()) {
            Stack<Integer> tempStack = new Stack<Integer>();
            tempStack.addAll(invertStack(myStack));
            if(!tempStack.isEmpty()) {
                currPeek = tempStack.peek();
            }
            myStack.addAll(invertStack(tempStack));
        }

        return currPeek != 0? currPeek : -1;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(myStack.isEmpty()) return true;
        return false;
    }


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
//        ["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
//[[],[1],[2],[3],[4],[],[5],[],[],[],[]]

//
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(4);
//        System.out.println(queue.pop());
//        queue.push(5);
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());



        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */