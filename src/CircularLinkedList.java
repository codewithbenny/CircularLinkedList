import java.util.NoSuchElementException;

// CircularLinked list
public class CircularLinkedList {
    private ListNode last;
    private int length;


    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularLinkedList(){
        last=null;
        length=0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return last==null;
    }

    public void createCircularLinkedList(){
        ListNode first= new ListNode(1);
        ListNode second= new ListNode(5);
        ListNode third= new ListNode(10);
        ListNode fourth= new ListNode(15);

        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;
        last=fourth;
    }
     // Add at Start
    public void insertFirst(int data){
        ListNode temp= new ListNode(data);
        if(isEmpty()){
            last=temp;
        }else{
            temp.next=last.next;
        }
        last.next=temp;
        length++;
    }
    // Insert At last
    public void insertLast(int data){
        ListNode temp=new ListNode(data);
        if(isEmpty()){
            last=temp;
            last.next=last;
        }else{
            temp.next=last.next;
            last.next=temp;
            last=temp;

        }
        length++;
    }

    // Remove First Node
    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("List is already Empty");
        }
        ListNode temp = last.next;
        if(last.next==last){
            last=null;
        }else {
            last.next=temp.next;
        }
        temp.next=null;
        length--;
        return temp;
    }
    // Traversal
    public void display(){
        if(isEmpty()){
            return;
        }
        ListNode first=last.next;
        while (first!=last){
            System.out.print(first.data+"-->");
            first=first.next;
        }
        System.out.println(first.data);
    }

    public static void main(String[] args) {
        CircularLinkedList cll=new CircularLinkedList();
        cll.createCircularLinkedList();
        cll.display();
//        cll.insertFirst(30);
//        cll.display();
//        cll.insertLast(99);
        cll.deleteFirst();
        cll.display();

        cll.deleteFirst();
        cll.display();

        cll.deleteFirst();
        cll.display();

        cll.deleteFirst();
        cll.display();

        cll.deleteFirst();
        cll.display();
    }
}
