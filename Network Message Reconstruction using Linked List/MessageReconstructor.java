

class SegmentNode {
    int messageId;
    int sequenceId; // number of the segment in the message
    String data;
    SegmentNode next;

    public SegmentNode(int messageId, int sequenceId, String data) {
        this.messageId = messageId;
        this.sequenceId = sequenceId;
        this.data = data;
        this.next = null;
    }
}

public class MessageReconstructor {
    private SegmentNode head;

    // enter the segment in the correct position based on sequenceId
    public void addSegment(int messageId, int sequenceId, String data) {
        // check for duplicate segment
        SegmentNode tempCheck = head;
        while(tempCheck != null) {
            if(tempCheck.sequenceId == sequenceId) {
                System.out.println("Duplicate segment " + sequenceId + " ignored.");
                return;
            }
            tempCheck = tempCheck.next;
        }

        SegmentNode newNode = new SegmentNode(messageId, sequenceId, data);

        // add the new segment at the beginning if it's the first segment or has the smallest sequenceId    
        if(head == null || sequenceId < head.sequenceId) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // add the new segment in the correct position
        SegmentNode current = head;
        while(current.next != null && current.next.sequenceId < sequenceId) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    // display the message with status
    public void displayMessage() {
        if(head == null) {
            System.out.println("No messages received.");
            return;
        }

        SegmentNode current = head;
        int expectedId = 1;
        boolean isComplete = true;
        StringBuilder message = new StringBuilder();
        String missingSegments = "";

        while(current != null) {
            // finding missing segments
            while(expectedId < current.sequenceId) {
                isComplete = false;
                missingSegments += expectedId + " ";
                expectedId++;
            }

            // string with space for separation
            message.append(current.data).append(" ");

            expectedId = current.sequenceId + 1;
            current = current.next;
        }

        // fainal massage output
        System.out.println(message.toString().trim());
        if(isComplete) {
            System.out.println("Status : Complete");
        } else {
            System.out.println("Status : Incomplete ( Missing segment " + missingSegments.trim() + " )");
        }
    }

    public static void main(String[] args) {
        // Test Cases
        MessageReconstructor network1 = new MessageReconstructor();
        System.out.println("--- Test Case 1 (Complete/unorderd Message) ---");
        network1.addSegment(1, 3, "world");
        network1.addSegment(1, 1, "Hello");
        network1.addSegment(1, 2, "beautiful");
        network1.displayMessage();

        System.out.println("\n--- Test Case 2 (Missing Segment) ---");
        MessageReconstructor network2 = new MessageReconstructor();
        network2.addSegment(2, 1, "Hello");
        network2.addSegment(2, 3, "world");
        network2.displayMessage();

        System.out.println("\n--- Test Case 3 (Duplicate Segment) ---");
        MessageReconstructor network3 = new MessageReconstructor();
        network3.addSegment(3, 1, "Hello");
        network3.addSegment(3, 2, "beautiful");
        network3.addSegment(3, 2, "beautiful"); 
        network3.addSegment(3, 3, "world");
        network3.displayMessage();
    }
}