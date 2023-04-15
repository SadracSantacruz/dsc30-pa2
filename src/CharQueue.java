/*
    Name: Tianqi Zhang, Sadrac Santacruz Ibarra
    PID:  A17284671, A17420185
 */

import java.util.NoSuchElementException;

/**
 * Implements a circular queue using an array.
 *
 * @author Tianqi Zhang & Sadrac Santacruz Ibarra
 * @since 4/12/2023
 */

public class CharQueue {
    private char[] circularArray;
    private int length;
    private int front;
    private int rear;
    private int capacity;

    public CharQueue() {
        this(5);
    }


    public CharQueue(int capacity) {
        /* Constructor that initiates that the previously allocated variables to the needed
        * variables. */

        if(capacity < 1) throw new IllegalArgumentException();

        this.length = 0;
        this.front = 0;
        this.rear = 0;
        /* Created a new variable called capacity to keep track of how big the array
        * was supposed to be. This variable will be used in the function(s) clear. */
        this.capacity = capacity;

        circularArray = new char[capacity];

    }

    public boolean isEmpty() {
        /* Checking if the Queue is Empty */
        return this.length == 0;
    }

    public int size() {
        /* Returning the size of the Queue */
        return this.length;
    }

    public void clear() {

        /* Resetting all the variables to be 0, and re-initiating the circular to be empty */
        this.front = 0;
        this.rear = 0;
        this.length = 0;
        this.circularArray = new char[this.capacity];

    }

    public void enqueue(char elem) {
        /* If the Queue is not full then enqueue an element at the rear index and increase
        * rear. */

        // if the queue is full, expand queue to enqueue new element
        if ((this.rear + 1) % this.capacity == this.front) {
            int newCapacity = this.capacity + 1;
            char[] temp = new char[newCapacity];

            int i = 0;
            while (!isEmpty()) {
                temp[i] = dequeue();
                i++;
            }

            this.circularArray = temp;
            this.front = 0;
            this.rear = this.length;
            this.capacity = newCapacity;
        }

        // enqueue item
        this.circularArray[rear] = elem;
        this.rear = (this.rear + 1) % this.capacity;
        this.length++;
    }

    public char peek() {
        if (this.isEmpty()) throw new NoSuchElementException();
        return this.circularArray[circularArray.length - 1];
    }

    public char dequeue() {
        if (this.isEmpty()) throw new NoSuchElementException();

        char currentElem = circularArray[this.front];
        // circularArray[front] = "removed";
        this.front = (this.front + 1) % capacity;
        length--;
        return currentElem;
    }
}
