package co.edu.uptc.exceptions;

public class EmptyQueueException extends Exception {

    public EmptyQueueException() {
        super("The queue is empty");
    }
}
