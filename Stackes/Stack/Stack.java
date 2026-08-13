
public class Stack {
    int top;
    int size;
    int arr[];
    public Stack(int s) {
        size = s;
        arr = new int[size];
        top = -1;
    }
    public void push(int x) {
        arr[++top] = x;
    }
    public int pop() {
        return arr[top--];
    }
    public boolean isEmpty() {
        return top == -1;
    } 
    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack s1 = new Stack(5);
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        System.out.println("Original Stack:");
        s1.print();
        Stack reversed = new Stack(5);
        while (!s1.isEmpty()) {
            reversed.push(s1.pop());
        }
        System.out.println("Reversed Stack:");
        reversed.print();
    }
}