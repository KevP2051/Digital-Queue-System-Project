package co.edu.uptc.model;

public class User {
    private DocumentType documentType;
    private String documentNumber;
    private String waitingToken;

    public User(DocumentType documentType, String documentNumber, String waitingToken) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.waitingToken = waitingToken;
    }
}
