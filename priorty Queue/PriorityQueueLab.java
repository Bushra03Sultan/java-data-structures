public class PriorityQueueLab {

    static class Node {
        int key;
        String value;
        Node next;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    static class UnsortedPriorityQueue {
        private Node head;

        public void insert(int k, String v) {
            Node newNode = new Node(k, v);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public Node min() {
            if (head == null) return null;
            Node minNode = head;
            Node temp = head.next;
            while (temp != null) {
                if (temp.key < minNode.key) {
                    minNode = temp;
                }
                temp = temp.next;
            }
            return minNode;
        }

        public Node removeMin() {
            if (head == null) return null;
            
            Node minNode = head;
            Node minPrev = null;
            
            Node temp = head;
            Node prev = null;
            
            while (temp != null) {
                if (temp.key < minNode.key) {
                    minNode = temp;
                    minPrev = prev;
                }
                prev = temp;
                temp = temp.next;
            }
            
            if (minPrev == null) {
                head = head.next; 
            } else {
                minPrev.next = minNode.next; 
            }
            return minNode;
        }
    }

    static class SortedPriorityQueue {
        private Node head;

        public void insert(int k, String v) {
            Node newNode = new Node(k, v);
            if (head == null || k < head.key) {
                newNode.next = head;
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null && temp.next.key <= k) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }

        public Node min() {
            return head; 
        }

        public Node removeMin() {
            if (head == null) return null;
            Node minNode = head;
            head = head.next;
            return minNode;
        }
    }

    static class MinHeapPriorityQueue {
        private Node head;
        private Node tail;
        private int size; 

        public MinHeapPriorityQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        
        private Node getNode(int index) {
            if (index < 0 || index >= size) return null;
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        private void swapData(Node a, Node b) {
            int tempKey = a.key;
            String tempVal = a.value;
            
            a.key = b.key;
            a.value = b.value;
            
            b.key = tempKey;
            b.value = tempVal;
        }

        private void removeLastNode() {
            if (size == 1) {
                head = tail = null;
            } else {
                Node current = head;
                while (current.next != tail) {
                    current = current.next;
                }
                current.next = null;
                tail = current;
            }
            size--;
        }

        public void insert(int k, String v) {
            Node newNode = new Node(k, v);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
            upHeap(size - 1); 
        }
private void upHeap(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                Node currentNode = getNode(i);
                Node parentNode = getNode(parent);
                
                if (currentNode.key < parentNode.key) {
                    swapData(currentNode, parentNode);
                    i = parent; 
                } else {
                    break; 
                }
            }
        }

        public Node min() {
            return head;
        }

        public Node removeMin() {
            if (head == null) return null;
            
            Node minNode = new Node(head.key, head.value);
            
            if (size == 1) {
                head = tail = null;
                size--;
                return minNode;
            }
            
            head.key = tail.key;
            head.value = tail.value;
            
            removeLastNode();
            
            downHeap(0); 
            
            return minNode;
        }

        private void downHeap(int i) {
            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int smallest = i;

                Node currentNode = getNode(smallest);
                Node leftNode = getNode(left);
                Node rightNode = getNode(right);

                if (left < size && leftNode.key < currentNode.key) {
                    smallest = left;
                    currentNode = leftNode; 
                }
                if (right < size && rightNode.key < currentNode.key) {
                    smallest = right;
                }
                
                if (smallest != i) {
                    swapData(getNode(i), getNode(smallest));
                    i = smallest; 
                } else {
                    break; 
                }
            }
        }

        public void printHeap() {
            System.out.print("Heap: [");
            Node current = head;
            while (current != null) {
                System.out.print(current.key + (current.next != null ? ", " : ""));
                current = current.next;
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- Testing Activity 3 & 4 (Min-Heap) ---");
        MinHeapPriorityQueue minHeap = new MinHeapPriorityQueue();
        
        System.out.println("Inserting 5:");
        minHeap.insert(5, "A");
        minHeap.printHeap(); 

        System.out.println("\nInserting 3:");
        minHeap.insert(3, "B");
        minHeap.printHeap(); 

        System.out.println("\nInserting 8:");
        minHeap.insert(8, "C");
        minHeap.printHeap(); 

        System.out.println("\nInserting 1:");
        minHeap.insert(1, "D");
        minHeap.printHeap(); 

        System.out.println("\nInserting 6:");
        minHeap.insert(6, "E");
        minHeap.printHeap(); 
        
        System.out.println("\nRemoving Minimum");
        Node removed = minHeap.removeMin();
        System.out.println("Removed Min: " + removed.key);
        minHeap.printHeap(); 

        // Testing Activity 1
        System.out.println("\n--- Testing Activity 1 (Unsorted List) ---");
        UnsortedPriorityQueue unsortedPQ = new UnsortedPriorityQueue();
        unsortedPQ.insert(5, "A");
        unsortedPQ.insert(1, "B");
        unsortedPQ.insert(3, "C");
        System.out.println("Removed Min: " + unsortedPQ.removeMin().key); 

        // Testing Activity 2
        System.out.println("\n--- Testing Activity 2 (Sorted List) ---");
        SortedPriorityQueue sortedPQ = new SortedPriorityQueue();
        sortedPQ.insert(5, "A");
        sortedPQ.insert(1, "B");
        sortedPQ.insert(3, "C");
        System.out.println("Removed Min: " + sortedPQ.removeMin().key); 
    }
}