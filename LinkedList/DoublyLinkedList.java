package DSA.LinkedList;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    //add
    public void add(E item){
        Node<E> newNode = new Node<>(item);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //addFirst
    public void addFirst(E item){
        Node<E> newNode = new Node<>(item);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //addLast
    public void addLast(E item){
        Node<E> newNode = new Node<>(item);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

    }

    //addAtIndex
    public void addAtIndex(E item, int index) {
        Node<E> newNode = new Node<>(item);
        Node<E> curr = getNodeAtIndex(index);
        newNode.next = curr;
        newNode.prev = curr.prev;
        curr.prev.next = newNode;
        curr.prev = newNode;
    }

    //getNodeAtIndex
    public Node<E> getNodeAtIndex(int index){
        Node<E> curr = head;
        for(int i = 0 ; i < index; i++){
            curr = curr.next;
        }
        return curr;
    }

    //remove
    public void remove(E item){
        if(head.item.equals(item)){
            if(head == tail){
                head = tail = null;
                return;
            }
            head.next.prev = null;
            head = head.next;
            return;
        }
        if(tail.item.equals(item)){
            tail.prev.next = null;
            tail = tail.prev;
            return;
        }
        Node<E> curr = head;
        while(curr != null && !curr.item.equals(item)){
            curr = curr.next;
        }
        if (curr != null){
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
    }

    //reverse
    public void reverse() {
        if (head == null || head.next == null) return;

        Node<E> curr = head;
        while (curr != null) {
            Node<E> next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            curr = curr.prev;
        }

        // Swap head and tail
        Node<E> temp = head;
        head = tail;
        tail = temp;
    }

    //printForward
    public void printForward(){
        Node<E> curr = head;
        while(curr != null){
            System.out.print(curr.item+" ->");
            curr = curr.next;
        }
    }

    //printBackward
    public void printBackward(){
        Node<E> curr = tail;
        while(curr != null){
            System.out.print(curr.item+" ->");
            curr = curr.prev;
        }
    }



    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item){
            this.item = item;
        }

    }
}
