import java.util.ArrayList;
import java.util.List;
//
//implementation of Queue Datastructure
// Stack uses first IN first Out
// so I would need something to store the top and remove the last added
// ArrayList??
// List.add() -> List.get(n) -> list.remove(n);


public class Queue<T> {
    ArrayList<T> list = new ArrayList<>();
    int size = 0;

    //create stack
    public List<T> Stack() {
        return new ArrayList<>();
    }

    //add an element
    public void add(T element) {
        list.add(element);
    }

    //remove an element
    public void pop() {
        size = list.size();
        list.remove(0);
    }

    //peek
    public T peek() {
        size = list.size();
        return list.get(size-1);
    }

    public void printAll() {
        size = list.size();
        for(int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {

        Queue<Integer> st = new Queue();
        System.out.println("=====================");
        st.add(10);
        st.printAll();
        System.out.println("=====================");
        st.add(20);
        st.printAll();
        System.out.println("=====================");
        st.add(30);
        st.printAll();
        System.out.println("=====================");

        System.out.println(st.peek());
        System.out.println("=====================");
        st.pop();
        st.printAll();
        System.out.println("=====================");
        System.out.println(st.peek());
        System.out.println("=====================");
        st.pop();
        st.printAll();
        System.out.println("=====================");


    }
}
