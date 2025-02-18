import ds.linkedlist.LinkedList;

public class Main {

    public static void main(String args[]){
        System.out.println("hi this is my entry level class for ds");

        LinkedList list = new LinkedList(1);
        list.append(3);
        list.append(5);
        list.append(7);
        //list.printList();
        //Node node = list.removeLast().value;
        //System.out.println(list.removeLast());

        list.prepend(8);

        list.removeFirst();
        list.printList();
    }
}
