import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack<T>{
    private List<T> list;
    private int size;
    T obj;

    MyStack() {
        list = new ArrayList<>();
        size = -1;
    }

    public int size() {
        return this.size + 1;
    }

    public void push(T element) {
        list.add(element);
        size++;
    }
    
    public T pop() {
        return getValue();
    }

    private T getValue() {
        if(size == -1)
            throw new EmptyStackException();
        return list.remove(size--);
    }

    public T peek() {
        return list.get(size);
    }

    public boolean isEmpty() {
        return this.size == -1;
    }
}

class TestStack {    
    public static void main(String[] args) {
        System.out.println("--------------brackets test---------------");
        System.out.println(bracketTest("{{}}([])"));
    }

    public static boolean bracketTest(String str) {

        MyStack<Character> s = new MyStack<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if( c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                if(s.isEmpty()) return false;
                
                char pop = s.pop();
                if(c == '}' && pop != '{') return false;
                if(c == ')' && pop != '(') return false;
                if(c == ']' && pop != '[') return false;
            }
        }

        for(char c = '1'; c <= 'z'; c++) {
            System.out.println(c);
        }
        System.out.println('a' + 'b');

        return s.isEmpty() == true;

        
    }
}