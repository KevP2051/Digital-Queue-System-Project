package co.edu.uptc.view;

import javax.swing.JOptionPane;

public class View {

	public String readData(String message) {
		return JOptionPane.showInputDialog(message);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
