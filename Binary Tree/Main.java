public class Main {

    // ==========================================
    // 1. Node Class
    // ==========================================
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ==========================================
    // Custom Queue Implementation for BFS (Without imports)
    // ==========================================
    public static class CustomQueue {
        private Node[] arr;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public CustomQueue(int capacity) {
            this.capacity = capacity;
            this.arr = new Node[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public void add(Node node) {
            if (size < capacity) {
                rear = (rear + 1) % capacity;
                arr[rear] = node;
                size++;
            }
        }

        public Node poll() {
            if (isEmpty()) return null;
            Node item = arr[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    // ==========================================
    // 2. Binary Tree Operations Class
    // ==========================================
    public static class BinaryTree {

        // --- Find Height of a Node ---
        public static int findHeight(Node root) {
            if (root == null) {
                return -1;
            }
            int lHeight = findHeight(root.left);
            int rHeight = findHeight(root.right);

            return Math.max(lHeight, rHeight) + 1;
        }

        // Helper method to find a node by value and get its height
        public static int findHeightOfNode(Node root, int x) {
            Node targetNode = findNode(root, x);
            return findHeight(targetNode);
        }

        private static Node findNode(Node root, int x) {
            if (root == null) return null;
            if (root.data == x) return root;

            Node leftSearch = findNode(root.left, x);
            if (leftSearch != null) return leftSearch;

            return findNode(root.right, x);
        }

        // --- Find Depth of a Node x ---
        public static int findDepth(Node root, int x) {
            if (root == null) {
                return -1;
            }

            if (root.data == x) {
                return 0;
            }

            int dist = -1;
            if ((dist = findDepth(root.left, x)) >= 0 || (dist = findDepth(root.right, x)) >= 0) {
                return dist + 1;
            }

            return dist;
        }

        // --- DFS Traversals ---

        // Inorder Traversal: Left -> Root -> Right
        public static void inorderTraversal(Node node) {
            if (node == null) return;
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }

        // Preorder Traversal: Root -> Left -> Right
        public static void preorderTraversal(Node node) {
            if (node == null) return;
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }

        // Postorder Traversal: Left -> Right -> Root
        public static void postorderTraversal(Node node) {
            if (node == null) return;
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }

        // --- BFS Traversal ---

        // Level Order Traversal
        public static void levelOrderTraversal(Node root) {
            if (root == null) return;

            CustomQueue q = new CustomQueue(100);
            q.add(root);
            while (!q.isEmpty()) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // ==========================================
    // Main Method Execution
    // ==========================================
    public static void main(String[] args) {

        /*
         * Constructing the Binary Tree from the Lab Example:
         * 
         *           5
         *         /   \
         *       10     15
         *      /  \   /  \
         *     20  25 30  35
         *           \
         *           45
         */

        Node root = new Node(5);
        
        // Level 1
        root.left = new Node(10);
        root.right = new Node(15);

        // Level 2
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        // Level 3
        root.left.right.right = new Node(45);

        // --- Output Section (Matching Example) ---
        System.out.println("Depth of node 10 = " + BinaryTree.findDepth(root, 10));
        System.out.println("Height of node 10 = " + BinaryTree.findHeightOfNode(root, 10));
        System.out.println("Height of Tree = " + BinaryTree.findHeight(root));

        System.out.print("INORDER : ");
        BinaryTree.inorderTraversal(root);
        System.out.println();

        System.out.print("PREORDER : ");
        BinaryTree.preorderTraversal(root);
        System.out.println();

        System.out.print("POSTORDER : ");
        BinaryTree.postorderTraversal(root);
        System.out.println();

        System.out.print("LEVEL ORDER : ");
        BinaryTree.levelOrderTraversal(root);
        System.out.println();
    }
}
