package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.entities.Draw;
import model.entities.Point;

public class ViewFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Draw draw;
	ViewSliderPanel sliders = new ViewSliderPanel();
	ViewCanvas canvas;
	
	public ViewFrame(Draw aDraw) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		draw = aDraw;
		canvas = new ViewCanvas(draw);
		add(canvas, BorderLayout.LINE_START);
		add(sliders, BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void updateDraw(Draw aDraw) {
		canvas.updateDraw(aDraw);
	}
	
	public void addListenerTranslation(ChangeListener cl) {
		sliders.addListener(cl);
	}
	
	public Point getValueSTranslade() {
		return new Point(
				(double) sliders.getsTranslationX(), 
				(double) sliders.getsTranslationY()
				);
	}
	
	public double getValueAngleRotation() {
		return sliders.getsRotation();
	}	

}
