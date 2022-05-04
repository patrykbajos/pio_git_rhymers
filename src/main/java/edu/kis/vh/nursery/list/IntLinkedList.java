package edu.kis.vh.nursery.list;

/**
 * Klasa implementuje wzorzec LIFO na typie danych int
 */
public class IntLinkedList {
    private static class Node {
        private int value;
        private Node prev;
        private Node next;

        public Node(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private static final int EMPTY_SIZE = -1;
    private Node last;
    private int i;

    /**
     * Funkcja umieszcza element przekazany w i na czubek stosu
     * @param i Element do umieszczenia na stosie
     */
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.setNext(new Node(i));
            last.getNext().setPrev(last);
            last = last.getNext();
        }
    }

    /**
     * Funkcja zwraca czy stos jest pusty
     * @return Wartosc true/false mowiaca czy stos jest pusty
     */
    public boolean isEmpty() {
        return last == null;
    }

    /**
     * Funkcja zwracajaca prawde dla pelnego stosu
     * @return Wartosc boolean mowiaca o zapelnieniu stosu
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Funkcja zwraca wartosc elementu na czubku stosu bez zdejmowania go
     * @return Wartosc elementu na czubku stosu
     */
    public int top() {
        if (isEmpty())
            return EMPTY_SIZE;
        return last.getValue();
    }

    /**
     * Funkcja zdejmuje i zwraca element z czubka stosu
     * @return Wartosc elementu na czubku stosu
     */
    public int pop() {
        if (isEmpty())
            return EMPTY_SIZE;
        int ret = last.getValue();
        last = last.getPrev();
        return ret;
    }
}
