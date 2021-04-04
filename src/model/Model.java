package model;

import java.util.ArrayList;
import java.util.List;

import model.entities.Draw;
import model.entities.Point;

public class Model {

	List<Double> tValues;
	List<Point> points;
	
	Draw draw;
	
	
	public Model(int vertices, int a, int b) {
		this.initPoints(vertices, a, b);
		draw = new Draw(vertices, a, b, points);
	}
	
	public List<Point> initPoints(int vertices, int a, int b){
		tValues = new ArrayList<>();
		points = new ArrayList<>();
		
		for(double i=0; i<=360; i+=360/vertices) {
			tValues.add(i);
			
			
			double x = a*(Math.cos(Math.toRadians(i)));
			double y = b*(Math.sin(Math.toRadians(i)));
			
			if(i==90 || i==270)
				x = 0;
			if(i==180)
				y=0;
			
			Point p = new Point(
					x*Math.abs(a*a), 
					y*Math.abs(b*b)
					);

			points.add(p);
		}
		
		return points;
	}
	
	public void doTransformations(Point point, double angle) {
		draw.reset();
		draw.doTranslade(point.x, point.y);
		draw.doRotation(angle);
	}
	
	public Draw getDraw() {
		return draw;
	}
}
