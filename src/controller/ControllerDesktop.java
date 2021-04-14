package controller;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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
	double zoom = 1;
	
	public ControllerDesktop() {
		model = new Model(34, 6, 3);

		view = new ViewDesktop(model.getDraw());
		
		view.addSliderListener(new SliderListener());
		view.addSliderChangeVerticesListener(new SliderVerticesListener());
		view.addMouseWheelListener(new zoomBehavior());
		
	}
	
	public void updateDraw() {
		Point pointsTransladed = view.getValueSTranslade();
		double angle = view.getValueAngleRotation();
		double a = view.getValueScaleX();
		double b = view.getValueScaleY();
		double mX = view.getValueShearingX();
		double mY = view.getValueShearingY();

		model.doTransformations(pointsTransladed, angle, a, b, mX, mY);
		Draw draw = model.getDraw();
		view.updateDraw(draw);
	}
	
	class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			updateDraw();
		}
		
	}
	
	class SliderVerticesListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			model.changeVertices(view.getVertices());
			updateDraw();
		}
		
	}
	
	class zoomBehavior implements MouseWheelListener{

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if(e.getWheelRotation() < 0) {
				//Zoom needs to increase
				zoom += 0.5;
			} else {
				zoom -= 0.5;
				if(zoom < 0.5)
					zoom = 0.5;
			}
			model.setZoom(zoom);	
			view.setZoom(zoom);
			updateDraw();
		}
	}
	
	
	
	
}
