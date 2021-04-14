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
	
	double zoom = 1;
	
	//Ellipse Size
	int width;
	int height;
	
	public Model(int vertices, int aWidth, int aHeight) {
		this.width = aWidth;
		this.height = aHeight;
		this.vertices = vertices;
		this.initPoints(vertices);
		draw = new Draw(points);
	}
	
	public void initPoints(int aVertices){
		tValues = new ArrayList<>();
		points = new ArrayList<>();
		
		for(double i=0; i<=360; i+=360/aVertices) {
			tValues.add(i);
			
			
			double x = width*(Math.cos(Math.toRadians(i)));
			double y = height*(Math.sin(Math.toRadians(i)));
			
			if(i==90 || i==270)
				x = 0;
			if(i==180)
				y=0;
			
			Point p = new Point(
					x*12*zoom, 
					y*12*zoom
					);

			points.add(p);
		}
	}
	
	public void doTransformations(Point point, double angle, double a, double b, double mX, double mY) {
		draw.reset();
		draw.doScale(a, b);
		draw.doTranslade(point.x, point.y);
		draw.doRotation(angle);
		draw.doShearingX(mX);
		draw.doShearingY(mY);

	}
	
	public Draw getDraw() {
		return draw;
	}
	
	public void changeVertices(int aVertices) {
		draw.reset();
		this.vertices = aVertices;
		this.initPoints(aVertices);
		draw = new Draw(points);
	}
	
	public void setZoom(double aValue) {
		this.zoom = aValue;
		this.initPoints(vertices);
		draw.setPoints(points);
		draw.setInitialPoints(points);

	}

}
