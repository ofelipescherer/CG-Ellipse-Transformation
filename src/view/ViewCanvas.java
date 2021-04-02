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

import model.entities.Draw;

public class ViewCanvas extends JPanel{
	
	private static final long serialVersionUID = 1L;

	
//	float x;
//	float y;
	
	Draw draw;
	
	
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
	
	public ViewCanvas(Draw aDraw) {
		
		setPreferredSize(new Dimension(500,500));
		draw = aDraw;
	}
	
	

	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		draw.makeEllipse();
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setStroke(new BasicStroke(2));
		
		int scaleCorrection = 500/2;
		
		for(int i=0; i<draw.getPoints().size()-1; i++) {
//			System.out.println("Angulo " + tValues.get(i));
//			System.out.println("Ponto " + points.get(i));
			int pointX = (int) Math.round(draw.getPoints().get(i).get(0)) + scaleCorrection;
			int pointY = (int) Math.round(draw.getPoints().get(i).get(1)) + scaleCorrection;
			int pointX1 = (int) Math.round(draw.getPoints().get(i+1).get(0)) + scaleCorrection;
			int pointY1 = (int) Math.round(draw.getPoints().get(i+1).get(1)) + scaleCorrection;
			g2d.setColor(draw.getColors().get(i));
			g2d.drawLine(pointX, pointY, pointX1, pointY1);
		}
		
		//Draw the last Line
			g2d.drawLine(
					(int) Math.round(draw.getPoints().get(draw.getPoints().size()-1).get(0)) + scaleCorrection,
					(int) Math.round(draw.getPoints().get(draw.getPoints().size()-1).get(1)) + scaleCorrection,
					(int) Math.round(draw.getPoints().get(0).get(0)) + scaleCorrection,
					(int) Math.round(draw.getPoints().get(0).get(1)) + scaleCorrection
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
		double h = newX;
		repaint();
	}
	
	public void updateValueY(double newY) {
//		for(int i=0; i<points.size()-1; i++) {
//			points.get(i).set(0,points.get(i).get(0) + newX);
//			repaint();
//		}
		double k = newY;
		repaint();
	}
	
}
