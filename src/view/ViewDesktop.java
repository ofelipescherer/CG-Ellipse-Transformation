package view;

import java.util.List;

import javax.swing.event.ChangeListener;

import model.entities.Draw;
import model.entities.Point;

public class ViewDesktop {

	ViewFrame frame;
	
	public ViewDesktop(Draw aDraw) {
		frame = new ViewFrame(aDraw);
	}
	
	public Point getValueSTranslade() {
		return frame.getValueSTranslade();
	}
	
	public double getValueAngleRotation() {
		return frame.getValueAngleRotation();
	}
	
	public void addListenerTranslation(ChangeListener cl) {
		frame.addListenerTranslation(cl);
	}
	
	public void updateDraw(Draw aDraw) {
		frame.updateDraw(aDraw);
	}
	
}
