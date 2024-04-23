package co.edu.uptc.model;

public enum IdentificationType {
    CEDULA("Cédula"),TARJETA_DE_IDENTIDAD("Tarjeta de Identidad");
    public final String identificationType;

    private IdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String toString(){
        return this.identificationType;
    }
}
