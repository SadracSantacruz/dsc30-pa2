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


    /**
     * Calls the CharQueue(int capacity) class by using the this() keyword.
     */
    public CharQueue() {
        this(5);
    }


    /**
     * Constructor that initiates that the previously allocated variables to the needed
     * variables.
     * @param capacity an integer containing how big is the Queue going to be.
     */
    public CharQueue(int capacity) {
        if(capacity < 1) throw new IllegalArgumentException();

        this.length = 0;
        this.front = 0;
        this.rear = 0;
        this.capacity = capacity;

        circularArray = new char[capacity];

    }

    /**
     * Checks if the Queue is empty or not.
     * @return True or False
     */
    public boolean isEmpty() {
        /* Checking if the Queue is Empty */
        return this.length == 0;
    }

    /**
     * @return size of the Queue
     */
    public int size() {
        return this.length;
    }

    /**
     * This function resets the circular array to be empty. And resets all the other variables
     * to be 0.
     */
    public void clear() {

        /* Resetting all the variables to be 0, and re-initiating the circular to be empty */
        this.front = 0;
        this.rear = 0;
        this.length = 0;
        this.circularArray = new char[this.capacity];

    }

    /**
     * If the Queue is not full then enqueue an element at the rear index and increase
     * rear, if the queue is full, expand queue to enqueue new element. Else, enqueue the item.
     * @param elem
     * @return
     */
    public void enqueue(char elem) {
        if (this.length == this.capacity) {
            int newCapacity = this.capacity + 1;
            char[] temp = new char[newCapacity];

            int i = 0;
            while (!isEmpty()) {
                temp[i] = dequeue();
                i++;
            }
            temp[i] = elem;

            this.circularArray = temp;
            this.front = 0;
            this.rear = temp.length - 1;
            this.capacity = temp.length;
            this.length = temp.length;
        }
        else {
            this.circularArray[rear] = elem;
            this.rear = (this.rear + 1) % this.capacity;
            this.length++;
        }
    }

    /**
     * Checks for what is the peek of the queue
     * @return an integer representing the peek of the queue
     */
    public char peek() {
        if (this.isEmpty()) throw new NoSuchElementException();
        return this.circularArray[this.front];
    }


    /**
     * Removes the element at the rear of the queue
     * @return the element that was removed
     */
    public char dequeue() {
        if (this.isEmpty()) throw new NoSuchElementException();

        char currentElem = circularArray[this.front];
        // circularArray[front] = "removed";
        this.front = (this.front + 1) % capacity;
        length--;
        return currentElem;
    }
}
