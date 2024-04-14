package co.edu.uptc.presenter;

import co.edu.uptc.view.View;

public class Presenter {
    private View view;
    


public void run() {
    showMenu();
}

public void showMenu(){
   
        int option = 0;
        do {
            String menu = "";
            option = Integer.parseInt(view.readData(menu + "\nDigita la opción a continuación: "));
            switch (option) {
            case 1:

            break;

            case 2:

            break;

            case 3:

            break;

            case 4:
                System.exit(0);
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