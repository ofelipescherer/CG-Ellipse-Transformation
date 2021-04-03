package model;

import model.entities.Point;

public class Transformation {

	static public Point translade(double aX, double aY, double x0, double y0){
		return new Point(x0 + aX, y0 + aY);
		
	}
	
}
