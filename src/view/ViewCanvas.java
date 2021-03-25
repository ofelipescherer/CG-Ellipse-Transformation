package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ViewCanvas extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	float x;
	float y;
	
	//Ellipse Size
	int a = 4;
	int b = 3;
	
	//If you do not want to start at center, change these values
	int h = 0;
	int k = 0;
	
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
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(5));
		
		int scaleCorrect = 500/2;
		
		int x0 = 16 + scaleCorrect;
		int y0 = 0 + scaleCorrect;
		int x90 = 0 + scaleCorrect;
		int y90=9 + scaleCorrect;
		int x180=-16 + scaleCorrect;
		int y180=0 + scaleCorrect;
		int x270=0 + scaleCorrect;
		int y270=-9 + scaleCorrect;
		
//		x0 = 10;
//		y0 = 10;
//		x1 = 120;
//		y1 = 220;
//		
//		x0 += valueX;
//		x1 += valueY;
//		g2d.drawLine(x1, y1, valueY, valueX);
		
		g2d.drawLine(x0, y0, x90, y90);
		g2d.drawLine(x90, y90, x180, y180);
		g2d.drawLine(x180, y180, x270, y270);
		g2d.drawLine(x270, y270, x0, y0);
	}
	
	public void updateValue(int newX, int newY) {
	}
	
}
