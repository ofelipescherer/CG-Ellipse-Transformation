package model;

import model.entities.Point;

public class Transformation {

	static public Point translade(Point p, double aX, double aY){
		return new Point(p.x + aX, p.y + aY);
		
	}
	
	static public Point rotate(Point p, double angle) {
		double[][] m1 = {{p.x, p.y}};
		double[][] m2 = 
			{{ Math.cos(angle), Math.sin(angle)},
			 {-Math.sin(angle), Math.cos(angle)}};
		double[][] res = multiply(m1, m2);
		return new Point(res[0][0], res[0][1]);
	}
	
	static public double[][] multiply(double[][] m1, double[][] m2) {
		int rowM1 = m1.length;
		int colM1 = m1[0].length;
		int colM2 = m2[0].length;
		double[][] res = new double[rowM1][colM2];
		for(int i=0; i<rowM1; i++) {
			for(int j=0; j<colM2; j++) {
				double sum = 0;
				for(int k=0; k<colM1; k++) {
					sum += m1[i][k]*m2[k][j];
				}
				res[i][j] = sum;
			}
		}
		return res;

	}
	
	
}
