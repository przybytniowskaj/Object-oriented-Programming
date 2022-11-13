package ReverseEngineering2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Engineering extends JFrame {

	private DrawingPanel drawingPanel = new DrawingPanel();

	public Engineering() {
		super();
		setSize(new Dimension(700, 500));
		getContentPane().setBackground(new Color(250, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Julia Przybytniowska - ostatnie zadanie oceniane przed wakacjami!");

		add(drawingPanel);
		JMenuBar menu = new JMenuBar();
		JMenu optionsMenu = new JMenu("Options");
		JMenuItem menuItem = new JMenuItem("Set random color(ovals)");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int red = new Random().nextInt(256);
				int green = new Random().nextInt(256);
				int blue = new Random().nextInt(256);
				drawingPanel.setColor(new Color(red, green, blue));
			}

		});
		optionsMenu.add(menuItem);
		menu.add(optionsMenu);
		setJMenuBar(menu);
		;

		setVisible(true);
	}

}
