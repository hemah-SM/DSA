package DSA.LinkedList;

public class SinglyLinkedList<E> {

    private Node<E> head;

    //add
    public void add(E item){
        Node newNode = new Node<>(item);
        if(head == null){
            head = newNode;
            return;
        }
        Node<E> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;

    }

    //add to the first
    public void addFirst(E item){
        Node newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
    }

    //add last
    public void addLast(E item){
        Node<E> newNode = new Node<>(item);
        if(head == null) {
            head = newNode;
            return;
        }
        Node<E> curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    //add at index
    public void addAtIndex(E item, int index){
        Node<E> newNode = new Node<>(item);
        Node<E> curr = head;
        for(int i = 0 ; i < index-1; i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    //remove
    public void remove(E item){
        if(head.item.equals(item)){
            head = head.next;
            return;
        }
        Node<E> curr = head;
        while (curr.next != null && !curr.next.item.equals(item)){
            curr = curr.next;
        }
        if(curr.next!=null){
            curr.next = curr.next.next;
        }
    }

    //reverse
    public void reverse(){
        if (head == null || head.next == null)return;
        Node<E> curr = head;
        Node<E> prev = null;
        while (curr != null){
            Node<E> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //print
    public void print(){
        Node<E> curr = head;
        while (curr != null){
            System.out.print(curr.item+" ->");
            curr = curr.next;
        }
        System.out.println("null");
    }


    private static class Node<E>{
        E item;
        Node<E> next;
        public Node(E item){
            this.item = item;
            this.next = null;
        }
    }
}
