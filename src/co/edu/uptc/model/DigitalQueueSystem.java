package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.LinkedList;

import co.edu.uptc.exceptions.EmptyQueueException;

public class DigitalQueueSystem {
    
    private LinkedList<User> usersInQueue;
    private ArrayList<User> servedUsers;
    private ArrayList<User> unServedUsers;
    private int tokenIndex;
    

    public DigitalQueueSystem() {
        usersInQueue = new LinkedList<User>();
        servedUsers = new ArrayList<User>();
        unServedUsers = new ArrayList<User>();
        this.tokenIndex = 0;
    }

    public int assignWaitingToken(User user){ //Este método asigna turnos a los usuarios 
        tokenIndex++;
        user.setWaitingToken(tokenIndex);
        usersInQueue.offer(user);
        return tokenIndex;
    }

    public User recoverFirstUserInQueue() throws EmptyQueueException{ //La idea es mostrar siempre qué usuario sigue en la lista de espera, para que todos lo vean al ir a sacar turno.
        if(usersInQueue.isEmpty()){
            throw new EmptyQueueException();
        }
        return usersInQueue.peek(); // Este método devuelve al usuario actual en la cola, osea el próximo a pasar.
    }

    public User changeToNextUserInQueue(QueueStatusType queueStatusType) throws EmptyQueueException{
       if(usersInQueue.isEmpty()){
           throw new EmptyQueueException();
       }
        usersInQueue.peek().setQueueStatusType(queueStatusType); //Esta parte establece el estado del usuario como el que el administrador digite, si fue atendido entonces pasará a atendido y así.
        if(queueStatusType.equals(QueueStatusType.ATENDIDO)){ //Esta parte del código se usa para añadir a los usuarios a la lista de usuarios atendidos ese día o usuarios no atendidos, dependiendo de lo que haya pulsado el administrador.
            servedUsers.add(usersInQueue.poll());
        }else{
            unServedUsers.add(usersInQueue.poll());
        }
        return recoverFirstUserInQueue(); //Devuelve el nuevo primer usuario en la lista de espera para mostrarlo.
    }

    public ArrayList<User> getServedUsers() { //Devuelve la lista de usuarios admitidos ese día.
        return servedUsers;
    }

    public ArrayList<User> getUnServedUsers() { //Devuelve la lista de usuarios NO admitidos ese día.
        return unServedUsers;
    }

    public void restartTokenIndex(){ //Reinicia el índice de turnos.
        tokenIndex = 0;
    }
}
