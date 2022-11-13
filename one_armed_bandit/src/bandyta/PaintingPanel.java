package bandyta;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PaintingPanel extends JPanel{

	private static int width = 500;
	private static int height = 300;
	private Color color = Color.black;
	private String text = "Kolor";
	private int xCord;
	private int yCord;
	
	
	public void setColor(Color color) {
		this.color = color;
		System.out.println(color);
		System.out.println(color);
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(color);
		g.setColor(color);
		g.drawString(text, xCord, yCord);
	}


	public PaintingPanel() {
		super();
		setPreferredSize(new Dimension(width, height));
//		setBackground(Color.gray);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				xCord= e.getX();
				yCord = e.getY();
				System.out.println(color);
				repaint();
				
			}
		});
		
	}


	



	
		
}

