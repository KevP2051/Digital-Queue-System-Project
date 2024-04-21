package co.edu.uptc.presenter;

import co.edu.uptc.exceptions.EmptyQueueException;
import co.edu.uptc.model.DigitalQueueSystem;
import co.edu.uptc.view.View;

public class Presenter {
    private View view;
    private DigitalQueueSystem digitalQueueSystem;


    public Presenter() {
        view = new View();
        digitalQueueSystem = new DigitalQueueSystem();
    }
    public void run() {
        showMainMenu();
    }

    public void showMainMenu() {

        int option = 0;
        do {
            String menu = "Bienvenido al sistema de asignación de turnos. \nIngresa el número correspondiente al tipo de usuario del que haces parte:\n1.Usuario normal. \n2.Usuario administrativo. ";
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
        // Código de solicitar datos
        // if(digitalQueueSystem.validateAdminUserLogIn(//Usuario admin acá){
        // showAdminMenu();
        // }
    }

    public void showUserMenu() { // Menú para métodos de usuarios.
        int option = 0;

        String menu = "Bienvenido al sistema de asignación de turnos.  \nEl turno actual es: ";
        do {
            try {
                menu += digitalQueueSystem.recoverFirstUserInQueue();
            } catch (EmptyQueueException e) {
                menu += "NINGUNO";
            }

            option = Integer.parseInt(view.readData(menu + "\nDigita la opción a continuación: "));
            switch (option) {
                case 1:
                    validateAdminUser();
                    break;

                case 2:
                    showUserMenu(); // Esto podría causar problemas de recursión infinita si no se controla
                                    // adecuadamente.
                    break;

                default:
                    view.showMessage("Opción inválida");
                    break;
            }
        } while (option != 4);
    }

    public void showAdminMenu() {

        int option = 0;
        String menu = "Bienvenido al sistema de asignación de turnos.  \nEl turno actual es: ";
        do {
            try {
                menu = menu + digitalQueueSystem.recoverFirstUserInQueue();
            } catch (EmptyQueueException e) {
                menu = menu + "NINGUNO";
            }

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

    public static void main(String[] args) {
        new Presenter().run();
    }

}