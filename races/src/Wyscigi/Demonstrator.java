package Wyscigi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demonstrator extends JFrame {

	private final DrawPanel firstDrawPanel;
	private final DrawPanel secondDrawPanel;
	private CircleMovingThread firstCircleMovingThread;
	private CircleMovingThread secondCircleMovingThread;
	private JButton moveButton;
//	private boolean isWaiting;
	private Object lock = new Object();

	public Demonstrator() throws HeadlessException {
		super();
		this.firstDrawPanel = new DrawPanel(Color.yellow);
		this.secondDrawPanel = new DrawPanel(Color.orange);
		setVisible(true);
		setSize(new Dimension(500, 500));
		getContentPane().setBackground(new Color(0, 150, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Wyscigi!");
		JPanel additionalPanel = new JPanel();
		additionalPanel.setBackground(new Color(0, 150, 0));
		additionalPanel.setPreferredSize(new Dimension(400, 500));
		JPanel mainJPanel = new JPanel();
//		mainJPanel.setPreferredSize(new Dimension(500,500));
		mainJPanel.setBackground(new Color(20, 150, 0));
		mainJPanel.setLayout(new BoxLayout(mainJPanel, BoxLayout.Y_AXIS));
		mainJPanel.add(createControlJPanel());
		mainJPanel.add(getDrawingPanel());
		additionalPanel.add(mainJPanel);
		add(additionalPanel);
//		pack();
	}

	private JPanel getDrawingPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.gray);
		jPanel.add(firstDrawPanel);
		firstDrawPanel.draw(10);
		jPanel.add(secondDrawPanel);
		secondDrawPanel.draw(5);

		return jPanel;
	}

	private JPanel createControlJPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(new Color(150, 250, 0));
		JButton startButton = new JButton("Start");
		controlPanel.add(startButton);
		moveButton = new JButton("Dalej");
		moveButton.setEnabled(false);
		controlPanel.add(moveButton);
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				int sleep1 = new Random().nextInt(70);
//				int sleep2 = new Random().nextInt(150);
				firstCircleMovingThread = createThread(firstDrawPanel, 30);
				secondCircleMovingThread = createThread(secondDrawPanel, 45);
				firstCircleMovingThread.start();
				secondCircleMovingThread.start();

			}

		});

		moveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//
//				firstCircleMovingThread.interrupt();
//				secondCircleMovingThread.interrupt();
				synchronized (lock) {
					lock.notify();
					lock.notify();
				}
				
			}

		});

		controlPanel.setPreferredSize(new Dimension(150, 50));
		return controlPanel;
	}

	public void moveCircle(DrawPanel drawPanel, int sleep) {
		for (int i = drawPanel.getOvalHeight(); i < drawPanel.height; i++) {
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			drawPanel.draw(i);
			synchronized (lock) {
				if (i == 200) {
					if (firstCircleMovingThread.getState() == State.WAITING
							|| secondCircleMovingThread.getState() == State.WAITING) {
						moveButton.setEnabled(true);
					}
					try {
//						lock.notify();
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private CircleMovingThread createThread(DrawPanel drawPanel, int sleep) {
		return new CircleMovingThread(drawPanel, sleep, this);
	}

}
