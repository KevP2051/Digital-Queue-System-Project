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

    public User changeToNextUserInQueue(QueueStatusType queueStatusType) throws EmptyQueueException{
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

    public String getServedUsers() {
        StringBuilder builder = new StringBuilder();
        for(UserInQueue userInQueue : servedUsers){
            builder.append(userInQueue.toString() + "\n");
        }
        return builder.toString();
    }

    public void restartTokenIndex(){
        tokenIndex = 0;
    }
}
