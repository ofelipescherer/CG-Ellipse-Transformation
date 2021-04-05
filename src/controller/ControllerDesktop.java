package controller;

import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;
import model.entities.Draw;
import model.entities.Point;
import view.ViewDesktop;

public class ControllerDesktop {


	ViewDesktop view;
	Model model;
	
	public ControllerDesktop() {
		model = new Model(34, 5, 4);

		view = new ViewDesktop(model.getDraw());
		
		view.addSliderListener(new SliderListener());
		//view.addSliderChangeVerticesListener(new SliderListener());
		
		
	}
	
	class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			
			Point pointsTransladed = view.getValueSTranslade();
			double angle = view.getValueAngleRotation();
			
			
			model.doTransformations(pointsTransladed, angle);
			model.changeVertices(view.getVertices());
			Draw draw = model.getDraw();
			view.updateDraw(draw);
		}
		
	}
	
	
	
	
}
