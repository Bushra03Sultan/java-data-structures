public class Main {

    // =========================================================
    // Custom Stack Class 
    // =========================================================
    public static class Stack {
        private int[] arr;
        private int top;
        private int capacity;

        public Stack(int size) {
            this.capacity = size;
            this.arr = new int[size];
            this.top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public void push(int val) {
            if (!isFull()) {
                arr[++top] = val;
            }
        }

        public int pop() {
            if (!isEmpty()) {
                return arr[top--];
            }
            return -1;
        }
    }

    // =========================================================
    // Activity 1: Linear Queue + Print in Reverse
    // =========================================================
    public static class LinearQueue {
        public int arr[];
        public int front, rear;
        public int size;

        public LinearQueue(int s) {
            size = s;
            front = rear = -1;
            arr = new int[size];
        }

        public boolean isempty() {
            return (rear == -1);
        }

        public boolean isfull() {
            return ((rear + 1) == size);
        }

        public void enqueue(int e) {
            if (isfull()) {
                System.out.println("Queue is overflow");
            } else if (isempty()) {
                front = rear = 0;
                arr[rear] = e;
            } else {
                arr[++rear] = e;
            }
        }

        public int dequeue() {
            if (isempty()) {
                System.out.println("Queue is underflow");
                return -1;
            } else if (front == rear) {
                int el = arr[front];
                front = rear = -1;
                return el;
            } else {
                return arr[front++];
            }
        }

        public void print() {
            if (isempty()) {
                System.out.println("Queue is Empty");
                return;
            }
            int f = front;
            while (f <= rear) {
                System.out.print(arr[f] + " ");
                f++;
            }
            System.out.println();
        }

        // --- Activity 1 Solution: Print Queue Contents in Reverse using Stack ---
        public void printReverse() {
            if (isempty()) {
                System.out.println("Queue is Empty");
                return;
            }

            
            Stack stack = new Stack(size);
            int f = front;

            
            while (f <= rear) {
                stack.push(arr[f]);
                f++;
            }

            
            System.out.print("Reverse Order: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }

    // =========================================================
    // Activity 2: Circular Queue Implementation
    // =========================================================
    public static class CircularQueue {
        public int arr[];
        public int front, rear;
        public int size;

        public CircularQueue(int s) {
            size = s;
            front = rear = -1;
            arr = new int[size];
        }

        
        public boolean isempty() {
            return (front == -1);
        }

        
        public boolean isfull() {
            return ((rear + 1) % size == front);
        }
        public void enqueue(int e) {
            if (isfull()) {
                System.out.println("Circular Queue is Overflow");
            } else if (isempty()) {
                front = rear = 0;
                arr[rear] = e;
            } else {
                rear = (rear + 1) % size; 
                arr[rear] = e;
            }
        }

        public int dequeue() {
            if (isempty()) {
                System.out.println("Circular Queue is Underflow");
                return -1;
            }

            int el = arr[front];

            if (front == rear) {
                
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return el;
        }

        public void print() {
            if (isempty()) {
                System.out.println("Circular Queue is Empty");
                return;
            }

            int i = front;
            while (true) {
                System.out.print(arr[i] + " ");
                if (i == rear) break;
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }

    // =========================================================
    // Main Method Execution
    // =========================================================
    public static void main(String[] args) {

        // -----------------------------------------------------
        // Activity 1 Test
        // -----------------------------------------------------
        System.out.println("==========================================");
        System.out.println("=== ACTIVITY 1: PRINT QUEUE IN REVERSE ===");
        System.out.println("==========================================");

        LinearQueue Q1 = new LinearQueue(5);
        Q1.enqueue(10);
        Q1.enqueue(20);
        Q1.enqueue(30);

        System.out.print("Original Queue Contents: ");
        Q1.print();

        Q1.printReverse();

        // -----------------------------------------------------
        // Activity 2 Test
        // -----------------------------------------------------
        System.out.println("\n==========================================");
        System.out.println("=== ACTIVITY 2: CIRCULAR QUEUE DEMO    ===");
        System.out.println("==========================================");

        CircularQueue CQ = new CircularQueue(5);

        System.out.println("1. Enqueuing 10, 20, 30, 40, 50:");
        CQ.enqueue(10);
        CQ.enqueue(20);
        CQ.enqueue(30);
        CQ.enqueue(40);
        CQ.enqueue(50);
        System.out.print("   Queue: ");
        CQ.print();

        System.out.println("\n2. Dequeuing 2 elements:");
        System.out.println("   Dequeued: " + CQ.dequeue());
        System.out.println("   Dequeued: " + CQ.dequeue());
        System.out.print("   Queue: ");
        CQ.print();

        System.out.println("\n3. Enqueuing 60 and 70 (Circular Wrap-around):");
        CQ.enqueue(60);
        CQ.enqueue(70);
        System.out.print("   Queue: ");
        CQ.print();
    }
}