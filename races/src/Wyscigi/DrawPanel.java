package Wyscigi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	public final int width = 100;
	public final int height = 400;
	private int ovalHeight = 0;
	
	public DrawPanel(Color color) {
		super();
		setPreferredSize(new Dimension(width, height));
		setBackground(color);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
//				System.out.println("Excited");
				setBackground(color);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
//				System.out.println("Entered");
				setBackground(Color.white);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	public void changedPosition() {
		ovalHeight++;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(45, ovalHeight, 10, 10);
		g.drawLine(0, 200, 200, 200);
	}
	
	public void draw() {
		repaint();
	}
	
	public void draw(int position) {
		ovalHeight = position;
		repaint();
	}

	public int getOvalHeight() {
		return ovalHeight;
	}
	
}
