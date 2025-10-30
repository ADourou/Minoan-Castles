package Model.table;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

import Model.cards.Cards;
import Model.cards.ariadneCard;
import Model.cards.minotaurCard;
import Model.cards.numberCard;
import Model.findings.RareFinding;
import Model.findings.SnakeGoddess;
import Model.findings.fresco;
import Model.palace.monopati;
import Model.player.Player;
import Model.findings.finding;
import Model.position.*;

/**
 * Class for the board of the game
 */
public class table {
	boolean turn=true;
	Player player1=new Player("Παίκτης 1");
	Player player2=new Player("Παίκτης 2");
	monopati [] anactora= new monopati[4];
	ArrayList <Cards> stackCards=new ArrayList <Cards>();
	ArrayList <RareFinding> allRare=new ArrayList <RareFinding>();
	ArrayList<SnakeGoddess> snGod=new ArrayList<SnakeGoddess>();
	ArrayList <fresco> allFresco= new ArrayList <fresco>();
	ArrayList <finding> allfinds=new ArrayList <finding>();
	
	public monopati[] getMonopati() {
		return this.anactora;
	}
	
	public boolean getTurn() {return this.turn;}
	
	public void setTurn() {
		this.turn=!turn;
	}
	
	/**
	 * Creates all the 20 findings of the game and puts
	 * them into ArrayLists and shuffles them (contributes to initializing the game)
	 */
	void createFindings() {
		Image image0=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/diskos.jpg")).getImage();
		Image image1=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/kosmima.jpg")).getImage();
		Image image2=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/ring.jpg")).getImage();
		Image image3=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/ruto.jpg")).getImage();
		RareFinding e0= new RareFinding(35, "Δίσκος της Φαιστού",  image0);
		RareFinding e1= new RareFinding(25, "Κόσμημα Μαλλίων",  image1);
		RareFinding e2= new RareFinding(25, "Δαχτυλίδι του Μίνωα",  image2);
		RareFinding e3= new RareFinding(25, "Ρυτό Ζάκρου",  image3);
		this.allRare.add(e0);
		this.allRare.add(e1);
		this.allRare.add(e2);
		this.allRare.add(e3);
		this.allfinds.add(e0);
		this.allfinds.add(e1);
		this.allfinds.add(e2);
		this.allfinds.add(e3);
		
		for (int i=0;i<10;i++) {
			SnakeGoddess e=new SnakeGoddess();
			this.snGod.add(e);
			this.allfinds.add(e);
		}
		
		Image fr0=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/fresco1_20.jpg")).getImage();
		Image fr1=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/fresco2_20.jpg")).getImage();
		Image fr2=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/fresco3_15.jpg")).getImage();
		Image fr3=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/fresco4_20.jpg")).getImage();
		Image fr4=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/fresco5_15.jpg")).getImage();
		Image fr5=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/fresco6_15.jpg")).getImage();
		
		fresco f0=new fresco(20, fr0);
		fresco f1=new fresco(20, fr1);
		fresco f2=new fresco(15, fr2);
		fresco f3=new fresco(20, fr3);
		fresco f4=new fresco(20, fr4);
		fresco f5=new fresco(15, fr5);
		
		this.allFresco.add(f0);
		this.allFresco.add(f1);
		this.allFresco.add(f2);
		this.allFresco.add(f3);
		this.allFresco.add(f4);
		this.allFresco.add(f5);
		this.allfinds.add(f0);
		this.allfinds.add(f1);
		this.allfinds.add(f2);
		this.allfinds.add(f3);
		this.allfinds.add(f4);
		this.allfinds.add(f5);
		
		Collections.shuffle(allfinds);
	}
	
	/**
	 * Creates the monopatia of the game
	 */
	public void setMonopatia() {
		monopati knossos=new monopati("Knossos");
		anactora[0]=knossos;
		monopati mallia=new monopati("Mallia");
		anactora[1]=mallia;
		monopati phaistos=new monopati("Faistos");
		anactora[2]=phaistos;
		monopati zakros=new monopati("Zakros");
		anactora[3]=zakros;
		
	}
	
	
	/**
	 * Draws the findings into the right positions in the table
	 */
	public void setFinding() {
		
		for(int i=0;i<4;i++) {
			positionWithFind met= (positionWithFind) anactora[i].getTheseis()[1];
			met.setFinding(allfinds.get(0+5*i));
			positionWithFind met1= (positionWithFind) anactora[i].getTheseis()[3];
			met1.setFinding(allfinds.get(1+5*i));
			positionWithFind met2= (positionWithFind) anactora[i].getTheseis()[5];
			met2.setFinding(allfinds.get(2+5*i));
			positionWithFind met3= (positionWithFind) anactora[i].getTheseis()[7];
			met3.setFinding(allfinds.get(3+5*i));
			positionWithFind met4= (positionWithFind) anactora[i].getTheseis()[8];
			met4.setFinding(allfinds.get(4+5*i));
			
		}
		
	}
	
	
	/**
	 * Sets the stack of cards and shuffles it
	 */
	public void setStack() {
		
		for(int a=0;a<2;a++) {
			for(int i=1;i<=10;i++) {
				numberCard mycard=new numberCard("Knossos",i);
				stackCards.add(mycard);
			}
			minotaurCard minot=new minotaurCard("Knossos");
			stackCards.add(minot);
		}
		
		for(int a=0;a<2;a++) {
			for(int i=1;i<=10;i++) {
				numberCard mycard=new numberCard("Faistos",i);
				stackCards.add(mycard);
			}
			minotaurCard minot=new minotaurCard("Faistos");
			stackCards.add(minot);
		}
		
		for(int a=0;a<2;a++) {
			for(int i=1;i<=10;i++) {
				numberCard mycard=new numberCard("Mallia",i);
				stackCards.add(mycard);
			}
			minotaurCard minot=new minotaurCard("Mallia");
			stackCards.add(minot);
		}
		
		for(int a=0;a<2;a++) {
			for(int i=1;i<=10;i++) {
				numberCard mycard=new numberCard("Zakros",i);
				stackCards.add(mycard);
			}
			minotaurCard minot=new minotaurCard("Zakros");
			stackCards.add(minot);
		}
		
		for(int b=0;b<3;b++) {
			ariadneCard ar=new ariadneCard("Knossos");
			stackCards.add(ar);
		}
		
		for(int b=0;b<3;b++) {
			ariadneCard ar=new ariadneCard("Faistos");
			stackCards.add(ar);
		}
		
		for(int b=0;b<3;b++) {
			ariadneCard ar=new ariadneCard("Mallia");
			stackCards.add(ar);
		}
		
		for(int b=0;b<3;b++) {
			ariadneCard ar=new ariadneCard("Zakros");
			stackCards.add(ar);
		}
		
		Collections.shuffle(stackCards);
		
	}
	/**
	}
	 * Constructor (contributes to initializing the game)
	 * calls the above methods
	 */
	public table() {
		setMonopatia();
		setStack();
		createFindings();
		setFinding();
	}
	
	public ArrayList<Cards> getStack(){
		return this.stackCards;
	}
	
	
	/**
	 * @return Player1
	 */
	public Player getPlayer1() {return this.player1;}
	
	
	/**
	 * @return Player2
	 */
	public Player getPlayer2() {return this.player2;}
}
