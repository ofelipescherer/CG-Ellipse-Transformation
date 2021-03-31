package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class ViewCanvas extends JPanel{
	
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	List<List<Double>> points;
	List<Double> tValues;
	int vertices = 15;
	
	List<Color> colors;
	
//	float x;
//	float y;
	
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
	 
	
//	int x0 = 10;
//	int y0 = 10;
//	int x1 = 120;
//	int y1 = 220;
//	
//	int valueX = 0;
//	int valueY = 0;
	
	public ViewCanvas() {
		setPreferredSize(new Dimension(500,500));
		
		colors = new ArrayList<>();
		
		for(int i=0; i< vertices; i++) {
			colors.add(new Color(
					rand.nextFloat(),
					rand.nextFloat(),
					rand.nextFloat()
					));
		}
		
	}
	
	
	private void makeEllipse() {
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
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		makeEllipse();
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(2));
		
		int scaleCorrection = 500/2;
		
		for(int i=0; i<points.size()-1; i++) {
//			System.out.println("Angulo " + tValues.get(i));
//			System.out.println("Ponto " + points.get(i));
			int pointX = (int) Math.round(points.get(i).get(0)) + scaleCorrection;
			int pointY = (int) Math.round(points.get(i).get(1)) + scaleCorrection;
			int pointX1 = (int) Math.round(points.get(i+1).get(0)) + scaleCorrection;
			int pointY1 = (int) Math.round(points.get(i+1).get(1)) + scaleCorrection;
			g2d.setColor(colors.get(i));
			g2d.drawLine(pointX, pointY, pointX1, pointY1);
		}
		
		//Draw the last Line
			g2d.drawLine(
					(int) Math.round(points.get(points.size()-1).get(0)) + scaleCorrection,
					(int) Math.round(points.get(points.size()-1).get(1)) + scaleCorrection,
					(int) Math.round(points.get(0).get(0)) + scaleCorrection,
					(int) Math.round(points.get(0).get(1)) + scaleCorrection
			);
		
//		int x0 = 16 + scaleCorrect;
//		int y0 = 0 + scaleCorrect;
//		int x90 = 0 + scaleCorrect;
//		int y90=9 + scaleCorrect;
//		int x180=-16 + scaleCorrect;
//		int y180=0 + scaleCorrect;
//		int x270=0 + scaleCorrect;
//		int y270=-9 + scaleCorrect;
		
//		x0 = 10;
//		y0 = 10;
//		x1 = 120;
//		y1 = 220;
//		
//		x0 += valueX;
//		x1 += valueY;
//		g2d.drawLine(x1, y1, valueY, valueX);
		
//		g2d.drawLine(x0, y0, x90, y90);
//		g2d.drawLine(x90, y90, x180, y180);
//		g2d.drawLine(x180, y180, x270, y270);
//		g2d.drawLine(x270, y270, x0, y0);
	}
	
	public void updateValueX(double newX) {
//		for(int i=0; i<points.size()-1; i++) {
//			points.get(i).set(0,points.get(i).get(0) + newX);
//			repaint();
//		}
		h = newX;
		System.out.println(newX);
		repaint();
	}
	
}
