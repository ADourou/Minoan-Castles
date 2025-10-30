package Model.cards;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Abstract class for cards
 */
public abstract class Cards {
	
	 Image backImage;

	 Cards(){
		 
		 backImage=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/backCard.jpg")).getImage(); 
	 }
	 
	 public Image getImage() {
		 return this.backImage;
	 }
	 
	 

}
