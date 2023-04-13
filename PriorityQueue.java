/**
 * Use linked list to implement priority queue.
 * 
 * The priority queue defined here is used to implement
 * BFS and DFS.
 * 
 * references:
 * Priority queue and heap
 * http://www.cs.cmu.edu/afs/cs/academic/class/15122-n14/www/recitations/rec10/rec10.pdfs
 * 
 * Priority Queue using Linked List
 * https://www.geeksforgeeks.org/priority-queue-using-linked-list/
 * 
 * Queue Linked List Implementation
 * https://www.geeksforgeeks.org/queue-linked-list-implementation/
 */
public class PriorityQueue {
    public Node front, rear;

    /**
     * Constructor
     * 
     * Initialize an emtpy priority queue with front and rear
     * point to null.
     */
    public PriorityQueue(){
        this.front = this.rear = null;
    }

    /**
     * Checks if the priority queue is empty.
     * If the front pointer points null, then the priority queue is empty.
     * 
     * @return The boolean value of whether the priority queue is empty.
     */
    public boolean isEmpty(){
        return this.front == null;
    }

    /**
     * Insert a node with the specified key to the priority queue
     * @param key the key of the node to be enqueued 
     */
    public void push(int key){
        Node temp = new Node(key);

        // if the priorty queue is empty
        if(this.rear == null){
            this.rear = this.front = temp;  // make rear and front point to the new node
        }
        else {
            // if the priority queue is not empty
            this.rear.next = temp;         // add new node to the end of the priority queue
            this.rear = temp;              // set rear point to the new node
        }
    }

    /**
     * Remove the node at the front of the priority queue,
     * and then return the node that is removed
     * @return The node that is removed
     */
    public Node pop(){
        Node temp = this.front; // the node this.front points to will be removed

        // if the priority queue is empty, return null
        if (this.isEmpty()) return null;

        // delete the node, make front point to front.next
        this.front = this.front.next;

        // if the priority queue gets emptied after removing the node
        // set rear to null
        if (this.isEmpty()) this.rear = null;

        // return the removed node
        return temp;
     }

     /**
      * Return the key value the node in the front of the priority queue
      * If the priority queue is empty, return -1.
      * @return the key value of the node in the front of the priority queue
      */
     public int peek(){
        Node temp = this.front;

        if(this.isEmpty()) return -1;   // if the priority queue is empty, return -1
        else return temp.key;           // else, return the key value of the node
     }
}
