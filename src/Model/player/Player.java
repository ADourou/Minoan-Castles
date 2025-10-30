package Model.player;

import java.util.ArrayList;

import Model.cards.Cards;
import Model.cards.numberCard;
import Model.findings.RareFinding;
import Model.findings.SnakeGoddess;
import Model.findings.fresco;
import Model.pawns.Pawn;

/**
 * Class containing every data needed for each player
 */
public class Player {
	
	ArrayList<Cards> cards=new ArrayList<Cards>();
	String name;
	ArrayList<numberCard> lastPlayed=new ArrayList<numberCard>();
	int score;
	ArrayList <fresco> frescoFound=new ArrayList<fresco>();
	ArrayList <SnakeGoddess> statuesFound=new ArrayList<SnakeGoddess>();
	ArrayList <RareFinding> rareFound=new ArrayList<RareFinding>();
	ArrayList<Pawn> pionia=new ArrayList<Pawn>();
	ArrayList<Pawn> pioniaPlayed=new ArrayList<Pawn>();
	
	/**
	 * Constructor
	 */
	public Player(String name){
		this.name=name;
		Pawn mypawn=new Pawn("Archaeologist");
		pionia.add(mypawn);
		pionia.add(new Pawn("Archaeologist1"));
		pionia.add(new Pawn("Archaeologist2"));
		pionia.add(new Pawn("Theseas"));
		
		score=0;
		
	}
	
	
	/**
	 * Counts the statues collected and adds points accordingly
	 */
	public void addStatueScore() {
		if(statuesFound.size()==1) {
			this.score=this.score-20;
		}
		else if(statuesFound.size()==2) {
			this.score=this.score-15;
		}
		else if(statuesFound.size()==3) {
			this.score=this.score+10;
		}
		else if(statuesFound.size()==4) {
			this.score=this.score+15;
		}
		else if(statuesFound.size()==5) {
			this.score=this.score+30;
		}
		else if(statuesFound.size()==6) {
			this.score=this.score+50;
		}
	}
	
	
	/**
	 * Checks if a rare finding has been found by this player
	 */
	public boolean checkRare(String name) {
		for(int i=0;i<rareFound.size();i++) {
			if(rareFound.get(i).getName()==name) {
				
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Counts available pawns 
	 * @returns string of available pawns
	 */
	public String countPawns() {
		int arch=0;
		int thes=0;
		String ret;
		for(int i=0; i<pionia.size();i++) {
			if(pionia.get(i).getPawnName()=="Theseas") {
				thes+=1;
			}
			arch+=1;
		}
		if(arch==0&&thes==0) {
			ret="Κανένα";
		}
		else if(arch==0&&thes!=0) {
			ret="1 Θησέας";
		}
		else if(arch!=0&&thes==0) {
			if(arch!=1) {
				ret=arch+ " Αρχαιολόγοι";
			}
			else {
				ret=arch+ " Αρχαιολόγος";
			}
		}
		else {
			ret=arch+ " Αρχαιολόγοι και 1 Θησέας";
		}
		
		return ret;
		
	}
	
	public String getName() {return this.name;}
	
	
	/**
	 * Plays a pawn 
	 * @pre-condition: number card played
	 */
	public void playPawn(Pawn name) {
		pioniaPlayed.add(name);
		for(int i=0;i<pionia.size();i++) {
			if(name.getPawnName()==pionia.get(i).getPawnName()) {
				pionia.remove(i);
				return;
			}
		}
		
	}
	
	public ArrayList<Cards> getHand() {return this.cards;}
	
	
	public int getScore() {
		return this.score;
	}
	public void addScore(int points) {this.score=score+points;}
	
	public void setScore(int i) {
		this.score=i;
	}
	
	/**
	 * Adds points from the rare findings
	 */
	public int countRareFrescoPoints() {
		int s=0;
		for(int i=0;i<this.rareFound.size();i++) {
			s+=this.rareFound.get(i).getPoints();
		}
		for(int a=0;a<this.frescoFound.size();a++) {
			s+=this.frescoFound.get(a).getPoints();
		}
		return s;
	}
	
	public ArrayList <RareFinding> getRareFinding() {
		return this.rareFound;
	}
	public void addRareFinding(RareFinding rf) {rareFound.add(rf);}
	
	
	public ArrayList <fresco> getFrescoFound() {
		return this.frescoFound;
	}
	public void addFrescoFound(fresco f) {frescoFound.add(f);}
	
	
	public ArrayList <SnakeGoddess> getStatueFound() {
		return this.statuesFound;
	}
	
	public void addStatueFound(SnakeGoddess sg) {this.statuesFound.add(sg);}
	
	
	public ArrayList<Pawn> getPionia() {
		return this.pionia;
	}
	
	
	public ArrayList<numberCard> getCards() {
		return this.lastPlayed;
	}
	public void setCards(Cards card) {this.cards.add(card);}
	
	
	/**
	 * @param String of palace name
	 * @returns greatest last played card
	 */
	public numberCard getLastNumPlayed(String palace_name) {
		numberCard tmp=null;
		for(int i=0;i<this.lastPlayed.size();i++) {
			if(this.lastPlayed.get(i).getName()==palace_name) {
				tmp=this.lastPlayed.get(i);
			}
		}
		return tmp;
	}
	
	
	
	
}
