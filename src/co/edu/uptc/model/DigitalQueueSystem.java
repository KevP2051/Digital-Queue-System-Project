package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.LinkedList;

import co.edu.uptc.exceptions.EmptyQueueException;

public class DigitalQueueSystem {
    
    private LinkedList<UserInQueue> usersInQueue;
    private ArrayList<UserInQueue> servedUsers;
    private AdminUser adminUser;
    private int tokenIndex;
    

    public DigitalQueueSystem() {
        usersInQueue = new LinkedList<UserInQueue>();
        servedUsers = new ArrayList<UserInQueue>();
        adminUser = new AdminUser(IdentificationType.CEDULA, "23412035", "admin123");
        this.tokenIndex = 0;
    }

    public int assignWaitingToken(UserInQueue userInQueue){
        tokenIndex++;
        userInQueue.setWaitingToken(tokenIndex);
        usersInQueue.offer(userInQueue);
        return tokenIndex;
    }

    public UserInQueue recoverFirstUserInQueue() throws EmptyQueueException{
        if(usersInQueue.isEmpty()){
            throw new EmptyQueueException();
        }
        return usersInQueue.peek();
    }

    public User changeToNextUserInQueue(QueueStatusType queueStatusType) throws EmptyQueueException{ //Método para usuarios ADMIN
       if(usersInQueue.isEmpty()){
           throw new EmptyQueueException();
       }
        usersInQueue.peek().setQueueStatusType(queueStatusType);
        if(queueStatusType.equals(QueueStatusType.ATENDIDO)){
            servedUsers.add(usersInQueue.poll());
        }
        return recoverFirstUserInQueue();
    }

    public boolean validateAdminUserLogIn(AdminUser enteredAdminUser){
       boolean isInformationCorrect = false;
        if(adminUser.getDocumentNumber().equals(enteredAdminUser.getDocumentNumber()) && adminUser.getPassword().equals(enteredAdminUser.getPassword())){
            isInformationCorrect = true;
        }
        return isInformationCorrect;
    }

    public ArrayList<UserInQueue> getServedUsers() { //Devuelve la lista de usuarios que sacaron turno ese día.
        return servedUsers;
    }

    public void restartTokenIndex(){ //Reinicia el índice de turnos.
        tokenIndex = 0;
    }
}
