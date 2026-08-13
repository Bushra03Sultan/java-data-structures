public class SimpleLinkList {
    public static void main(String[] args) {
        Node node1 = new Node("a");
        Node node2 = new Node ("b");
        Node node3 = new Node ("c");
         node1.next = node2;
         node2.next = node3;
         
         Node head = node1;

         head = new Node("d");

         head.next=node1;
         head=head.next;

        
         Node current = head;
        
         while (current != null){
            System.out.print(current.data +"->");
            current = current.next;
         }
         System.out.println("null");

    }
    
}
