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

    public CharQueue() {
        this(5);
    }

    public CharQueue(int capacity) {
        this.length = 0;
        this.front = 0;
        this.rear = 0;

        if(capacity < 1) throw new IllegalArgumentException();
        circularArray = new char[capacity];
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public int size() {
        // TODO
        return 0;
    }

    public void clear() {
        // TODO
    }

    public void enqueue(char elem) {
        // TODO
    }

    public char peek() {
        // TODO
        return 0;
    }

    public char dequeue() {
        // TODO
        return 0;
    }
}
