package co.edu.uptc.exceptions;

public class EmptyQueueException extends Exception {

    public EmptyQueueException() {
        super("La cola está vacía.");
    }
}
