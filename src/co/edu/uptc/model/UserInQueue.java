package co.edu.uptc.model;

public class UserInQueue extends User{
    private int waitingToken;


    public UserInQueue(IdentificationType idType, String documentNumber) {
        super(idType, documentNumber);
    }
    
    
    public void setWaitingToken(int waitingToken){
        this.waitingToken = waitingToken;
    }

    public int getWaitingToken() {
        return waitingToken;
    }

    @Override
    public String toString() {
        return getIdentificationType() + ": " + getDocumentNumber() + ", Turno: "
                + waitingToken;
    }
}
