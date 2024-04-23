package co.edu.uptc.presenter;

import co.edu.uptc.exceptions.EmptyQueueException;
import co.edu.uptc.model.*;
import co.edu.uptc.view.View;

public class Presenter {
    private View view;
    private DigitalQueueSystem digitalQueueSystem;


    public Presenter() {
        view = new View();
        digitalQueueSystem = new DigitalQueueSystem();
    }
    public void run() {
        digitalQueueSystem.setAdminUser(new AdminUser(IdentificationType.CEDULA, "123", "admin123"));
        showMainMenu();
    }

    public void showMainMenu() {

        int option = 0;
        do {
            String menu = "Bienvenido al sistema de asignación de turnos. \nIngresa el número correspondiente al tipo de usuario del que haces parte:" +
                    "\n1. Usuario administrativo. \n2. Usuario normal. ";
            option = Integer.parseInt(view.readData(menu + "\nDigita la opción a continuación: "));
            switch (option) {
                case 1:
                    validateAdminUser();
                    break;

                case 2:
                    showUserMenu();
                    break;

                default:
                    view.showMessage("Opción inválida");
                    break;
            }

        } while (option != 4);
    }

    public void validateAdminUser() {
         if(digitalQueueSystem.validateAdminUserLogIn(new AdminUser(validateID(),
                 view.readData("Ingrese el numero de documento: "), view.readData("Ingrese su contraseña: ")))){
         showAdminMenu();
         }else {
             view.showMessage("USUARIO O CONTRASEÑA INCORRECTAS");
         }
    }

    public IdentificationType validateID(){
        IdentificationType identificationType = IdentificationType.CEDULA;
        int option = 0;
        do {
            String menu = "Ingrese en numero que corresponda a su tipo de documento \n1. CC\n2. TI";
            option = Integer.parseInt(view.readData(menu + "\nDigita la opción a continuación: "));
            switch (option) {
                case 1:
                    identificationType = IdentificationType.CEDULA;
                    break;
                case 2:
                    identificationType = IdentificationType.TARJETA_DE_IDENTIDAD;
                    break;
                default:
                    view.showMessage("Opción inválida");
                    break;
            }
            break;
        } while (option != 2);
        return identificationType;
    }

    public void showUserMenu() {
        int option = 0;
        String menu = "Bienvenido al sistema de asignación de turnos.  \nEl turno actual es: ";
        do {
            String menuAux = "";
            try {
                menuAux = menu + digitalQueueSystem.recoverFirstUserInQueue().getWaitingToken();
            } catch (EmptyQueueException e) {
                menuAux = menu + "NINGUNO";
            }
            option = Integer.parseInt(view.readData(menuAux + "\n1. Solicitar turno\nDigita la opción a continuación: "));
            switch (option) {
                case 1:
                    assignWaitingToken();
                    break;

                default:
                    view.showMessage("Opción inválida");
                    break;
            }
            break;
        } while (option != 4);
    }

    public void assignWaitingToken(){
        view.showMessage("Se le asigno el turno número: " + digitalQueueSystem.assignWaitingToken(new UserInQueue(
                validateID(), view.readData("Ingrese su numero de documento: ")
        )));
    }

    public void showAdminMenu() {
        int option = 0;
        String menu = "Bienvenido al sistema de asignación de turnos.  \nEl turno actual es: ";
        do {
            String menuAux = "";
            try {
                menuAux = menu + digitalQueueSystem.recoverFirstUserInQueue().getWaitingToken();
            } catch (EmptyQueueException e) {
                menuAux = menu + "NINGUNO";
            }
            option = Integer.parseInt(view.readData(menuAux + "\n1. Pasar al siguiente turno\n2. Reiniciar el numero de turnos\n3. Volver al menu principal \nDigita la opción a continuación: "));
            switch (option) {
                case 1:
                    changeToNextUserInQueue();
                    break;
                case 2:
                digitalQueueSystem.restartTokenIndex();
                    break;
                case 3:
                showMainMenu();
                    break;
                default:
                    view.showMessage("Opción inválida");
                    break;
            }
        } while (option != 4);
    }

    public void changeToNextUserInQueue(){
        try {
            User user = digitalQueueSystem.changeToNextUserInQueue();
            view.showMessage("El usuario atendido fue: "+ user);
        } catch (EmptyQueueException e) {
            view.showMessage(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Presenter().run();
    }

}