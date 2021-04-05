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
	
	public int getVertices() {
		return frame.getVertices();
	}
	
	public Point getValueSTranslade() {
		return frame.getValueSTranslade();
	}
	
	public double getValueAngleRotation() {
		return frame.getValueAngleRotation();
	}
	
	public void addSliderListener(ChangeListener cl) {
		frame.addSliderListener(cl);
	}
	
	public void addSliderChangeVerticesListener(ChangeListener cl) {
		frame.addSliderListener(cl);
	}
	public void updateDraw(Draw aDraw) {
		frame.updateDraw(aDraw);
	}
	
}
