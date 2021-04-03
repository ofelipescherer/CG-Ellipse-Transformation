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
	
	Draw draw;
	public ViewCanvas(Draw aDraw) {
		
		setPreferredSize(new Dimension(500,500));
		draw = aDraw;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
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
	}
	
	public void updateDraw(Draw aDraw) {
		this.draw = aDraw;
		repaint();
	}
	
//	public void updateValueX(double newX) {
////		for(int i=0; i<points.size()-1; i++) {
////			points.get(i).set(0,points.get(i).get(0) + newX);
////			repaint();
////		}
//		double h = newX;
//		repaint();
//	}
//	
//	public void updateValueY(double newY) {
////		for(int i=0; i<points.size()-1; i++) {
////			points.get(i).set(0,points.get(i).get(0) + newX);
////			repaint();
////		}
//		double k = newY;
//		repaint();
//	}
	
}
