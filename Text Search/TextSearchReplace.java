import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextSearchReplace {

    // =========================================================
    // TASK 1: Node Design and BST Structure
    // =========================================================

    // Node class for Binary Search Tree
    static class BSTNode {
        String word;
        BSTNode left, right;

        public BSTNode(String word) {
            this.word = word;
            this.left = null;
            this.right = null;
        }
    }

    // Node class for Custom Linked List (To keep the original text order)
    static class ListNode {
        String word;
        ListNode next;

        public ListNode(String word) {
            this.word = word;
            this.next = null;
        }
    }

    // Custom Linked List to hold the text sequence 
    static class CustomTextList {
        ListNode head, tail;

        public void addWord(String word) {
            ListNode newNode = new ListNode(word);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Helper: Update the word in the text sequence
        public void replaceAll(String oldWord, String newWord) {
            ListNode current = head;
            while (current != null) {
                if (current.word.equals(oldWord)) {
                    current.word = newWord;
                }
                current = current.next;
            }
        }

        // TASK 5: Display the updated text correctly
        public void display() {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.word + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Binary Search Tree Implementation
    static class BinarySearchTree {
        BSTNode root;

        // TASK 2: Store words using a BST (Handles duplicates by ignoring them)
        public void insert(String word) {
            root = insertRec(root, word);
        }

        private BSTNode insertRec(BSTNode root, String word) {
            if (root == null) {
                return new BSTNode(word);
            }
            int cmp = word.compareTo(root.word);
            if (cmp < 0) {
                root.left = insertRec(root.left, word);
            } else if (cmp > 0) {
                root.right = insertRec(root.right, word);
            }
            return root; // Ignored if cmp == 0 (duplicate)
        }

        // TASK 3: Search for a word efficiently
        public boolean search(String word) {
            return searchRec(root, word);
        }

        private boolean searchRec(BSTNode root, String word) {
            if (root == null) return false;
            int cmp = word.compareTo(root.word);
            if (cmp == 0) return true;
            if (cmp < 0) return searchRec(root.left, word);
            return searchRec(root.right, word);
        }

        // Helper function for Replace: Delete a node from BST
        public void delete(String word) {
            root = deleteRec(root, word);
        }

        private BSTNode deleteRec(BSTNode root, String word) {
            if (root == null) return null;
            int cmp = word.compareTo(root.word);
            if (cmp < 0) {
                root.left = deleteRec(root.left, word);
            } else if (cmp > 0) {
                root.right = deleteRec(root.right, word);
                } else {
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;
                
                root.word = minValue(root.right);
                root.right = deleteRec(root.right, root.word);
            }
            return root;
        }

        private String minValue(BSTNode root) {
            String minV = root.word;
            while (root.left != null) {
                minV = root.left.word;
                root = root.left;
            }
            return minV;
        }
    }

    // =========================================================
    // MAIN PROGRAM EXECUTION
    // =========================================================
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        CustomTextList textList = new CustomTextList();

        // TASK 1: Read input from a text file
        try {
            File file = new File("input.txt"); 
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                textList.addWord(word); // Preserve order
                bst.insert(word); // Add to BST
            }
            fileScanner.close();
            System.out.println("System: Text loaded successfully from input.txt\n");
        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt file not found. Please create it in the project directory.");
            return;
        }

        Scanner inputScanner = new Scanner(System.in);
        boolean keepRunning = true;

        // Interactive Menu for testing all edge cases
        while (keepRunning) {
            System.out.println("=====================================");
            System.out.println("1. Search for a word only");
            System.out.println("2. Replace a word");
            System.out.println("3. Display current text");
            System.out.println("4. Exit");
            System.out.println("=====================================");
            System.out.print("Choose an option (1-4): ");
            
            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter word to search: ");
                    String wordToSearch = inputScanner.next();
                    if (bst.search(wordToSearch)) {
                        System.out.println("Result: The word '" + wordToSearch + "' EXISTS in the text.");
                    } else {
                        System.out.println("Result: The word '" + wordToSearch + "' DOES NOT EXIST.");
                    }
                    break;
                case 2:
                    System.out.print("\nSearch : ");
                    String searchWord = inputScanner.next();
                    System.out.print("Replace with : ");
                    String replaceWord = inputScanner.next();
                    
                    System.out.println("\nExpected Output");
                    
                    // TASK 4: Replace all occurrences of a word
                    if (bst.search(searchWord)) {
                        textList.replaceAll(searchWord, replaceWord);
                        bst.delete(searchWord);
                        
                        // Edge Case: Insert the new word ONLY if it doesn't already exist
                        if (!bst.search(replaceWord)) {
                            bst.insert(replaceWord);
                        }
                        
                        textList.display();
                        System.out.println("Status: Complete");
                    } else {
                        textList.display();
                        System.out.println("Status: Word not found");
                    }
                    break;
                case 3:
                    System.out.println("\nCurrent Text:");
                    textList.display();
                    break;
                case 4:
                    keepRunning = false;
                    System.out.println("\nExiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println(); 
        }
        inputScanner.close();
    }
}