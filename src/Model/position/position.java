package Model.position;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Model.pawns.Pawn;

/**
 * Describes a position in a path
 */
public class position {
	
	int score;
	String palace;
	Image image;
	ArrayList <Pawn> pawns=new ArrayList <Pawn>();
	
	public void addPawn(Pawn pawn) {
		this.pawns.add(pawn);
	}
	public ArrayList <Pawn> getPawn(){
		return this.pawns;
	}
	
	/**
	 * Constructor
	 * @param score
	 * @param palace
	 */
	public position(int score, String palace){
		this.score=score;
		this.palace=palace;
		if(palace=="Knossos") {
			this.image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/knossos.jpg")).getImage();
		}
		
		else if(palace=="Mallia") {
			this.image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/malia.jpg")).getImage();
		}
		else if(palace=="Zakros") {
			this.image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/zakros.jpg")).getImage();
		}
		
		else if(palace=="Faistos") {
			this.image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/paths/phaistos.jpg")).getImage();
		}
		
	}
	
	public void setImage(Image image) {
		this.image=image;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public int getScore() {
		return this.score;
	}
	
}
