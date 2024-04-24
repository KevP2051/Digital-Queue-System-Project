package co.edu.uptc.model;

public class User {
    private IdentificationType documentType;
    private String documentNumber;

    public User(IdentificationType documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    public IdentificationType getIdentificationType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

}
