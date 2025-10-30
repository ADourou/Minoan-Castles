package Model.palace;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Model.pawns.Pawn;
import Model.position.position;
import Model.position.positionWithFind;

/**
 * Class for palace path 
 */
public class monopati {
	String monopati_name;
	position [] theseis=new position [9];
	
	/**
	 * Checks if checkpoint is reached
	 */
	public boolean reachedCheckpoint() {
		if(!(this.theseis[6].getPawn().isEmpty())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Constructor
	 * @param monopati_name
	 */
	public monopati(String monopati_name){
		this.monopati_name=monopati_name;
		if(monopati_name=="Knossos") {
			position mypos=new position(-20, "Knossos");
			theseis[0]=mypos;
			positionWithFind mypos1=new positionWithFind(-15,"Knossos");
			theseis[1]=mypos1;
			position mypos2=new position(-10,"Knossos");
			theseis[2]=mypos2;
			positionWithFind mypos3=new positionWithFind(5,"Knossos");
			theseis[3]=mypos3;
			position mypos4=new position(10,"Knossos");
			theseis[4]=mypos4;
			positionWithFind mypos5=new positionWithFind(15,"Knossos");
			theseis[5]=mypos5;
			position mypos6=new position(30,"Knossos");
			theseis[6]=mypos6;
			positionWithFind mypos7=new positionWithFind(35,"Knossos");
			theseis[7]=mypos7;
			positionWithFind mypos8=new positionWithFind(50,"Knossos");
			Image image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/knossosPalace.jpg")).getImage();
			mypos8.setImage(image);
			theseis[8]=mypos8;
			
		}
		
		else if(monopati_name=="Mallia") {
			position mypos=new position(-20, "Mallia");
			theseis[0]=mypos;
			positionWithFind mypos1=new positionWithFind(-15,"Mallia");
			theseis[1]=mypos1;
			position mypos2=new position(-10,"Mallia");
			theseis[2]=mypos2;
			positionWithFind mypos3=new positionWithFind(5,"Mallia");
			theseis[3]=mypos3;
			position mypos4=new position(10,"Mallia");
			theseis[4]=mypos4;
			positionWithFind mypos5=new positionWithFind(15,"Mallia");
			theseis[5]=mypos5;
			position mypos6=new position(30,"Mallia");
			theseis[6]=mypos6;
			positionWithFind mypos7=new positionWithFind(35,"Mallia");
			theseis[7]=mypos7;
			positionWithFind mypos8=new positionWithFind(50,"Mallia");
			Image image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/maliaPalace.jpg")).getImage();
			mypos8.setImage(image);
			theseis[8]=mypos8;
		}
		else if(monopati_name=="Zakros") {
			position mypos=new position(-20, "Zakros");
			theseis[0]=mypos;
			positionWithFind mypos1=new positionWithFind(-15,"Zakros");
			theseis[1]=mypos1;
			position mypos2=new position(-10,"Zakros");
			theseis[2]=mypos2;
			positionWithFind mypos3=new positionWithFind(5,"Zakros");
			theseis[3]=mypos3;
			position mypos4=new position(10,"Zakros");
			theseis[4]=mypos4;
			positionWithFind mypos5=new positionWithFind(15,"Zakros");
			theseis[5]=mypos5;
			position mypos6=new position(30,"Zakros");
			theseis[6]=mypos6;
			positionWithFind mypos7=new positionWithFind(35,"Zakros");
			theseis[7]=mypos7;
			positionWithFind mypos8=new positionWithFind(50,"Zakros");
			Image image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/zakrosPalace.jpg")).getImage();
			mypos8.setImage(image);
			theseis[8]=mypos8;
		}
		
		else if(monopati_name=="Faistos") {
			position mypos=new position(-20, "Faistos");
			theseis[0]=mypos;
			positionWithFind mypos1=new positionWithFind(-15,"Faistos");
			theseis[1]=mypos1;
			position mypos2=new position(-10,"Faistos");
			theseis[2]=mypos2;
			positionWithFind mypos3=new positionWithFind(5,"Faistos");
			theseis[3]=mypos3;
			position mypos4=new position(10,"Faistos");
			theseis[4]=mypos4;
			positionWithFind mypos5=new positionWithFind(15,"Faistos");
			theseis[5]=mypos5;
			position mypos6=new position(30,"Faistos");
			theseis[6]=mypos6;
			positionWithFind mypos7=new positionWithFind(35,"Faistos");
			theseis[7]=mypos7;
			positionWithFind mypos8=new positionWithFind(50,"Faistos");
			Image image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/phaistosPalace.jpg")).getImage();
			mypos8.setImage(image);
			theseis[8]=mypos8;
		}
	}
	
	
	/**
	 * @return palace name
	 */
	public String getMonoName() {
		return this.monopati_name;
	}
	
	public position[] getTheseis() {
		
		return this.theseis;
	}
}
