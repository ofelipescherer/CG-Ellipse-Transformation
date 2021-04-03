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
	int vertices;
	
	List<Color> colors;
	
	//Ellipse Size
	int width;
	int height;
	
	//The values above need to follow the equation
	// x = a*cos(t) == cos(t) = x/a
	// y = b*sin(t) == sin(t) = y/b
	//cos� + sin� = 1
	// ((x-h)/a)� + ((y-k)/b)� = 1
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
	public Draw(int aVertices, int aWidth, int aHeight, List<Point> aPoints) {
		this.vertices = aVertices;
		this.width = aWidth;
		this.height = aHeight;
		this.points = aPoints;
		this.initialPoints = aPoints;
		this.chooseColors();
		//List<List<Double>> points
		

	}
	
	public void reset() {
		this.points = initialPoints;
	}
	
	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public List<Point> getPoints() {
		return points;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void chooseColors() {
		colors = new ArrayList<>();
		for(int i=0; i< vertices; i++) {
			colors.add(new Color(
					rand.nextFloat(),
					rand.nextFloat(),
					rand.nextFloat()
					));
		}
	}
	
	public void doTranslade(double aX, double aY) {
		List<Point> aux = new ArrayList<>();
		
		for(Point p : points) {
			Point newP = Transformation.translade(aX, aY, p.x, p.y);
			aux.add(newP);
		}	
		this.points = aux;
	}
	
	public void doRotation(double angle) {
		List<Point> aux = new ArrayList<>();
		for(Point p : points) {
			Point newP = new Point();
//			newP.add(p.get(0) + aX);
//			newP.add(p.get(1) + aY);
//			aux.add(newP);
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
