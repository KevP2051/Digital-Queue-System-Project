package co.edu.uptc.model;

public class User {
    private DocumentType documentType;
    private String documentNumber;
    private int waitingToken;
    private QueueStatusType queueStatusType;

    public User(DocumentType documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.queueStatusType = QueueStatusType.EN_ESPERA;
    }

    public void setWaitingToken(int waitingToken){
        this.waitingToken = waitingToken;
    }

    public void setQueueStatusType(QueueStatusType queueStatusType){
        this.queueStatusType = queueStatusType;
    }

    @Override
    public String toString() {
        return "DocumentType: " + documentType + ", DocumentNumber: " + documentNumber + ", waitingToken: "
                + waitingToken + ", queueStatusType: " + queueStatusType;
    }

    
}
