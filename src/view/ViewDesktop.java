package view;

import java.util.List;

import javax.swing.event.ChangeListener;

import model.entities.Draw;

public class ViewDesktop {

	ViewFrame frame;
	
	public ViewDesktop(Draw aDraw) {
		frame = new ViewFrame(aDraw);
	}
	
	public List<Double> getValueSTranslade() {
		return frame.getValueSTranslade();
	}
	
	public void addListenerTranslation(ChangeListener cl) {
		frame.addListenerTranslation(cl);
	}
	
	public void updateDraw(Draw aDraw) {
		frame.updateDraw(aDraw);
	}
	
}
