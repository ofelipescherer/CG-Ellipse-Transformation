package controller;

import model.entities.Draw;
import view.ViewDesktop;

public class ControllerDesktop {

	Draw draw;
	ViewDesktop view;
	
	public ControllerDesktop() {
		draw = new Draw();
		draw.makeEllipse();
		System.out.println(draw);
		ViewDesktop view = new ViewDesktop(draw);
		
	}
	
}
