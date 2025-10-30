package Model.cards;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Subclass of special cards for the minotaur card
 */
public class minotaurCard extends Cards{
	
	Image front;
	String palaceName;
	
	public Image getImage() {return this.front;}
	
	/**
	 * Constructor
	 * @param palace name
	 */
	public minotaurCard(String name){
		super();
		this.palaceName=name;
		if(palaceName=="Knossos") {
			front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossosMin.jpg")).getImage(); 
		}
		else if(palaceName=="Faistos") {
			front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistosMin.jpg")).getImage();
		}
		else if(palaceName=="Mallia") {
			front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/maliaMin.jpg")).getImage();
		}
		else if(palaceName=="Zakros") {
			front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakrosMin.jpg")).getImage();
		}
		else {
			System.out.println(name+" mino doesn't exist");
		}
		
		
	}
	
	public String getName() {return this.palaceName;}

}
