package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import Model.player.Player;
import Model.table.table;

public class View extends JFrame {
	
	BoardPane bp;
	table board;
	PlayersPane playerp1;
	PlayersPane playerp2;
	SelectPawn s;
	ExploreFinding e;
	EndOfGameWindow end;
	
	public PlayersPane getPlayerPane1() {return this.playerp1;}
	public PlayersPane getPlayerPane2() {return this.playerp2;}
	public SelectPawn getPawnWin() {return s;}
	public ExploreFinding getExploreFinding() {return e;}
	public EndOfGameWindow getEndWindow() {return end;}
	
	public BoardPane getBoard() {
		return this.bp;
	}
	
	public View(table board){
		this.s=new SelectPawn();
		this.e=new ExploreFinding();
		this.end=new EndOfGameWindow();
		this.board=board;
		bp=new BoardPane(board);
		playerp1=new PlayersPane(board.getPlayer1());
		playerp2=new PlayersPane(board.getPlayer2());
		playerp2.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 0), 3));
		setTitle ("Αναζητώντας τα χαμένα Μινωικά Ανάκτορα");
		setBounds(200,50,1200,770); //x, y, width, height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(bp,BorderLayout.CENTER);
		add(playerp1,BorderLayout.NORTH);
		add(playerp2,BorderLayout.SOUTH);
		validate();
		setVisible(true);
		
	}
	
	public void redraw() {
		this.getContentPane().removeAll();
		bp=new BoardPane(board);
		playerp1=new PlayersPane(board.getPlayer1());
		playerp2=new PlayersPane(board.getPlayer2());
		playerp2.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 0), 3));
		add(bp,BorderLayout.CENTER);
		add(playerp1,BorderLayout.NORTH);
		add(playerp2,BorderLayout.SOUTH);
		validate();
		setVisible(true);
	}
	
	public void questionPawn(boolean m) {
		s.setVisible(m);
	}
	
	public void setExploreFindWindow(boolean n) {
		e.setVisible(n);
	}
	
	public void setEndOfGameWindow(boolean e) {
		end.setVisible(e);
	}

	
	
}
