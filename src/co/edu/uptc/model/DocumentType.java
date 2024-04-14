package co.edu.uptc.model;

public enum DocumentType {
    CEDULA("CC"),TARJETA_DE_IDENTIDAD("TI");    
    public final String documentType;

    private DocumentType(String documentType) {
        this.documentType = documentType;
    }
}
