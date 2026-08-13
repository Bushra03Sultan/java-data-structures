public class DoublyLinkedListLab {

    // 1. Define a Node class
    static class Node {
        String data;
        Node prev;
        Node next;

        public Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // 2. Initialize the head and tail pointers
    Node head = null;
    Node tail = null;

    // Task 1: Algorithm to Traverse the List Forward
    public void traverseForward() {
        Node current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Task 1: Algorithm to Traverse the List Backward
    public void traverseBackward() {
        Node current = tail;
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Task 2: Insert a Node (Algorithm to Insert Between Two Nodes)
    public void insertAfter(Node p, String data) {
        if (p == null) return;

        Node q = new Node(data);
        q.next = p.next;
        q.prev = p;
        p.next = q;

        if (q.next != null) {
            q.next.prev = q;
        } else {
            tail = q; 
        }
    }

    // Task 3: Delete a Node
    public void deleteNode(Node p) {
        if (p == null) return;

        if (p.prev != null) {
            p.prev.next = p.next;
        } else {
            head = p.next;
        }

        if (p.next != null) {
            p.next.prev = p.prev;
        } else {
            tail = p.prev;
        }

        p.next = null;
        p.prev = null;
    }

    // Task 4: Reverse a Doubly Linked List
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev; 
            current.prev = current.next;
            current.next = temp;
            current = current.prev; 
        }

        if (temp != null) {
            tail = head; 
            head = temp.prev; 
        }
    }

    // الدالة الرئيسية
    public static void main(String[] args) {
        DoublyLinkedListLab list = new DoublyLinkedListLab();

        System.out.println("--- Task 1: Create and Traverse ---");
        // الطريقة اليدوية: إنشاء الكائنات (Nodes) بشكل مستقل
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        // ربط المؤشرات يدوياً لتكوين القائمة A <-> B <-> C
        list.head = nodeA;       // الرأس يؤشر على A
        
        nodeA.next = nodeB;      // A يؤشر للأمام على B
        nodeB.prev = nodeA;      // B يؤشر للخلف على A
        
        nodeB.next = nodeC;      // B يؤشر للأمام على C
        nodeC.prev = nodeB;      // C يؤشر للخلف على B
        
        list.tail = nodeC;       // الذيل يؤشر على C (آخر عنصر)

        // طباعة النتيجة
        list.traverseForward();  // Result: A B C
        list.traverseBackward(); // Result: C B A

        System.out.println("\n--- Task 2: Insert a Node ---");
        // Example: Insert X between B and C
        // نمرر الكائن nodeB مباشرة للدالة لأننا نمتلكه بالفعل
        list.insertAfter(nodeB, "X");
        list.traverseForward(); // Result: A B X C

        System.out.println("\n--- Task 3: Delete a Node ---");
        // Example: Remove B 
        // (القائمة حالياً A <-> B <-> X <-> C، إذا حذفنا B ستصبح A <-> X <-> C)
        list.deleteNode(nodeB);
        list.traverseForward(); // Result: A X C

        System.out.println("\n--- Task 4: Reverse a Doubly Linked List ---");
        System.out.print("Original: ");
        list.traverseForward(); // النتيجة الحالية A X C
        
        list.reverse();
        
        System.out.print("Reversed: ");
        list.traverseForward(); // Result: C X A
    }
}
