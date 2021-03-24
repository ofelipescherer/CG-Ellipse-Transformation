package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ViewCanvas extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	int x0 = 10;
	int y0 = 10;
	int x1 = 120;
	int y1 = 220;
	
	int valueX = 0;
	int valueY = 0;
	
	public ViewCanvas() {
		setPreferredSize(new Dimension(500,500));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(10));
		
		x0 = 10;
		y0 = 10;
		x1 = 120;
		y1 = 220;
		
		x0 += valueX;
		x1 += valueY;
		
		g2d.drawOval(x0, y0, x1, y1);
	}
	
	public void updateValue(int newX, int newY) {
		this.valueX = newX;
		this.valueY = newY;
		this.repaint();
	}
	
}
