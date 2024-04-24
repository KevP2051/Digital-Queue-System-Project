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
        try {
            do {
                String menu = "Bienvenido al sistema de asignación de turnos. \nIngresa el número correspondiente al tipo de usuario del que haces parte:"
                        +
                        "\n1. Usuario administrativo. \n2. Usuario normal. \n3. Salir";
                option = Integer.parseInt(view.readData(menu + "\nDigita la opción a continuación: "));
                switch (option) {
                    case 1:
                        validateAdminUser();
                        break;

                    case 2:
                        showUserMenu();
                        break;

                    case 3:
                        System.exit(0);
                        break;

                    default:
                        view.showMessage("Opción inválida");
                        break;
                }

            } while (option != 4);
        } catch (NumberFormatException e) {
            view.showMessage(
                    "Número ingresado de forma incorrecta. Asegurate de que éste no tenga espacios, ni puntos, ni viñetas, ni texto adicional. Ej. 1");
            showMainMenu();
        }
    }

    public void validateAdminUser() {
        if (digitalQueueSystem.validateAdminUserLogIn(new AdminUser(validateID(),
                view.readData("Ingrese el numero de documento: "), view.readData("Ingrese su contraseña: ")))) {
            showAdminMenu();
        } else {
            view.showMessage("USUARIO O CONTRASEÑA INCORRECTAS");
        }
    }

    public IdentificationType validateID() {
        IdentificationType identificationType = IdentificationType.CEDULA;
        int option = 0;
        try {

            do {
                String menu = "Ingrese en numero que corresponda a su tipo de documento\n1. Cédula de ciudadanía\n2. Tarjeta de identidad\n3. Salir al menú principal";
                option = Integer.parseInt(view.readData(menu + "\nDigita la opción a continuación: "));
                switch (option) {
                    case 1:
                        identificationType = IdentificationType.CEDULA;
                        break;
                    case 2:
                        identificationType = IdentificationType.TARJETA_DE_IDENTIDAD;
                        break;

                    case 3:
                        showMainMenu();
                        break;
                    default:
                        view.showMessage("Opción inválida");
                        break;
                }
                break;
            } while (option != 2);

        } catch (NumberFormatException e) {
            view.showMessage(
                    "Número ingresado de forma incorrecta. Asegurate de que éste no tenga espacios, ni puntos, ni viñetas, ni texto adicional. Ej. 1");
            validateID();
        }
        return identificationType;
    }

    public void showUserMenu() {
        int option = 0;
        String menu = "Bienvenido al sistema de asignación de turnos.  \nEl turno actual es: ";
        try {

            do {
                String menuAux = "";
                try {
                    menuAux = menu + digitalQueueSystem.recoverFirstUserInQueue();
                } catch (EmptyQueueException e) {
                    menuAux = menu + "NINGUNO";
                }
                option = Integer
                        .parseInt(view.readData(menuAux
                                + "\n1. Solicitar turno\n2. Salir al menú principal. \nDigita la opción a continuación: "));
                switch (option) {
                    case 1:
                        assignWaitingToken();
                        break;

                    case 2:
                        showMainMenu();
                        break;
                    default:
                        view.showMessage("Opción inválida");
                        break;
                }
                break;
            } while (option != 4);
        } catch (NumberFormatException e) {
            view.showMessage(
                    "Número ingresado de forma incorrecta. Asegurate de que éste no tenga espacios, ni puntos, ni viñetas, ni texto adicional. Ej. 1");
            showUserMenu();
        }
    }

    public void assignWaitingToken() {
        view.showMessage("Se le asigno el turno número: " + digitalQueueSystem.assignWaitingToken(new UserInQueue(
                validateID(), view.readData("Ingrese su numero de documento: "))));
    }

    public void showAdminMenu() {
        int option = 0;
        String menu = "Bienvenido al sistema de asignación de turnos.  \nEl turno actual es: ";
        try {
            do {
                String menuAux = "";
                try {
                    menuAux = menu + digitalQueueSystem.recoverFirstUserInQueue();
                } catch (EmptyQueueException e) {
                    menuAux = menu + "NINGUNO";
                }
                option = Integer.parseInt(view.readData(menuAux
                        + "\n1. Pasar al siguiente turno\n2. Reiniciar el numero de turnos\n3. Volver al menu principal \nDigita la opción a continuación: "));
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
        } catch (NumberFormatException e) {
            view.showMessage(
                    "Número ingresado de forma incorrecta. Asegurate de que éste no tenga espacios, ni puntos, ni viñetas, ni texto adicional. Ej. 1");
            showAdminMenu();
        }
    }

    public void changeToNextUserInQueue() {
        try {
            User user = digitalQueueSystem.changeToNextUserInQueue();
            String message = "El usuario atendido fue: " + user;
            if (digitalQueueSystem.getUsersInQueue().size() == 0) {
                view.showMessage(message);
            } else {
                view.showMessage(message + "\nEl siguiente usuario a atender es: "
                        + digitalQueueSystem.recoverFirstUserInQueue());
            }

        } catch (EmptyQueueException e) {
            view.showMessage(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Presenter().run();
    }

}