package ReverseEngineering2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	private HashSet<Figure> figureSet = new HashSet<>();
	private JButton release;
	private int help = 0;
	private int xCord = 0;
	private int yCord = 0;
	private int counter = 0;
	private Color color;
	private Color color2 = Color.black;
	private ThreadWait stop;
	private Object lock = new Object();

	public void setColor(Color color) {
		this.color = color;
	}

	public DrawingPanel() {
		release = new JButton("Release");
		release.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lock.notify();
			}
		});
		add(release);
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
				xCord = e.getX();
				yCord = e.getY();
				if (e.getButton() == 1) {
					help = 1;
					repaint();
					addOval(xCord, yCord);

					ThreadXY moveO = createNewThread(new Oval(xCord, yCord));
					moveO.start();
				} else {
					help = 2;
					addCross(xCord, yCord);
					int i = new Random().nextInt(5);
					if (i == 1) {
						stop = createNewThread2(new Cross(xCord, yCord));
						color2 = color.red;
						stop.start();

					} else {
						repaint();

						ThreadXY moveC = createNewThread(new Cross(xCord, yCord));
						moveC.start();
					}
				}

			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (help == 1) {
			g.setColor(color);
			g.drawOval(xCord - 50, yCord - 50, 100, 100);
		} else {
			g.setColor(color2);
			g.drawString("x", xCord, yCord);
		}
		paintPrevious(g);
	}

	public void addCross(int x, int y) {
		figureSet.add(new Cross(x, y));
	}

	public void addOval(int x, int y) {
		figureSet.add(new Oval(x, y));
	}

	private void paintPrevious(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		for (Figure figure : figureSet) {
			if (figure instanceof Cross) {
				g.drawString("x", figure.getX(), figure.getY());
			} else {
				g.drawOval(figure.getX() - 50, figure.getY() - 50, 100, 100);
			}
		}
	}

	private ThreadXY createNewThread(Figure figure) {
		return new ThreadXY(this, figure);
	}

	public void moving(Figure figure) {
		repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (figure instanceof Cross) {
			int i = new Random().nextInt(100);
			if (i == 1) {

			}
		}

//		if (counter >= 20) {
//			
//		}
	}

	public void waiting(Figure figure) {
		synchronized (lock) {
			repaint();
			System.out.println("Krzyzyk w zawieszeniu");
			System.out.println(figure);
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			color2 = Color.black;
			repaint();
			System.out.println("Krzyzyk odwieszony");
		}

	}

	private ThreadWait createNewThread2(Figure figure) {
		return new ThreadWait(this, figure);
	}

}
