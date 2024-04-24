package co.edu.uptc.model;

public class AdminUser extends User {
    private String password;

    public AdminUser(IdentificationType documentType, String documentNumber, String password) {
        super(documentType, documentNumber);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
