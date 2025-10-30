package View;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SelectPawn extends JFrame {
	JButton Theseas;
	JButton arch;

	SelectPawn() {

		setTitle("Διάλεξε πιόνι");
		setBounds(200, 100, 250, 90); // x, y, width, height
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		this.setAlwaysOnTop(true);
		arch = new JButton();
		arch.setText("Αρχαιολόγος");
		add(arch);
		Theseas = new JButton();
		Theseas.setText("Θησέας");
		add(Theseas);
		setVisible(false);

	}

	public void setArchPawnButtonListener(ActionListener leftClick) {
		arch.addActionListener(leftClick);
	}

	public void setTheseasPawnButtonListener(ActionListener leftClick) {
		Theseas.addActionListener(leftClick);
	}

	public void resetSelectPawnWindow() {
		this.getContentPane().removeAll();
		arch = new JButton();
		arch.setText("Αρχαιολόγος");
		add(arch);
		Theseas = new JButton();
		Theseas.setText("Θησέας");
		add(Theseas);
		setVisible(false);
	}
}
