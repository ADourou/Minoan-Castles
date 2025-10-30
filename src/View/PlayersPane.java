package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Controller.controller;
import Model.cards.ariadneCard;
import Model.cards.minotaurCard;
import Model.cards.numberCard;
import Model.findings.RareFinding;
import Model.player.Player;

/**
 * Class for the player's pane in the board
 */
public class PlayersPane extends JLayeredPane {
	JLayeredPane layPanel;
	JPanel buttonPanel;
	ArrayList<JButton> handButton = new ArrayList<JButton>();

	/**
	 * Constructor
	 * 
	 * @param player
	 */
	PlayersPane(Player player) {
		layPanel = new JLayeredPane();
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JPanel cardButPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		cardButPanel.setPreferredSize(new Dimension(600, 100));
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		for (int i = 0; i < player.getHand().size(); i++) {
			JButton cardButton = new JButton();
			cardButton.setPreferredSize(new Dimension(65, 90));
			cardButton.setVisible(true);
			if (player.getHand().get(i) instanceof numberCard) {
				Image resIm = ((numberCard) player.getHand().get(i)).getImage().getScaledInstance(65, 90,
						Image.SCALE_SMOOTH);
				cardButton.setIcon(new ImageIcon(resIm));
			} else if (player.getHand().get(i) instanceof ariadneCard) {
				Image resIm = ((ariadneCard) player.getHand().get(i)).getImage().getScaledInstance(65, 90,
						Image.SCALE_SMOOTH);
				cardButton.setIcon(new ImageIcon(resIm));
			} else if (player.getHand().get(i) instanceof minotaurCard) {
				Image resIm = ((minotaurCard) player.getHand().get(i)).getImage().getScaledInstance(65, 90,
						Image.SCALE_SMOOTH);
				cardButton.setIcon(new ImageIcon(resIm));
			}
			handButton.add(cardButton);

			cardButPanel.add(cardButton);

		}
		leftPanel.add(cardButPanel);

		JLabel playLabel = new JLabel();
		playLabel.setText(player.getName() + " - Διαθέσιμα πιόνια: " + player.countPawns());
		playLabel.setVisible(true);

		playLabel.setBounds(0, 0, 700, 20);
		playLabel.setOpaque(true);
		leftPanel.add(playLabel);
		Dimension leftSize = leftPanel.getPreferredSize();
		leftPanel.setSize(leftSize);
		buttonPanel.add(leftPanel);

		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

		JPanel middleButton = new JPanel();
		middleButton.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		for (int a = 0; a < 4; a++) {
			JLabel cardlabel = new JLabel();
			if (a == 0) {
				cardlabel.setText("Κνωσσός");
				cardlabel.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 2));
				if (player.getLastNumPlayed("Knossos") != null) {
					Image resIm = player.getLastNumPlayed("Knossos").getImage().getScaledInstance(65, 80,
							Image.SCALE_SMOOTH);
					cardlabel.setIcon(new ImageIcon(resIm));
				}
			}

			else if (a == 1) {
				cardlabel.setText("Μάλλια");
				cardlabel.setBorder(BorderFactory.createLineBorder(new Color(160, 142, 35), 2));
				if (player.getLastNumPlayed("Mallia") != null) {
					Image resIm = player.getLastNumPlayed("Mallia").getImage().getScaledInstance(65, 80,
							Image.SCALE_SMOOTH);
					cardlabel.setIcon(new ImageIcon(resIm));
				}
			} else if (a == 2) {
				cardlabel.setText("Φαιστός");
				cardlabel.setBorder(BorderFactory.createLineBorder(new Color(157, 0, 255), 2));
				if (player.getLastNumPlayed("Faistos") != null) {
					Image resIm = player.getLastNumPlayed("Faistos").getImage().getScaledInstance(65, 80,
							Image.SCALE_SMOOTH);
					cardlabel.setIcon(new ImageIcon(resIm));
				}
			} else if (a == 3) {
				cardlabel.setText("Ζάκρος");
				cardlabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 2));
				if (player.getLastNumPlayed("Zakros") != null) {
					Image resIm = player.getLastNumPlayed("Zakros").getImage().getScaledInstance(65, 80,
							Image.SCALE_SMOOTH);
					cardlabel.setIcon(new ImageIcon(resIm));
				}
			}


			cardlabel.setPreferredSize(new Dimension(65, 80));
			cardlabel.setVisible(true);
			middleButton.add(cardlabel);

		}
		middlePanel.add(middleButton);

		JPanel rarePanel = new JPanel();
		rarePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 10));

		JLabel rarelabel0 = new JLabel();
		ImageIcon initial0 = new ImageIcon(
				this.getClass().getResource("/assets/project_assets/images/findings/diskos.jpg"));
		Image resizedImage0 = initial0.getImage().getScaledInstance(35, 25, Image.SCALE_SMOOTH);
		rarelabel0.setIcon(new ImageIcon(resizedImage0));
		if (player.checkRare("Δίσκος της Φαιστού")) {
			rarelabel0.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 0), 2));
		} else {
			rarelabel0.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 2));
		}
		rarePanel.add(rarelabel0);

		JLabel rarelabel1 = new JLabel();
		ImageIcon initial1 = new ImageIcon(
				this.getClass().getResource("/assets/project_assets/images/findings/kosmima.jpg"));
		Image resizedImage1 = initial1.getImage().getScaledInstance(35, 25, Image.SCALE_SMOOTH);
		rarelabel1.setIcon(new ImageIcon(resizedImage1));
		if (player.checkRare("Κόσμημα Μαλλίων")) {
			rarelabel1.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 0), 2));
		} else {
			rarelabel1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 2));
		}
		rarePanel.add(rarelabel1);
		

		JLabel rarelabel2 = new JLabel();
		ImageIcon initial2 = new ImageIcon(
				this.getClass().getResource("/assets/project_assets/images/findings/ring.jpg"));
		Image resizedImage2 = initial2.getImage().getScaledInstance(35, 25, Image.SCALE_SMOOTH);
		rarelabel2.setIcon(new ImageIcon(resizedImage2));
		if (player.checkRare("Δαχτυλίδι του Μίνωα")) {
			rarelabel2.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 0), 2));
		} else {
			rarelabel2.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 2));
		}
		rarePanel.add(rarelabel2);

		JLabel rarelabel3 = new JLabel();
		ImageIcon initial3 = new ImageIcon(
				this.getClass().getResource("/assets/project_assets/images/findings/ruto.jpg"));
		Image resizedImage3 = initial3.getImage().getScaledInstance(35, 25, Image.SCALE_SMOOTH);
		rarelabel3.setIcon(new ImageIcon(resizedImage3));
		if (player.checkRare("Ρυτό Ζάκρου")) {
			rarelabel3.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 0), 2));
		} else {
			rarelabel3.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 2));
		}
		rarePanel.add(rarelabel3);

		middlePanel.add(rarePanel);
		Dimension middleSize = middlePanel.getPreferredSize();
		leftPanel.setSize(middleSize);
		buttonPanel.add(middlePanel);
		buttonPanel.add(Box.createHorizontalStrut(25));

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		JLabel scoreLabel = new JLabel();
		scoreLabel.setText("Το σκορ μου: " + player.getScore() + " πόντοι");
		scoreLabel.setVisible(true);
		rightPanel.add(scoreLabel);

		rightPanel.add(Box.createVerticalStrut(15));

		JButton cardButton = new JButton();
		cardButton.setPreferredSize(new Dimension(160, 25));
		cardButton.setText("Οι Τοιχογραφίες μου");
		cardButton.setVisible(true);
		rightPanel.add(cardButton);

		rightPanel.add(Box.createVerticalStrut(15));

		JLabel statueLabel = new JLabel();
		statueLabel.setText("Αγαλματάκια: " + player.getStatueFound().size());
		statueLabel.setVisible(true);
		rightPanel.add(statueLabel);

		buttonPanel.add(rightPanel);

		this.setLayout(null);
		buttonPanel.setBounds(10, 10, 1170, 150);
		layPanel.setBounds(0, 0, 1190, 170);
		layPanel.add(buttonPanel, JLayeredPane.DEFAULT_LAYER);

		JLabel goddess = new JLabel();
		ImageIcon initgod = new ImageIcon(
				this.getClass().getResource("/assets/project_assets/images/findings/snakes.jpg"));
		Image resizedGod = initgod.getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH);
		goddess.setIcon(new ImageIcon(resizedGod));
		goddess.setBounds(1130, 120, 200, 40);
		layPanel.add(goddess, JLayeredPane.PALETTE_LAYER);
		this.setPreferredSize(new Dimension(1200, 170));

		this.setBorder(BorderFactory.createLineBorder(new Color(255, 165, 0), 3));
		this.add(layPanel);
	}

	public void setHandButtonListener(MouseListener leftClick, int i) {
		handButton.get(i).addMouseListener(leftClick);
	}
	
	
}
