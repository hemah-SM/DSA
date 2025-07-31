package DSA.LinkedList;

public class CircularLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    //add
    public void add(E item){
        Node<E> newNode = new Node<>(item);
        if(head == null){
            head = tail = newNode;
            tail.next = head;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    //addLast
    public void  addLast(E item){
        Node<E> newNode = new Node<>(item);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    //addAtIndex for circular linked list
    public void addAtIndex(E item, int index){
        Node<E> newNode = new Node<>(item);
        Node<E> curr = head;
        for (int i = 0 ; i < index-1 ; i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    //remove
    public void remove(E item){
        Node<E> curr = head;
        Node<E> prev;
        if(head == null)return;

        if (head == tail && head.item.equals(item)) {
            head = tail = null;
            return;
        }

        if(head.item.equals(item)){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            prev = curr;
            curr = curr.next;
            if(curr.item.equals(item)){
                prev.next = curr.next;
                if(curr == tail){
                    tail = prev;
                }
                return;
            }
        }while (curr != head);

    }

    //reverse
    public void reverse(){
        Node<E> curr = head;
        Node<E> prev = null;
        do{
            Node<E> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }while (curr != head);
        head.next = prev;
        head = prev;
    }

    //find loop
    public boolean findLoop(){
        Node<E> slow = head;
        Node<E> fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)return true;
        }
        return false;
    }

    //find loop start
    public Node findLoopStart(){
        Node<E> slow = head;
        Node<E> fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)break;
        }
        if(fast != null && fast.next != null)return null;
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //print
    public void print(){
        Node<E> curr = head;
        do{
            System.out.print(curr.item+" ->");
            curr = curr.next;
        }while (curr != head);
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
