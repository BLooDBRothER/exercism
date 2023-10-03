import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {
    Node<T> head;
    int size;

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            next = null;
        }
    }

    SimpleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    SimpleLinkedList(T[] values) {
        for (T value : values) {
            push(value);
        }
    }

    void push(T value) {
        Node<T> newNode = new Node<>(value);

        if(head != null){
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    T pop() {
        if(size == 0)
            throw new NoSuchElementException("List is empty");

        Node<T> tempNode = head;
        head = head.next;
        size--;
        return tempNode.data;
    }

    void reverse() {
        Node<T> currNode=head, prevNode = null;

        while(currNode != null){
            Node<T> nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }

    public T[] asArray(Class<T> clazz) {
        ArrayList<T> listArray = new ArrayList<>();
        Node<T> tempNode = head;

        while(tempNode != null){
            listArray.add(tempNode.data);
            tempNode = tempNode.next;
        }

        return listArray.toArray((T[]) Array.newInstance(clazz, 0));
    }

    int size() {
        return size;
    }
}
