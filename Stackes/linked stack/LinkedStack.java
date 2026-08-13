
public class LinkedStack {

    static class SLnode {
        public int data;
        public SLnode next;

        public SLnode(int n) {
            data = n;
            next = null;
        }
    }
    SLnode top;
    public LinkedStack() {
        top = null;
    }
    public void push(int x) {
        SLnode pr = new SLnode(x);
        pr.next = top;
        top = pr;
    }

    public int pop() {
        if (isEmpty())
            return -1;

        int val = top.data;
        top = top.next;
        return val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void print() {
        SLnode temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        LinkedStack s1 = new LinkedStack();

        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);

        System.out.println("Original Stack:");
        s1.print();

        LinkedStack reversed = new LinkedStack();

        while (!s1.isEmpty()) {
            reversed.push(s1.pop());
        }

        System.out.println("Reversed Stack:");
        reversed.print();
    }
}