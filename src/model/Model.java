package model;

import java.util.ArrayList;
import java.util.List;

import model.entities.Draw;
import model.entities.Point;

public class Model {

	List<Double> tValues;
	List<Point> points;
	
	Draw draw;
	
	int vertices;
	
	//Ellipse Size
	int width;
	int height;
	
	public Model(int vertices, int aWidth, int aHeight) {
		this.width = aWidth;
		this.height = aHeight;
		this.vertices = vertices;
		this.initPoints();
		draw = new Draw(points);
	}
	
	public void initPoints(){
		tValues = new ArrayList<>();
		points = new ArrayList<>();
		
		for(double i=0; i<=360; i+=360/vertices) {
			tValues.add(i);
			
			
			double x = width*(Math.cos(Math.toRadians(i)));
			double y = height*(Math.sin(Math.toRadians(i)));
			
			if(i==90 || i==270)
				x = 0;
			if(i==180)
				y=0;
			
			Point p = new Point(
					x*Math.abs(width*width), 
					y*Math.abs(height*height)
					);

			points.add(p);
		}
	}
	
	public void doTransformations(Point point, double angle, double a, double b) {
		draw.reset();
		draw.doScale(a, b);
		draw.doTranslade(point.x, point.y);
		draw.doRotation(angle);

	}
	
	public Draw getDraw() {
		return draw;
	}
	
	public void changeVertices(int aVertices) {
		draw.reset();
		this.initPoints();
		draw = new Draw(points);
	}

}
