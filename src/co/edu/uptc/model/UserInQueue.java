package co.edu.uptc.model;

public class UserInQueue extends User{
    private int waitingToken;
    private QueueStatusType queueStatusType;


    public UserInQueue(IdentificationType idType, String documentNumber) {
        super(idType, documentNumber);
    }
    
    
    public void setWaitingToken(int waitingToken){
        this.waitingToken = waitingToken;
    }

    public void setQueueStatusType(QueueStatusType queueStatusType){
        this.queueStatusType = queueStatusType;
    }

    @Override
    public String toString() {
        return "DocumentType: " + getIdentificationType() + ", DocumentNumber: " + getDocumentNumber() + ", waitingToken: "
                + waitingToken;
    }
}
