package co.edu.uptc.model;

public enum IdentificationType {
    CEDULA("CC"),TARJETA_DE_IDENTIDAD("TI");
    public final String identificationType;

    private IdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }
}
