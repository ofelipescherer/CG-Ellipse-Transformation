package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.entities.Draw;

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
		
		sliders.addListenerRotation(new RotationListener());
		sliders.addListenerScaling(new ScalingListener());
		sliders.addListenerShearing(new ShearingListener());
		

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void updateDraw(Draw aDraw) {
		canvas.updateDraw(aDraw);
	}
	
	public void addListenerTranslation(ChangeListener cl) {
		sliders.addListenerTranslation(cl);
	}
	
	public List<Double> getValueSTranslade() {
		List<Double> aux = new ArrayList<>();
		aux.add((double) sliders.getsTranslationX());
		aux.add((double) sliders.getsTranslationY());
		return aux;
	}
	
	class RotationListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {

		}
	}
	
	class ScalingListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
	
		}
	}
	
	class ShearingListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {

		}	
	}

}
