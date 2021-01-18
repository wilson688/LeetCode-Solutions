import java.util.*;
//
//implementation of Stack Datastructure
// Stack uses first IN first Out
// so I would need something to store the top and remove the last added
// ArrayList??
// List.add() -> List.get(n) -> list.remove(n);





public class Stack<T> implements Iterable<T> {
    ArrayList<T> list = new ArrayList<>();
    int size = 0;
    //empty stack
    public Stack() { }

    public Stack(T element) {
        list.add(element);
    }

    //add an element
    public void push(T element) {
        list.add(element);
    }

    //remove an element
    public void pop() {
        if(list.size() > 0) {
            list.remove(size - 1);
        } else {
            throw new NullPointerException();
        }

    }

    //peek
    public T peek() {
        size = list.size();
        return list.get(size-1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack();
        System.out.println("=====================");
        st.push(10);
        st.iterator();
        System.out.println("=====================");
        st.push(20);
        System.out.println("=====================");
        st.push(30);

        System.out.println("=====================");

        System.out.println(st.peek());
        System.out.println("=====================");
        st.pop();

        System.out.println("=====================");
        System.out.println(st.peek());


    }
}
