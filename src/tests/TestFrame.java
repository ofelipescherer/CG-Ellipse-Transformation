package tests;

import javax.swing.SwingUtilities;

import view.ViewFrame;
import view.ViewSliderPanel;

public class TestFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	
	public static void createAndShowGUI() {
		new ViewFrame();
	}

	
}
