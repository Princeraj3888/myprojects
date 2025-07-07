package ds.linkedlist;

public class MyLinkedList {

    Node<Integer> head;
    int size;

    MyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insertAtTail(78);
        myLinkedList.printList();
        System.out.println("================");
        myLinkedList.insertAtIndex(1, 20);
        myLinkedList.printList();
        System.out.println("================");
        myLinkedList.insertAtHead(25);
        myLinkedList.insertAtIndex(1, 30);
        myLinkedList.printList();
        System.out.println("===============");
        myLinkedList.deleteAtTail();
        myLinkedList.printList();
        myLinkedList.deleteHead();
        myLinkedList.printList();
        myLinkedList.deletionAtPosition(1);
        myLinkedList.printList();
    }

    public void insertAtIndex(int position, Integer data){
        if(position > size +1 || position <= 0){
            System.out.println("wrong position provided");
            return;
        }
        if(position==1){
            insertAtHead(data);
        }else if(position == size + 1){
            insertAtTail(data);
        }else{
            int counter = 0;
            Node<Integer> newNode = new Node<Integer>();
            Node<Integer> temp = head;
            while(counter < position-1 && temp!=null){
                counter++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
        System.out.println("data inserted at provided position: "+ position);
    }

    public void insertAtHead(Integer data){
        Node<Integer> newNode = new Node<Integer>(data);
        if(head == null){
            newNode = head;
            size++;
            System.out.println("Insertion at head is successful");
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Insertion at head is successful");
    }

    public void insertAtTail(Integer data){
        Node<Integer> newNode = new Node<Integer>(data);
        if(head == null){
            head = newNode;
            System.out.println("insert at tail is successful");
            return;
        }

        Node<Integer> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Insert at tail is successful");
    }

    public void printList(){
        Node<Integer> temp = head;
        while(temp!=null){
            System.out.println("data is: "+temp.data);
            temp = temp.next;
        }
    }

    public void deleteHead(){
        if(head == null){
            System.out.println("linked list is empty");
            return;
        }
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("deletion at head is successful");
        size--;
    }

    public void deleteAtTail(){
        if(head == null){
            System.out.println("linked list is empty");
            return;
        }
        if(head.next == null){
            head = null;
            size--;
            System.out.println("deletion at tail is successful");
            return;
        }

        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while(temp.next !=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        size--;
        System.out.println("deletion at tail is successful");
    }

    public void deletionAtPosition(int position){
        if(position > size || position <= 0){
            System.out.println("wrong position provided");
            return;
        }
        if(position == 1){
            deleteHead();
        }else if(position == size){
            deleteAtTail();
        }else{
            int counter = 1;
            Node<Integer> prevElement = null;
            Node<Integer> temp = head;
            while(counter < position && temp!=null){
                counter ++;
                prevElement = temp;
                temp = temp.next;
            }
            prevElement.next = temp.next;
            temp.next = null;
            size--;
            System.out.println("deletion was successful at position: "+position);
        }
    }
}

class Node<T>{
    T data;
    Node next;

    Node(){
        this.next = null;
    }

    Node(T data){
        this.next = null;
        this.data = data;
    }
}
