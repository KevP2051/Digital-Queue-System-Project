package co.edu.uptc.model;

import java.util.LinkedList;

import co.edu.uptc.exceptions.EmptyQueueException;

public class DigitalQueueSystem {

    private LinkedList<UserInQueue> usersInQueue;
    private AdminUser adminUser;
    private int tokenIndex;

    public DigitalQueueSystem() {
        usersInQueue = new LinkedList<UserInQueue>();
        this.tokenIndex = 0;
    }

    public int assignWaitingToken(UserInQueue userInQueue) {
        tokenIndex++;
        userInQueue.setWaitingToken(tokenIndex);
        usersInQueue.offer(userInQueue);
        return tokenIndex;
    }

    public UserInQueue recoverFirstUserInQueue() throws EmptyQueueException {
        if (usersInQueue.isEmpty()) {
            throw new EmptyQueueException();
        }
        return usersInQueue.peek();
    }

    public UserInQueue changeToNextUserInQueue() throws EmptyQueueException {
        if (usersInQueue.isEmpty()) {
            throw new EmptyQueueException();
        }
        return usersInQueue.poll();
    }

    public boolean validateAdminUserLogIn(AdminUser enteredAdminUser) {
        boolean isInformationCorrect = false;
        if (adminUser.getDocumentNumber().equals(enteredAdminUser.getDocumentNumber())
                && adminUser.getPassword().equals(enteredAdminUser.getPassword())) {
            isInformationCorrect = true;
        }
        return isInformationCorrect;
    }

    public void restartTokenIndex() {
        tokenIndex = 0;
    }

    public void setAdminUser(AdminUser adminUser){
        this.adminUser = adminUser;
    }

    public LinkedList<UserInQueue> getUsersInQueue() {
        return usersInQueue;
    }
}
