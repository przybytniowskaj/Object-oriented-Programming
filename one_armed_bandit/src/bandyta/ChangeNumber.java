package bandyta;

import javax.swing.JTextField;

public class ChangeNumber extends Thread {

	private Frame frame;
	private JTextField textField;

	public ChangeNumber(Frame frame, JTextField textField) {
		super();
		this.frame = frame;
		this.textField = textField;
	}

	public void run() {
		frame.fillTextField(textField);
	}

}
