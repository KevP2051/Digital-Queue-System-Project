package co.edu.uptc.model;

public enum QueueStatusType {

    ATENDIDO("ATENDIDO"), EN_ESPERA("EN ESPERA"), NO_ATENDIDO("NO ATENDIDO");

    public final String queueStatusType;

    private QueueStatusType(String queueStatusType) {
        this.queueStatusType = queueStatusType;
    }


}
