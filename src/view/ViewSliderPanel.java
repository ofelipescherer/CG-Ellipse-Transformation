package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class ViewSliderPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JSlider sTranslationX = new JSlider(-100,100,0);
	JSlider sTranslationY = new JSlider(-100,100,0);
	
	JSlider sRotationX = new JSlider(0,250,125);
	JSlider sRotationY = new JSlider(0,250,125);
	
	JSlider sScalingX = new JSlider(0,250,125);
	JSlider sScalingY = new JSlider(0,250,125);
	
	JSlider sShearingX = new JSlider(0,250,125);
	JSlider sShearingY = new JSlider(0,250,125);
	
	public ViewSliderPanel() {
		setLayout(new GridLayout(4,2));
		setPreferredSize(new Dimension(650,500));
		add(sTranslationX);
		add(sTranslationY);
		add(sRotationX);
		add(sRotationY);
		add(sScalingX);
		add(sScalingY);
		add(sShearingX);
		add(sShearingY);
		
		//Setting Title and Border
		sTranslationX.setBorder(BorderFactory.createTitledBorder("Translation X"));
		sTranslationY.setBorder(BorderFactory.createTitledBorder("Translation Y"));
		sRotationX.setBorder(BorderFactory.createTitledBorder("Rotation X"));
		sRotationY.setBorder(BorderFactory.createTitledBorder("Rotation Y"));
		sScalingX.setBorder(BorderFactory.createTitledBorder("Scaling X"));
		sScalingY.setBorder(BorderFactory.createTitledBorder("Scaling Y"));
		sShearingX.setBorder(BorderFactory.createTitledBorder("Shearing X"));
		sShearingY.setBorder(BorderFactory.createTitledBorder("Shearing Y"));
		
		//Add Mark Tricks
		for (Component c : this.getComponents()) {
			if(c instanceof JSlider) {
				((JSlider) c).setMajorTickSpacing(50);
			    ((JSlider) c).setMinorTickSpacing(10);
			    ((JSlider) c).setPaintTicks(true);
			    ((JSlider) c).setPaintLabels(true);
			}
		}
	}
	
	public int getsTranslationX() {
		return sTranslationX.getValue();
	}

	public int getsTranslationY() {
		return sTranslationY.getValue();
	}

	public int getsRotationX() {
		return sRotationX.getValue();
	}

	public int getsRotationY() {
		return sRotationY.getValue();
	}

	public int getsScalingX() {
		return sScalingX.getValue();
	}

	public int getsScalingY() {
		return sScalingY.getValue();
	}

	public int getsShearingX() {
		return sShearingX.getValue();
	}

	public int getsShearingY() {
		return sShearingY.getValue();
	}

	public void addListenerTranslation(ChangeListener cl) {
		this.sTranslationX.addChangeListener(cl);
		this.sTranslationY.addChangeListener(cl);
	}
	
	public void addListenerRotation(ChangeListener cl) {
		this.sRotationX.addChangeListener(cl);
		this.sRotationY.addChangeListener(cl);
	}
	
	public void addListenerScaling(ChangeListener cl) {
		this.sScalingX.addChangeListener(cl);
		this.sScalingY.addChangeListener(cl);
	}
	
	public void addListenerShearing(ChangeListener cl) {
		this.sShearingX.addChangeListener(cl);
		this.sShearingY.addChangeListener(cl);
	}
}
