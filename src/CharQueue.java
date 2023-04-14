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
        this.circularArray[this.front] = elem;
        this.rear++;
    }

    public char peek() {
        return this.circularArray[circularArray.length - 1];
    }

    public char dequeue() {
        // TODO
        return 0;
    }
}
