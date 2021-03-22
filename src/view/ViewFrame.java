package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ViewFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	ViewSliderPanel translation = new ViewSliderPanel();
	ViewSliderPanel rotation = new ViewSliderPanel();
	
	public ViewFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(translation, BorderLayout.CENTER);
		add(rotation, BorderLayout.LINE_END);
		
		translation.addListener(new UpdateDraw());
		rotation.addListener(new UpdateDraw());
		
		pack();
		setVisible(true);
	}
	
	class UpdateDraw implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			System.out.println("Translation: " + translation.getValue());
			System.out.println("Rotation: " + rotation.getValue());
		}
		
	}

}
