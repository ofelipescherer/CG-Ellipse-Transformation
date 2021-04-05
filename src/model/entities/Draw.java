package model.entities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Transformation;

public class Draw {

	Random rand = new Random();
	List<Point> points;
	List<Point> initialPoints;
	List<Double> tValues;
	
	
	Color[] colors;
	
	
	int width;
	int height;
	
	//The values above need to follow the equation
	// x = a*cos(t) == cos(t) = x/a
	// y = b*sin(t) == sin(t) = y/b
	//cos² + sin² = 1
	// ((x-h)/a)² + ((y-k)/b)² = 1
	//Some start values
	/*
	 t  | x | y
	 ---|---|---
	 0  |4  |0 
	 90 |0  |3
	 180|-4 |0
	 270|0  |-3
	 360|4  |0
	*/
	public Draw(List<Point> aPoints) {
		this.points = aPoints;
		this.initialPoints = aPoints;
		this.chooseColors();
		//List<List<Double>> points
	}
	
	public Point getMidPoint() {
		Point midPoint = new Point();
		for(Point p: points) {
			midPoint.x += p.x;
			midPoint.y += p.y;
		}
		midPoint.x /= points.size();
		midPoint.y /= points.size();
		return midPoint;
	}
	
	public void reset() {
		this.points = initialPoints;
	}

	public List<Point> getPoints() {
		return points;
	}

	public Color[] getColors() {
		return colors;
	}

	public void chooseColors() {
		colors = new Color[points.size()];
		for(int i=0; i< points.size(); i++) {
			colors[i] = new Color(
					rand.nextFloat(),
					rand.nextFloat(),
					rand.nextFloat()
					);
		}
	}
	
	public void doTranslade(double aX, double aY) {
		List<Point> aux = new ArrayList<>();
		
		for(Point p : points) {
			Point newP = Transformation.translade(p, aX, aY);
			aux.add(newP);
		}	
		this.points = aux;
	}
	
	public void doRotation(double angle) {
		List<Point> aux = new ArrayList<>();
		Point midPoint = this.getMidPoint();
		for(Point p : points) {
			Point newP = new Point(p.x, p.y);
			newP = Transformation.translade(newP, -midPoint.x, -midPoint.y);
			newP = Transformation.rotate(newP, angle);
			newP = Transformation.translade(newP, midPoint.x, midPoint.y);
			aux.add(newP);
		}
		this.points = aux;	
	}
	
	public void doScale(double aX, double aY) {
		List<Point> aux = new ArrayList<>();
		Point midPoint = this.getMidPoint();
		for(Point p : points) {
			Point newP = new Point(p.x, p.y);
			newP = Transformation.translade(newP, -midPoint.x, -midPoint.y);
			newP = Transformation.scale(newP, aX, aY);
			newP = Transformation.translade(newP, midPoint.x, midPoint.y);
			aux.add(newP);
		}
		this.points = aux;
	}
	


	@Override
	public String toString() {
		String res = "";
		for (Point p: this.points) {
			res += p;
			res += "\n";
		}
		return res;
	}
	
	
}
