package view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import model.entities.Draw;


public class ViewCanvas extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	double zoom = 1;
	Draw draw;
	boolean isSpaceNeeded = false;
	
	public ViewCanvas(Draw aDraw) {
		
		setPreferredSize(new Dimension(500,500));
		draw = aDraw;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		//Draw cartesian
		g2d.setStroke(new BasicStroke(1));

		g2d.setColor(new Color(0,0,0,100));
		//Screen will always be 500px * zoom for 500px * by zoom
		g2d.drawLine(250, 0, 250, 500);
		g2d.drawLine(0, 250, 500, 250);
		
		
		if(zoom < 1) {
			isSpaceNeeded = true;
		} else {
			isSpaceNeeded = false;
		}
			
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		int counter=0;
		//Make lines 12 is draw scale
		for(int i = 250; i<500; i+=12*zoom) {
			if(isSpaceNeeded) {
				if(counter%2 ==0) {
					g2d.drawString(String.valueOf(counter) , i-3, 242);
					g2d.drawString(String.valueOf(-counter) , 257, i+3);
					}
			} else {
				g2d.drawString(String.valueOf(counter) , i-3, 242);
				g2d.drawString(String.valueOf(-counter) , 257, i +3);
			}
			counter++;
			g2d.drawLine(245, i, 255, i);
			g2d.drawLine(i, 245, i, 255);
		}
		counter =0;
		for(int i = 250; i>0; i-=12*zoom) {
			if(isSpaceNeeded) {
				if(counter%2 ==0) {
					g2d.drawString(String.valueOf(-counter) , i-3, 242);
					g2d.drawString(String.valueOf(counter) , 257, i+3);
					}
			} else {
				g2d.drawString(String.valueOf(-counter) , i-3, 242);
				g2d.drawString(String.valueOf(counter) , 257, i +3);
			}
			counter++;
			g2d.drawLine(245,i, 255, i);
			g2d.drawLine(i, 245, i, 255);
		}
		
		
		g2d.setStroke(new BasicStroke(2));
		
		int scaleCorrection = 500/2;
		
		for(int i=0; i<draw.getPoints().size()-1; i++) {
			int pointX = (int) Math.round(draw.getPoints().get(i).x) + scaleCorrection;
			int pointY = (int) Math.round(draw.getPoints().get(i).y) + scaleCorrection;
			int pointX1 = (int) Math.round(draw.getPoints().get(i+1).x) + scaleCorrection;
			int pointY1 = (int) Math.round(draw.getPoints().get(i+1).y) + scaleCorrection;
			g2d.setColor(draw.getColors()[i]);
			g2d.drawLine(pointX, pointY, pointX1, pointY1);
		}
		
		//Draw the last Line
			g2d.drawLine(
					(int) Math.round(draw.getPoints().get(draw.getPoints().size()-1).x) + scaleCorrection,
					(int) Math.round(draw.getPoints().get(draw.getPoints().size()-1).y) + scaleCorrection,
					(int) Math.round(draw.getPoints().get(0).x) + scaleCorrection,
					(int) Math.round(draw.getPoints().get(0).y) + scaleCorrection
			);
	}
	
	public void updateDraw(Draw aDraw) {
		this.draw = aDraw;
		repaint();
		
	}
	
	public void setZoom(double aZoom) {
		this.zoom = aZoom;
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
