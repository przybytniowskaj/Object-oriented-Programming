package bandyta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame {

	private JTextField redText;
	private JTextField greenText;
	private JTextField blueText;
	private JButton apply;
	private Object lock = new Object();
	private int workingThreads = 0;
	private Color color;
	private PaintingPanel painting = new PaintingPanel();
	

	public Frame() {
		super();
		setSize(new Dimension(700, 500));
		getContentPane().setBackground(new Color(250, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jednorêki bandyta!");

		JPanel mainPanel = new JPanel();
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.X_AXIS));
		mainPanel.setBackground(new Color(0, 150, 50));

		JPanel panel = createPanelText();
//		panel.setLayout(new FlowLayout(FlowLayout.Left));
//		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
//		panel.setLayout(new BorderLayout(ALLBITS, ABORT));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel additiJPanel = new JPanel();
		additiJPanel.setPreferredSize(new Dimension(80, 0));
		mainPanel.add(panel);
		mainPanel.add(additiJPanel);
		mainPanel.setPreferredSize(new Dimension(250, 300));
		backgroundPanel.add(mainPanel);
		backgroundPanel.add(painting);
		add(backgroundPanel);
//		add(createPaintingPanel());
		setVisible(true);
	}

	private JPanel createPanelText() {
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(getForeground());
//		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		redText = new JTextField(3);
		JPanel firstLabelWithText = createTextWithLabel(Color.RED, "RED", redText);
		leftPanel.add(firstLabelWithText);
		greenText = new JTextField(3);
		JPanel secondLabelWithText = createTextWithLabel(Color.GREEN, "GREEN", greenText);
		leftPanel.add(secondLabelWithText);
		blueText = new JTextField(3);
		JPanel thirdLabelWithText = createTextWithLabel(Color.BLUE, "BLUE", blueText);
		leftPanel.add(thirdLabelWithText);
//		leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton drawLots = new JButton("Losuj");
		leftPanel.add(drawLots);
		apply = new JButton("Zastosuj");
		apply.setEnabled(false);
		leftPanel.add(apply);
		drawLots.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ChangeNumber redThread = createThread(redText);
				ChangeNumber greenThread = createThread(greenText);
				ChangeNumber blueThread = createThread(blueText);
				redThread.start();
				workingThreads++;
				greenThread.start();
				workingThreads++;
				blueThread.start();
				workingThreads++;
			}
		});
		
		apply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = Integer.parseInt(redText.getText());
				int green = Integer.parseInt(greenText.getText());
				int blue = Integer.parseInt(blueText.getText());
				Color color = new Color(red,green, blue);
				System.out.println(color);
				painting.setColor(color);
				
				
			}
			
		});

		return leftPanel;
	}


	private JPanel createTextWithLabel(Color color, String text, JTextField name) {
		JPanel panel = new JPanel();
		panel.setBackground(getForeground());
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//		panel.setBackground(Color.BLACK);
		JLabel label = new JLabel(text);
		label.setSize(new Dimension(30, 10));
		label.setBackground(color);
		label.setOpaque(true);
//		name.setText("cos");
		panel.add(label);
		panel.add(name);
//		
		return panel;
	}

	public Color getColor() {
		return color;
	}

	public void fillTextField(JTextField textField) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int color = new Random().nextInt(256);
			textField.setText(Integer.toString(color));
		}
//		
		synchronized (lock) {
			workingThreads--;
			if (workingThreads == 0) {
				apply.setEnabled(true);
				lock.notifyAll();
			}else {
				try {
					lock.wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private ChangeNumber createThread(JTextField textField) {
		return new ChangeNumber(this, textField);
	}
	
	
	private JMenuBar getMainJMenuBar() {
		JMenuBar result = new JMenuBar();

		JMenu optionsMenu = new JMenu("Options");

		JMenuItem firstOptionMenuItem = new JMenuItem("First");
		firstOptionMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// FileSystemView.getFileSystemView().getHomeDirectory()
				JFileChooser myFileChooser = new JFileChooser();

				int returnValue = myFileChooser.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = myFileChooser.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());

				}

			}
		});
		JMenuItem secondOptionMenuItem = new JMenuItem("Second");
		secondOptionMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JColorChooser jColorChooser = new JColorChooser();
				Color color = jColorChooser.showDialog(jFrame, "", new Color(1));
				workPanel.setBackground(color);
				System.out.println("Color: " + color);
			}
		});
		JMenuItem thirdOptionMenuItem = new JMenuItem("Third");
		thirdOptionMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				workPanel.setFocusable(true);
				workPanel.grabFocus();
			}
		});
		optionsMenu.add(firstOptionMenuItem);
		optionsMenu.add(secondOptionMenuItem);
		optionsMenu.add(thirdOptionMenuItem);

		result.add(optionsMenu);

		return result;
	}
	

}
