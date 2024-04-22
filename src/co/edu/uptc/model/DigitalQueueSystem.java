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

    public int assignWaitingToken(UserInQueue userInQueue){ //Este método asigna turnos a los usuarios //METODO PARA USUARIOS NORMALES
        tokenIndex++;
        userInQueue.setWaitingToken(tokenIndex);
        usersInQueue.offer(userInQueue);
        return tokenIndex;
    }

    public UserInQueue recoverFirstUserInQueue() throws EmptyQueueException{ //La idea es mostrar siempre qué usuario sigue en la lista de espera, para que todos lo vean al ir a sacar turno. (ESTO EN EL MENÚ)
        if(usersInQueue.isEmpty()){
            throw new EmptyQueueException();
        }
        return usersInQueue.peek(); // Este método devuelve al usuario actual en la cola, osea el próximo a pasar.
    }

    public User changeToNextUserInQueue(QueueStatusType queueStatusType) throws EmptyQueueException{ //Método para usuarios ADMIN
       if(usersInQueue.isEmpty()){
           throw new EmptyQueueException();
       }
        usersInQueue.peek().setQueueStatusType(queueStatusType); //Esta parte establece el estado del usuario como el que el administrador digite, si fue atendido entonces pasará a atendido y así.
        if(queueStatusType.equals(QueueStatusType.ATENDIDO)){ //Esta parte del código se usa para añadir a los usuarios a la lista de usuarios atendidos ese día o usuarios no atendidos, dependiendo de lo que haya pulsado el administrador.
            servedUsers.add(usersInQueue.poll());
        }
        return recoverFirstUserInQueue(); //Devuelve el nuevo primer usuario en la lista de espera para mostrarlo.
    }

    public boolean validateAdminUserLogIn(AdminUser enteredAdminUser){ //METODO PARA VALIDAR QUE EL USUARIO INGRESADO SI SEA ADMIN
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
