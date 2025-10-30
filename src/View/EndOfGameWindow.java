package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EndOfGameWindow extends JFrame{
	
	JButton ok;
	int winner;
	JLabel winLabel;
	int points;
	
	public void setWinnerString(int winner) {
		this.winner=winner;
		resetEndOfGameWindow();
		
	}
	
	public int getWinnerPoints() {
		return points;
	}
	
	public void setWinnerPoints(int points) {
		this.points=points;
		resetEndOfGameWindow();
	}
	

	EndOfGameWindow() {

		setTitle("Τέλος παιχνιδιού");
		setBounds(200, 100, 370, 90); // x, y, width, height
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setAlwaysOnTop(true);
		winLabel=new JLabel();
		if(winner==1) {
		winLabel.setText("Τέλος παιχνιδιού! Νικητής είναι ο παίκτης 1 με "+ getWinnerPoints()+" πόντους.");
		}
		else if(winner==2) {
			winLabel.setText("Τέλος παιχνιδιού! Νικητής είναι ο παίκτης 2 με "+ getWinnerPoints()+" πόντους.");
		}
		
		else if(winner==3) {
			winLabel.setText("Τέλος παιχνιδιού! Έχουμε ισοπαλία.");
		}
		winLabel.setVisible(true);
		winLabel.setPreferredSize(new Dimension(320,100));
		add(winLabel);
		
		ok = new JButton();
		ok.setText("OK");
		add(ok);
		setVisible(false);

	}

	public void setOkButtonListener(ActionListener leftClick) {
		ok.addActionListener(leftClick);
	}

	

	public void resetEndOfGameWindow() {
		this.getContentPane().removeAll();
		winLabel=new JLabel();
		if(winner==1) {
		winLabel.setText("Τέλος παιχνιδιού! Νικητής είναι ο παίκτης 1 με "+ getWinnerPoints()+" πόντους.");
		}
		else if(winner==2) {
			winLabel.setText("Τέλος παιχνιδιού! Νικητής είναι ο παίκτης 2 με "+ getWinnerPoints()+" πόντους.");
		}
		
		else if(winner==3) {
			winLabel.setText("Τέλος παιχνιδιού! Έχουμε ισοπαλία.");
		}
		add(winLabel);
		ok = new JButton();
		ok.setText("OK");
		add(ok);
		validate();
		setVisible(false);
	}
}


