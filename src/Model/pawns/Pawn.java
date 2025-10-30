package Model.pawns;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Model.player.Player;

/**
 * Class Pawn, includes archaeologists and Theseas
 */
public class Pawn {
	
	String name;
	Image image;
	Player player;
	boolean tired=false;
	boolean revealed=false;
	int numberfindDestroyed=0;
	
	
	public int getNumberDestroyed()
	{
		return this.numberfindDestroyed;
	}
	
	/**
	 * Increases every time Theseas destroys a finding
	 * @pre-condition: pawn must be Theseas
	 */
	public void addFindDestroyed() {
		this.numberfindDestroyed+=1;
	}
	
	/**
	 * Sets true if pawn is revealed
	 * @pre-condition: pawn must be revealed
	 */
	public void setReveal(boolean n) {
		revealed=n;
	}
	
	public boolean getReveal() {
		return this.revealed;
	}
	
	/**
	 * Sets true if pawn tired
	 * @pre-condition: pawn must Theseas
	 */
	public void setTired(boolean m) {
		tired=m;
	}
	
	public boolean getTired() {
		return this.tired;
	}
	
	
	/**
	 * Constructor
	 * @param name
	 * @param image
	 */
	public Pawn(String name){
		this.name=name;
		try {
			this.image=ImageIO.read(this.getClass().getResource("/assets/project_assets/images/pionia/question.jpg")).getScaledInstance(25, 35, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @return archaeologist or Theseas
	 */
	public String getPawnName() {return this.name;}
	
	public void setImage(Image image) {this.image=image;}
	
	public Image getImage() { return this.image;}
	
	public void setPawnPlayer(Player player) {
		this.player=player;
	}
	
	public Player getPawnPlayer() {
		return this.player;
	}

}
