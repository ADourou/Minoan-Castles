package Model.position;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Model.findings.finding;
import Model.pawns.Pawn;

public class positionWithFind extends position{
	
	String palace;
	Image image;
	finding Find;
	ArrayList <Pawn> pawns=new ArrayList <Pawn>();
	boolean findingFound=false;
	
	public boolean getFound() {return findingFound;}
	public void setFound(boolean m) {findingFound=m;}
	
	public void addPawn(Pawn pawn) {
		this.pawns.add(pawn);
	}
	
	public ArrayList <Pawn> getPawn(){
		return this.pawns;
	}
	
	public positionWithFind(int score, String palace){
		super(score, palace);
		if(palace=="Knossos") {
			this.image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/knossos2.jpg")).getImage();
		}
		
		else if(palace=="Mallia") {
			this.image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/malia2.jpg")).getImage();
		}
		else if(palace=="Zakros") {
			this.image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/zakros2.jpg")).getImage();
		}
		
		else if(palace=="Faistos") {
			this.image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/phaistos2.jpg")).getImage();
		}
	}
	
	public finding getFinding() {
		return this.Find;
	}
	
	public void setFinding(finding f) {
		this.Find=f;
	}
	
	public void setImage(Image im) {
		this.image=im;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public int getScore() {
		return this.score;
	}

}
