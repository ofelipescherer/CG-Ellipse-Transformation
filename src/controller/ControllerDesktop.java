package controller;

import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;
import model.entities.Draw;
import view.ViewDesktop;

public class ControllerDesktop {


	ViewDesktop view;
	Model model;
	
	public ControllerDesktop() {
		model = new Model(4, 5, 4);

		view = new ViewDesktop(model.getDraw());
		
		view.addListenerTranslation(new TranslationListener());
	}
	
	class TranslationListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			
			List<Double> pointsTransladed = view.getValueSTranslade();
			
			model.doTransformations(pointsTransladed);
			
			Draw draw = model.getDraw();
			view.updateDraw(draw);
		}
		
	}
	
}
