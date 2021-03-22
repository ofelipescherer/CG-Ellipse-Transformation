package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class ViewSliderPanel extends JPanel{

	JSlider slider = new JSlider();
	
	public ViewSliderPanel() {
		setLayout(new FlowLayout());
		add(slider);

	}

	public int getValue() {
		return slider.getValue();
	}
	
	public void addListener(ChangeListener cl) {
		this.slider.addChangeListener(cl);
	}
}
