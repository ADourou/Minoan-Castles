package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Model.table.table;

/**
 * Creates the board pane (JLayeredPane) with the 4 paths, the stack of deck
 */
public class BoardPane extends JLayeredPane{
	JButton stackButton;
	
	/**
	 * Constructor
	 * @param board
	 */
	BoardPane(table board){
		boardBackground(board);
		createMonopatia(board);
		createStack(board);
	}
	
	
	
	/**
	 * Creates the JLayered pane with the background
	 * @param board
	 */
	void boardBackground(table board) {
		JLabel p=new JLabel();
		p.setIcon(new ImageIcon(this.getClass().getResource("/assets/project_assets/images/background.jpg")));
		p.setHorizontalAlignment(SwingConstants.CENTER); 
	    p.setVerticalAlignment(SwingConstants.CENTER);   
	    p.setBounds(0, 0, 1200, 430);
	    
	    this.setLayout(null);
	    this.add(p, JLayeredPane.DEFAULT_LAYER);
	    
		p.setVisible(true);
		this.setVisible(true);
	}
	
	
	
	/**
	 * Creates 4 paths for each anactoro
	 * @param board
	 */
	void createMonopatia(table board) {
		
		JPanel monopatiPanel=new JPanel();
		monopatiPanel.setLayout(new BoxLayout(monopatiPanel, BoxLayout.Y_AXIS));
	
		JPanel scorePanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		scorePanel.setPreferredSize(new Dimension(850, 40)); 
	    scorePanel.setMaximumSize(new Dimension(850, 40)); 
	    scorePanel.setMinimumSize(new Dimension(850, 40)); 
		scorePanel.setOpaque(false);
		for(int i=0;i<9;i++) {
			if(i==6) {
				JLabel score=new JLabel();
				score.setText("<html><p>"+board.getMonopati()[0].getTheseis()[i].getScore()+" points <br> Checkpoint! </p></html>");
				score.setPreferredSize(new Dimension(75, 40));
				scorePanel.add(score);
			}
			else {
				JLabel score=new JLabel();
				score.setText(board.getMonopati()[0].getTheseis()[i].getScore()+" points");
				score.setPreferredSize(new Dimension(75, 40));
				scorePanel.add(score);
			}
		}
		monopatiPanel.add(scorePanel);
		
		for(int anactoro=0;anactoro<4;anactoro++) {
			JPanel anactoroPanel=new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
			
			for(int i=0;i<9;i++) {
				JLabel l=new JLabel();
				if(i==8) {
					Image resizedImage = board.getMonopati()[anactoro].getTheseis()[i].getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
					l.setIcon(new ImageIcon(resizedImage));
					l.setPreferredSize(new Dimension(90,65));
					BufferedImage b=new BufferedImage(90, 65, BufferedImage.TYPE_INT_RGB);
					for(int w=0;w<board.getMonopati()[anactoro].getTheseis()[i].getPawn().size();w++) {
						Image im = board.getMonopati()[anactoro].getTheseis()[i].getPawn().get(w).getImage();
						if(w==1) {
							b.getGraphics().drawImage(resizedImage, 0, 0, null);
							b.getGraphics().drawImage(im, 5, 5, null);
							l.setIcon(new ImageIcon(b));
							
						}
						else if(w==2) {
							b.getGraphics().drawImage(im, 40, 5, null);
							l.setIcon(new ImageIcon(b));
						}
						
						
					}
				}
				else {
					Image resizedImage = board.getMonopati()[anactoro].getTheseis()[i].getImage().getScaledInstance(75, 55, Image.SCALE_SMOOTH);
					l.setIcon(new ImageIcon(resizedImage));
					l.setPreferredSize(new Dimension(75,55));
					BufferedImage b=new BufferedImage(75,55, BufferedImage.TYPE_INT_RGB);
					for(int w=0;w<board.getMonopati()[anactoro].getTheseis()[i].getPawn().size();w++) {
						Image im = board.getMonopati()[anactoro].getTheseis()[i].getPawn().get(w).getImage();
						if(w==0) {
							b.getGraphics().drawImage(resizedImage, 0, 0, this);
							b.getGraphics().drawImage(im, 5, 5, null);
							l.setIcon(new ImageIcon(b));	
							}
						else if(w==1) {
							b.getGraphics().drawImage(im, 40, 5, this);
							l.setIcon(new ImageIcon(b));
						}
						
					}
					
			}
				anactoroPanel.setOpaque(false);
				anactoroPanel.add(l);
			
			}
			monopatiPanel.add(anactoroPanel);
		}
		
	    monopatiPanel.setBounds(350, 5, 850, 370); 
	    monopatiPanel.setOpaque(false);
		monopatiPanel.setVisible(true);
		
		this.add(monopatiPanel,JLayeredPane.PALETTE_LAYER);
	}
	
	
	
	/**
	 * JButton for the deck of cards
	 * @param board
	 */
	void createStack (table board) {
		
		stackButton=new JButton();
		stackButton.setBounds(50, 150, 100, 140); 
		Image im=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/backCard.jpg")).getImage();
		Image resizedImage = im.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
		stackButton.setIcon(new ImageIcon(resizedImage));
		stackButton.setVisible(true);
		this.add(stackButton,JLayeredPane.MODAL_LAYER);
		
		JPanel infoPanel=new JPanel();
		infoPanel.setBounds(50, 310, 120, 55);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		JLabel infoCard=new JLabel();
		infoCard.setText("Available cards: "+board.getStack().size());
		infoPanel.add(infoCard);
		
		JLabel checkpoint=new JLabel();
		checkpoint.setText("Checkpoints: "+countCheckpoint(board));
		infoPanel.add(checkpoint);
		
		JLabel turn=new JLabel();
		turn.setText("Turn: "+changeTurnView(board));
		infoPanel.add(turn);
		
		this.add(infoPanel,JLayeredPane.MODAL_LAYER);
	}
	
	public void setStackButtonListener(ActionListener leftClick) {
		stackButton.addActionListener(leftClick);

	}

	int countCheckpoint(table board) {
		int checkpoint=4;
		for(int i=0;i<board.getMonopati().length;i++) {
			if(board.getMonopati()[i].reachedCheckpoint()) {
				checkpoint--;
			}
		}
		
		return checkpoint;
	}
	
	String changeTurnView(table board) {
		String player;
		if(board.getTurn()) {
			player="Παίκτης 1";
		}
		else {
			player="Παίκτης 2";
		}
		return player;
	}
	
}
	
	
	

