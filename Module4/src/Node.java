
public class Node<T> {
    private T data;
    private Node<T> next;
    
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
    
    public T getData() {
        return data;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
}
