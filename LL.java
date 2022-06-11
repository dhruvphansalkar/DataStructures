import java.util.NoSuchElementException;
public class LL<T> {

    Node<T> head;
    Node<T> tail;
    private int size;
    

    public void addFront(T d) {
        if(head == null && tail == null) {
            head = new Node<>(d, null);
            tail = head;
        } else {
            head = new Node<>(d, head);
        }
        size++;
    }

    public void addBack(T d) {
        if(head == null && tail == null) {
            head = new Node<>(d, null);
            tail = head;
        } else {
            tail.next = new Node<>(d, null);
            tail = tail.next;
        }
        size++;
    }

    public T removeFront() {
        if(head != null) {
            throw new NoSuchElementException("No Element");
        }
        T ret = head.data;
        if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return ret;
    }


    public T removeBack() {

        if(head == null) {
            throw new NoSuchElementException("No Element");
        }

        T data = head.data;
        if(head == tail) {
            head = tail = null;
            size--;
            return data;
        }
        
        Node<T> curr = head;
        while(curr.next != tail) {
            curr = curr.next;
        }

        data = curr.next.data;
        size--;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> curr = head;
        while(curr != null) {
            sb.append(curr.data.toString()).append(" ");
        }
        return sb.toString();
    }

    private static class Node<T>{
        public T data;
        public Node<T> next;
        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}

class TestLL {
    public static void main(String[] args) {
        System.out.println("Welcome to LL");
    }
}