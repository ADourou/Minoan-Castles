package Controller;

import Model.cards.Cards;
import Model.cards.ariadneCard;
import Model.cards.minotaurCard;
import Model.cards.numberCard;
import Model.findings.RareFinding;
import Model.findings.SnakeGoddess;
import Model.findings.finding;
import Model.findings.fresco;
import Model.palace.monopati;
import Model.pawns.Pawn;
import Model.player.Player;
import Model.position.position;
import Model.position.positionWithFind;
import Model.table.table;

import View.View;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import Controller.IllegalMoveException;

/**
 * 
 */
public class controller {
	boolean endOfGame = false;
	boolean phase1over = false;
	table board;
	View v;
	AudioInputStream audioIn;
	Clip clip;

	public controller() {
		board = new table();
		initializeGame(board);
		v = new View(board);
		addallListeners();

	}
	
	/**
	 *Checks if phase 1 of each round is over
	 *@pre-condition:player throws a card or discards it
	 * 
	 */
	public void changePhase1() {
		phase1over = !phase1over;
	}
	
	

	public boolean getPhase1() {
		return phase1over;
	}
	
	
	/**
	 *Checks if game has ended
	 * 
	 */
	void checkForEndGame() {
		if (countCheckpoints() >= 4) {
			endOfGame = true;
		}
		if (board.getStack().isEmpty()) {
			endOfGame = true;
		}

	}

	/**
	 * Initializes the game and deals cards to players
	 * 
	 * @param board
	 * @param player1
	 * @param player2
	 * 
	 */
	public void initializeGame(table board) {

		for (int i = 0; i < board.getPlayer1().getPionia().size(); i++) {
			board.getPlayer1().getPionia().get(i).setPawnPlayer(board.getPlayer1());
		}

		for (int i = 0; i < board.getPlayer2().getPionia().size(); i++) {
			board.getPlayer2().getPionia().get(i).setPawnPlayer(board.getPlayer2());
		}

		for (int i = 0; i < 8; i++) {
			Cards card = board.getStack().remove(0);
			if (card != null) {
				board.getPlayer1().setCards(card);
			}

		}
		for (int a = 0; a < 8; a++) {
			Cards card = board.getStack().remove(0);
			if (card != null) {
				board.getPlayer2().setCards(card);
			}
		}
		try {
		audioIn = AudioSystem.getAudioInputStream(
				new File(this.getClass().getResource("/assets/project_assets/music/Player1.wav").getFile()));
		clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.start();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 *Changes the music depending on player's turn
	 * 
	 */
	void changeMusic() {
		if (board.getTurn()) {
			try {
				clip.close();
				audioIn = AudioSystem.getAudioInputStream(
						new File(this.getClass().getResource("/assets/project_assets/music/Player1.wav").getFile()));
				clip = AudioSystem.getClip();
				clip.open(audioIn);
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (!board.getTurn()) {
			try {
				clip.close();
				audioIn = AudioSystem.getAudioInputStream(
						new File(this.getClass().getResource("/assets/project_assets/music/Player2.wav").getFile()));
				clip = AudioSystem.getClip();
				clip.open(audioIn);
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void hacks() {
		board.getPlayer1().getHand().remove(0);
		board.getPlayer1().getHand().add(new numberCard("Mallia", 2));
		Image image1 = new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/kosmima.jpg"))
				.getImage();
		board.getPlayer1().addRareFinding((new RareFinding(50, "Δαχτυλίδι του Μίνωα", image1)));
		board.getPlayer1().getPionia().add(new Pawn("Theseas"));
		board.getPlayer1().getPionia().add(new Pawn("Theseas"));
		board.getPlayer2().getPionia().add(new Pawn("Archaeologist"));
		board.getPlayer2().getPionia().add(new Pawn("Theseas"));
		board.getMonopati()[0].getTheseis()[7].getPawn().add(board.getPlayer1().getPionia().getFirst());
		board.getMonopati()[1].getTheseis()[7].getPawn().add(board.getPlayer1().getPionia().getLast());
		board.getMonopati()[2].getTheseis()[7].getPawn().add(board.getPlayer2().getPionia().getFirst());
		board.getMonopati()[3].getTheseis()[6].getPawn().add(board.getPlayer2().getPionia().getLast());
		for (int i = 0; i < board.getPlayer1().getPionia().size(); i++) {
			board.getPlayer1().getPionia().get(i).setPawnPlayer(board.getPlayer1());
		}

		for (int i = 0; i < board.getPlayer2().getPionia().size(); i++) {
			board.getPlayer2().getPionia().get(i).setPawnPlayer(board.getPlayer2());
		}
	}

	/**
	 * Connects all action listeners to our board and players
	 */
	public void addallListeners() {

		for (int i = 0; i < board.getPlayer1().getHand().size() && board.getTurn(); i++) {
			handButtonListener h = new handButtonListener(board.getPlayer1().getHand().get(i), board.getPlayer1());
			this.v.getPlayerPane1().setHandButtonListener(h, i);
		}

		for (int i = 0; i < board.getPlayer2().getHand().size() && !board.getTurn(); i++) {
			handButtonListener h = new handButtonListener(board.getPlayer2().getHand().get(i), board.getPlayer2());
			this.v.getPlayerPane2().setHandButtonListener(h, i);
		}
		if (board.getTurn()) {
			stackButtonListener s1 = new stackButtonListener(board.getPlayer1());
			this.v.getBoard().setStackButtonListener(s1);
		} else {
			stackButtonListener s2 = new stackButtonListener(board.getPlayer2());
			this.v.getBoard().setStackButtonListener(s2);
		}
		okButtonListener ok = new okButtonListener();
		v.getEndWindow().setOkButtonListener(ok);
	}
	
	
	
	/**
	 * Action Listener for ok button of the end window
	 */
	class okButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			v.getEndWindow().dispose();
			v.dispose();

		}

	}

	/**
	 * Class for MouseListeners of the cards the player holds
	 */
	class handButtonListener implements MouseListener {

		Cards card;
		Player player;

		handButtonListener(Cards card, Player player) {
			this.card = card;
			this.player = player;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (SwingUtilities.isLeftMouseButton(e)) {
				if (card instanceof numberCard && !getPhase1()) {
					playForwardCard(player, ((numberCard) card));

				} else if (card instanceof ariadneCard && !getPhase1()) {
					playAriadneCard(player, (ariadneCard) card);

				} else if (card instanceof minotaurCard && !getPhase1()) {
					playMinotaurCard(player, (minotaurCard) card);

				}
				v.redraw();
				addallListeners();
			}

			else if (SwingUtilities.isRightMouseButton(e)) {
				discardCard(card, player);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Class for the ActionListener of the stack of the board
	 */
	/**
	 * 
	 */
	class stackButtonListener implements ActionListener {
		Player player;

		stackButtonListener(Player player) {
			this.player = player;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (player.getHand().size() < 8 && getPhase1()) {
				Cards card = board.getStack().removeFirst();
				player.setCards(card);
				board.setTurn();
				//changeMusic();
				changePhase1();
				checkForEndGame();
				winner();
				v.redraw();
				addallListeners();
			}

		}

	}
	
	
	/**
	 * Moves 2 spaces back a pawn (if possible)
	 * @param player that moves back
	 * @param pawn
	 * @param monopati
	 * @pre-condition: minotaur card played
	 * @pre-condition: pawn != Theseas else don't move and 
	 * pawn reveal
	 */
	public void move2BackListener(Player player, Pawn pawn, monopati m) {

		if (pawn.getPawnName() != "Theseas") {
			for (int i = 0; i < m.getTheseis().length; i++) {
				for (int a = 0; a < m.getTheseis()[i].getPawn().size(); a++) {
					if (m.getTheseis()[i].getPawn().get(a).getPawnPlayer().getName() == player.getName()) {
						Pawn p = m.getTheseis()[i].getPawn().remove(a);
						if (i >= 2) {
							m.getTheseis()[i - 2].getPawn().add(p);
							try {
								p.setImage(ImageIO
										.read(this.getClass()
												.getResource("/assets/project_assets/images/pionia/arch.jpg"))
										.getScaledInstance(25, 35, Image.SCALE_SMOOTH));
								p.setReveal(true);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							v.redraw();
							addallListeners();

						} else if (i == 1 || i == 0) {
							m.getTheseis()[0].getPawn().add(p);
							try {
								p.setImage(ImageIO
										.read(this.getClass()
												.getResource("/assets/project_assets/images/pionia/arch.jpg"))
										.getScaledInstance(25, 35, Image.SCALE_SMOOTH));
								p.setReveal(true);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							v.redraw();
							addallListeners();

						}

					}
				}
			}
		}

		else {
			pawn.setTired(true);
			try {
				pawn.setImage(
						ImageIO.read(this.getClass().getResource("/assets/project_assets/images/pionia/theseus.jpg"))
								.getScaledInstance(25, 35, Image.SCALE_SMOOTH));
				pawn.setReveal(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			v.redraw();
			addallListeners();
		}

	}

	/**
	 * Class for the ActionListener of the archaeologist button of the select pawn
	 * window
	 */
	class selectArchPawnListener implements ActionListener {

		Player player;
		table board;
		numberCard card;

		selectArchPawnListener(Player player, table board, numberCard card) {
			this.player = player;
			this.board = board;
			this.card = card;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < player.getPionia().size(); i++) {
				String name = player.getPionia().get(i).getPawnName();
				if (name == "Archaeologist" || name == "Archaeologist1" || name == "Archaeologist2") {
					for (int a = 0; a < 4; a++) {
						if (card.getName() == board.getMonopati()[a].getMonoName()) {
							board.getMonopati()[a].getTheseis()[0].addPawn(player.getPionia().get(i));
							player.getPionia().remove(i);
							break;
						}
					}
					break;
				}
			}
			v.redraw();
			addallListeners();
			v.questionPawn(false);

		}

	}

	/**
	 * Class for the ActionListener of the Theseas button of the select pawn window
	 */
	class selectTheseasPawnListener implements ActionListener {

		Player player;
		table board;
		numberCard card;

		selectTheseasPawnListener(Player player, table board, numberCard card) {
			this.player = player;
			this.board = board;
			this.card = card;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < player.getPionia().size(); i++) {
				String name = player.getPionia().get(i).getPawnName();
				if (name == "Theseas") {
					for (int a = 0; a < 4; a++) {
						if (card.getName() == board.getMonopati()[a].getMonoName()) {
							board.getMonopati()[a].getTheseis()[0].addPawn(player.getPionia().get(i));
							player.getPionia().remove(i);
							break;
						}
					}
					break;
				}
			}
			v.redraw();
			addallListeners();
			v.questionPawn(false);

		}
	}
	
	
	/**
	 * Action Listener for explore or destroy button in the finding window
	 */
	class ExploreFindingActionListener implements ActionListener {

		Player player;
		Pawn p;
		positionWithFind pos;

		ExploreFindingActionListener(Player player, Pawn p, positionWithFind pos) {
			this.player = player;
			this.p = p;
			this.pos = pos;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!p.getReveal()) {
				p.setReveal(true);
				if (p.getPawnName() == "Theseas") {
					try {
						p.setImage(ImageIO
								.read(this.getClass().getResource("/assets/project_assets/images/pionia/theseus.jpg"))
								.getScaledInstance(25, 35, Image.SCALE_SMOOTH));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						p.setImage(ImageIO
								.read(this.getClass().getResource("/assets/project_assets/images/pionia/arch.jpg"))
								.getScaledInstance(25, 35, Image.SCALE_SMOOTH));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			if (p.getPawnName() != "Theseas") {
				if (!pos.getFound() && pos.getFinding() instanceof RareFinding) {
					player.getRareFinding().add((RareFinding) pos.getFinding());
					player.addScore(((RareFinding) pos.getFinding()).getPoints());
					pos.setFound(true);
				} else if (!pos.getFound() && pos.getFinding() instanceof SnakeGoddess) {
					player.getStatueFound().add((SnakeGoddess) pos.getFinding());
					pos.setFound(true);
				} else if (pos.getFinding() instanceof fresco) {
					player.getFrescoFound().add((fresco) pos.getFinding());
					player.addScore(((fresco) pos.getFinding()).getPoints());
				}
			}

			else {
				if (!pos.getFound() && pos.getFinding() instanceof RareFinding && p.getNumberDestroyed() <= 3) {
					p.addFindDestroyed();
					pos.setFound(true);
				} else if (!pos.getFound() && pos.getFinding() instanceof SnakeGoddess && p.getNumberDestroyed() <= 3) {
					p.addFindDestroyed();
					pos.setFound(true);
				} else if (pos.getFinding() instanceof fresco && p.getNumberDestroyed() <= 3) {
					p.addFindDestroyed();
					pos.setFound(true);
				}
			}

			v.setExploreFindWindow(false);
			v.redraw();
			addallListeners();
		}

	}
	
	
	/**
	 * Class for not revealing the pawn in the finding window
	 */
	class ignoreFindListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			v.setExploreFindWindow(false);
			v.redraw();
			addallListeners();

		}

	}

	/**
	 * Determines who the winner is (if there is one)
	 * 
	 */
	void winner() {
		int res = 0;
		int player1points = 0;
		int player2points = 0;

		if (endOfGame) {
			for (int i = 0; i < 4; i++) {
				for (int a = 0; a < 9; a++) {
					for (int b = 0; b < board.getMonopati()[i].getTheseis()[a].getPawn().size(); b++) {
						if (board.getMonopati()[i].getTheseis()[a].getPawn().get(b).getPawnPlayer()
								.getName() == "Παίκτης 1") {
							if (board.getMonopati()[i].getTheseis()[a].getPawn().get(b).getPawnName() == "Theseas") {
								player1points = player1points + 2 * board.getMonopati()[i].getTheseis()[a].getScore();
							} else {
								player1points += board.getMonopati()[i].getTheseis()[a].getScore();
							}
						} else if (board.getMonopati()[i].getTheseis()[a].getPawn().get(b).getPawnPlayer()
								.getName() == "Παίκτης 2") {
							if (board.getMonopati()[i].getTheseis()[a].getPawn().get(b).getPawnName() == "Theseas") {
								player2points = player2points + 2 * board.getMonopati()[i].getTheseis()[a].getScore();
							} else {
								player2points += board.getMonopati()[i].getTheseis()[a].getScore();
							}
						}
					}
				}
			}
			board.getPlayer1().setScore(0);
			board.getPlayer2().setScore(0);
			board.getPlayer1().addScore(board.getPlayer1().countRareFrescoPoints());
			board.getPlayer2().addScore(board.getPlayer2().countRareFrescoPoints());
			board.getPlayer1().addScore(player1points);
			board.getPlayer2().addScore(player2points);
			board.getPlayer1().addStatueScore();
			board.getPlayer2().addStatueScore();
			if (board.getPlayer1().getScore() > board.getPlayer2().getScore()) {
				res = 1;
			} else if (board.getPlayer1().getScore() < board.getPlayer2().getScore()) {
				res = 2;
			}

			else if (board.getPlayer1().getScore() == board.getPlayer2().getScore()) {
				int rareSize1 = board.getPlayer1().getRareFinding().size();
				int rareSize2 = board.getPlayer2().getRareFinding().size();
				if (rareSize1 > rareSize2) {
					res = 1;
				} else if (rareSize2 > rareSize1) {
					res = 2;
				} else if (rareSize1 == rareSize2) {
					int fresco1 = board.getPlayer1().getFrescoFound().size();
					int fresco2 = board.getPlayer2().getFrescoFound().size();
					if (fresco1 > fresco2) {
						res = 1;
					} else if (fresco2 > fresco1) {
						res = 2;
					} else if (fresco1 == fresco2) {
						int statue1 = board.getPlayer1().getStatueFound().size();
						int statue2 = board.getPlayer2().getStatueFound().size();
						if (statue1 > statue2) {
							res = 1;
						} else if (statue2 > statue1) {
							res = 2;
						} else if (statue2 == statue1) {
							res = 3;
						}
					}
				}
			}
		}
		if (res == 1) {
			v.getEndWindow().setWinnerPoints(board.getPlayer1().getScore());
			v.getEndWindow().setWinnerString(1);
			v.redraw();
			v.setEndOfGameWindow(true);
			addallListeners();
		} else if (res == 2) {
			v.getEndWindow().setWinnerPoints(board.getPlayer2().getScore());
			v.getEndWindow().setWinnerString(2);
			v.redraw();
			v.setEndOfGameWindow(true);
			addallListeners();
		} else if (res == 3) {
			v.getEndWindow().setWinnerString(3);
			v.redraw();
			v.setEndOfGameWindow(true);
			addallListeners();
		}

	}

	/**
	 * Discards a card
	 */

	void discardCard(Cards card, Player player) {

		player.getHand().remove(card);
		changePhase1();
		v.redraw();
		addallListeners();
	}

	/**
	 * A player plays an number card and moves one space.
	 * 
	 * @param player (must be player's turn)
	 * @param card   (numberCard must be greater than before)
	 * @throws IllegalMoveException
	 */

	void playForwardCard(Player player, numberCard card) {

		for (int i = 0; i < player.getCards().size(); i++) {
			if (card.getName() == player.getCards().get(i).getName()) {
				try {
					if (card.getNumber() >= player.getCards().get(i).getNumber()) {
						player.getCards().add(card);
						player.getHand().remove(card);
						changePhase1();
						break;

					} else {
						throw new IllegalMoveException();
					}
				} catch (IllegalMoveException e) {

					System.out.println("Can't make this move");
					return;
				}

			}

		}

		boolean pawnFound = false;
		for (int a = 0; a < 4; a++) {
			if (board.getMonopati()[a].getMonoName() != card.getName()) {
				continue;
			}
			for (int i = 0; i < 9; i++) {
				if (board.getMonopati()[a].getTheseis()[i].getPawn().isEmpty()) {
					continue;
				}
				for (int b = 0; b < board.getMonopati()[a].getTheseis()[i].getPawn().size(); b++) {
					if (board.getMonopati()[a].getTheseis()[i].getPawn().get(b).getPawnPlayer().getName() == player
							.getName()) {
						if (i >= 8) {
							pawnFound = true;
							break;
						} else {
							Pawn p = board.getMonopati()[a].getTheseis()[i].getPawn().remove(b);
							if (!p.getTired()) {
								board.getMonopati()[a].getTheseis()[i + 1].addPawn(p);
								exploreFinding(player, p, board.getMonopati()[a].getTheseis()[i + 1]);
								if (p.getPawnName() == "Theseas") {
									p.setTired(false);
								}
								pawnFound = true;
								break;
							} else {
								board.getMonopati()[a].getTheseis()[i].getPawn().add(p);

							}
						}
					}
				}
				if (pawnFound)
					break;
			}

		}

		if (!pawnFound) {
			String name = card.getName();
			player.getCards().add(card);
			player.getHand().remove(card);
			changePhase1();
			for (int a = 0; a < 4; a++) {
				if (board.getMonopati()[a].getMonoName() == name) {
					for (int i = 0; i < 9; i++) {
						for (int b = 0; b < board.getMonopati()[a].getTheseis()[i].getPawn().size(); b++) {
							if (board.getMonopati()[a].getTheseis()[i].getPawn().get(b).getPawnPlayer()
									.getName() == player.getName()) {
								changePhase1();
								v.redraw();
								addallListeners();
								return;
							}
						}
					}
				}
			}

			v.getPawnWin().resetSelectPawnWindow();
			v.questionPawn(true);
			v.getPawnWin().setArchPawnButtonListener(new selectArchPawnListener(player, board, card));
			v.getPawnWin().setTheseasPawnButtonListener(new selectTheseasPawnListener(player, board, card));

		}

		v.redraw();
		addallListeners();

	}

	/**
	 * A player plays an ariadne card and moves two spaces.
	 * 
	 * @param player (must be player's turn)
	 * @param ariadne card
	 * @throws IllegalMoveException
	 */

	void playAriadneCard(Player player, ariadneCard card) {
		String name = card.getName();
		boolean cardFound = false;
		for (int w = 0; w < player.getCards().size(); w++) {
			if (name == player.getCards().get(w).getName()) {
				cardFound = true;
			}
		}
		try {
			if (!cardFound) {
				throw new IllegalMoveException();
			}
		} catch (IllegalMoveException e) {
			System.out.println("Can't make this move");
			return;
		}
		player.getHand().remove(card);
		cardFound = false;
		for (int a = 0; a < 4; a++) {
			if (board.getMonopati()[a].getMonoName() != name) {
				continue;
			}
			for (int i = 0; i < 9; i++) {
				if (board.getMonopati()[a].getTheseis()[i].getPawn().isEmpty()) {
					continue;
				}
				for (int b = 0; b < board.getMonopati()[a].getTheseis()[i].getPawn().size(); b++) {
					if (board.getMonopati()[a].getTheseis()[i].getPawn().get(b).getPawnPlayer().getName() == player
							.getName()) {
						if (i == 8) {
							cardFound = true;
							break;
						} else if (i == 7) {
							Pawn p = board.getMonopati()[a].getTheseis()[i].getPawn().remove(b);
							if (!p.getTired()) {
								board.getMonopati()[a].getTheseis()[i + 1].addPawn(p);
								exploreFinding(player, p, board.getMonopati()[a].getTheseis()[i + 1]);
							} else {
								board.getMonopati()[a].getTheseis()[i].getPawn().add(p);
							}
							cardFound = true;
							break;

						} else if (i < 7) {
							Pawn p = board.getMonopati()[a].getTheseis()[i].getPawn().remove(b);
							if (!p.getTired()) {
								board.getMonopati()[a].getTheseis()[i + 2].addPawn(p);
								exploreFinding(player, p, board.getMonopati()[a].getTheseis()[i + 2]);
							} else {
								board.getMonopati()[a].getTheseis()[i].getPawn().add(p);
							}
							cardFound = true;
							break;
						}
					}
				}
				if (cardFound)
					break;
			}

		}
		changePhase1();
		v.redraw();
		addallListeners();

	}
	
	
	/**
	 * Counts checkpoints (used in determining the end of game)
	 */
	int countCheckpoints() {
		int counter = 0;
		for (int i = 0; i < board.getMonopati().length; i++) {
			for (int a = 0; a < board.getMonopati()[i].getTheseis().length; a++) {
				for (int b = 0; b < board.getMonopati()[i].getTheseis()[a].getPawn().size(); b++) {
					if (a >= 6) {
						counter += 1;
					}
				}
			}
		}
		return counter;
	}
	
	/**
	 * Checks if a player has passed a checkpoint
	 * @param monopati
	 * @param player
	 */
	boolean checkCheckpoint(monopati mono, Player player) {
		boolean res = false;
		for (int i = 0; i < board.getMonopati().length; i++) {
			if (board.getMonopati()[i].getMonoName() == mono.getMonoName()) {
				monopati m = board.getMonopati()[i];
				for (int a = 0; a < m.getTheseis()[6].getPawn().size(); a++) {
					if (m.getTheseis()[6].getPawn().get(a).getPawnPlayer().getName() == player.getName()) {
						res = true;
					}
				}
			}
		}
		return res;
	}

	/**
	 * Moves player two spaces back unless pawn=Theseas or reached checkpoint.
	 * 
	 * @param player
	 * @param card
	 * @post1 moves pawn two spaces back (archaeologist)
	 * @post2 if pawn=Theseas, doesn't move next round
	 * 
	 */
	void playMinotaurCard(Player player, minotaurCard card) {
		monopati m = null;
		String palace_name = card.getName();
		player.getHand().remove(card);
		changePhase1();
		for (int i = 0; i < 4; i++) {
			if (board.getMonopati()[i].getMonoName() == palace_name) {
				m = board.getMonopati()[i];
				break;
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int a = 0; a < m.getTheseis()[i].getPawn().size(); a++) {
				if (m.getTheseis()[i].getPawn().get(a).getPawnPlayer().getName() != player.getName() && i < 6) {
					move2BackListener(m.getTheseis()[i].getPawn().get(a).getPawnPlayer(),
							m.getTheseis()[i].getPawn().get(a), m);
					v.redraw();
					addallListeners();
				}
			}
		}

	}

	/**
	 * Explores or destroys the finding (if possible) or photographs a fresco.
	 * 
	 * @param finding  (if finding is rare, must not been taken by another player)
	 * @param player
	 * @param position with a finding
	 * @post1 explores finding (or photographs fresco) if pawn is archaeologist
	 * @post2 destroys finding if pawn is Theseas
	 */
	void exploreFinding(Player player, Pawn pawn, position p) {

		if (p instanceof positionWithFind && !((positionWithFind) p).getFound()) {
			v.setExploreFindWindow(true);
			v.getExploreFinding()
					.setExploreFindButtonListener(new ExploreFindingActionListener(player, pawn, (positionWithFind) p));
			v.getExploreFinding().setKeepQuestButtonListener(new ignoreFindListener());
		}

	}

	public static void main(String args[]) {

		controller c = new controller();

	}

}
