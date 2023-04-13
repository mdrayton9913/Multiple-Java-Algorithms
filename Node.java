/**
 * A node class to implement linked lists
 */

public class Node {
    public Node next; // pointer to the next node in the linked list
    public int key;   // key of the node

    /**
     * Constructor
     * Create a node with the specified key, the next node is null
     */
    public Node(int key) {
        this.key = key;
        this.next = null;
    }
}
