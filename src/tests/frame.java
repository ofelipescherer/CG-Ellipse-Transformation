package tests;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class frame extends JFrame{
	
	
	public frame() {
		
		ScrollPane sp = new ScrollPane();
		setSize(new Dimension(500, 500));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(sp);
		sp.addMouseWheelListener(new zoomBehavior());
		
		sp.add(new JButton("Salve"), BorderLayout.CENTER);
	}
	
}


class zoomBehavior implements MouseWheelListener{

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println(e.getWheelRotation());
//		if(e.getWheelRotation()) {
//			
//		}
//		
	}
	
	
}