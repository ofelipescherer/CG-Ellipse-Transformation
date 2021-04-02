package model.entities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Draw {

	Random rand = new Random();
	List<List<Double>> points;
	List<Double> tValues;
	int vertices = 4;
	
	List<Color> colors;
	
	//Ellipse Size
	int a = 5;
	int b = 4;
	
	//If you do not want to start at center, change these values
	double h = 0;
	double k = 0;
	
	float t;
	
	//The values above need to follow the equation
	// x = a*cos(t) == cos(t) = x/a
	// y = b*sin(t) == sin(t) = y/b
	//cos² + sin² = 1
	// ((x-h)/a)² + ((y-k)/b)² = 1
	
	public Draw() {
		this.chooseColors();
		//List<List<Double>> points
		

	}
	
	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public List<List<Double>> getPoints() {
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
	
	public void makeEllipse() {
		tValues = new ArrayList<>();
		points = new ArrayList<>();
		
		for(double i=0; i<=360; i+=360/vertices) {
			tValues.add(i);
			
			
			double x = (a*(Math.cos(Math.toRadians(i)))) + h;
			double y = (b*(Math.sin(Math.toRadians(i)))) + k;
			
			if(i==90 || i==270)
				x = 0;
			if(i==180)
				y=0;
			
			List<Double> p = new ArrayList<>();
			p.add(x*Math.abs(a*a));
			p.add(y*Math.abs(b*b));
			
			points.add(p);
		}
	}

	@Override
	public String toString() {
		String res = "";
		for (List<Double> p: this.points) {
			res += p;
			res += "\n";
		}
		return res;
	}
	
	
}
