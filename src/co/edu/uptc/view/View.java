package co.edu.uptc.view;

import javax.swing.JOptionPane;

public class View {

	public String readData(String message) {
		boolean inputIsValid = false;
		String input = "";
		while (!inputIsValid) {
			input = JOptionPane.showInputDialog(message);
			if (input.isEmpty()) {
				showMessage("El campo no puede estar vacio.");
			} else {
				inputIsValid = true;

			}
		}
		return input;

	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
