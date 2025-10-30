package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ExploreFinding extends JFrame{
	JButton find;
	JButton arch;
	

	
	ExploreFinding(){
		
	setTitle ("Ανασκαφή ή διατήρηση κρυμμένης ταυτότητας");
	setBounds(200,100,250,135); //x, y, width, height
	setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
	this.setAlwaysOnTop(true);
	arch=new JButton();
	arch.setText("Διατήρηση ερωτηματικού");
	add(arch);
	find=new JButton();
	find.setText("Ανασκαφή ή καταστροφή");
	add(find);
	setVisible(false);

	}
	
	public void setKeepQuestButtonListener(ActionListener leftClick) {
		arch.addActionListener(leftClick);
	}
	
	public void setExploreFindButtonListener(ActionListener leftClick) {
		find.addActionListener(leftClick);
	}
	
	public void resetExploreFindWindow() {
		this.getContentPane().removeAll();
		arch=new JButton();
		arch.setText("Διατήρηση ερωτηματικού");
		add(arch);
		find=new JButton();
		find.setText("Ανασκαφή ή καταστροφή");
		add(find);
		setVisible(false);
		
	}
}
