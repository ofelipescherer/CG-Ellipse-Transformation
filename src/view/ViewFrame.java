package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ViewFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	ViewSliderPanel sliders = new ViewSliderPanel();
	ViewCanvas canvas = new ViewCanvas();
	
	public ViewFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(canvas, BorderLayout.LINE_START);
		add(sliders, BorderLayout.CENTER);
		
		sliders.addListenerTranslationX(new TranslationXListener());
		sliders.addListenerTranslationY(new TranslationYListener());
		sliders.addListenerRotation(new RotationListener());
		sliders.addListenerScaling(new ScalingListener());
		sliders.addListenerShearing(new ShearingListener());
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	class TranslationXListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			canvas.updateValueX(sliders.getsTranslationX());
		}	
	}
	
	class TranslationYListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			canvas.updateValueY(sliders.getsTranslationY());
		}	
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
