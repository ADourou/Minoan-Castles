package Model.cards;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Subclass of special cards, for Ariadne card
 */
public class ariadneCard extends Cards {
	
	String palace_name;
	Image front;
	/**
	 * Constructor
	 * @param name of palace
	 */
	public ariadneCard(String name){
		
		super();
		this.palace_name=name;
		if(palace_name=="Knossos") {
			front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossosAri.jpg")).getImage(); 
		}
		else if(palace_name=="Faistos") {
			front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistosAri.jpg")).getImage();
		}
		else if(palace_name=="Mallia") {
			front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/maliaAri.jpg")).getImage();
		}
		else if(palace_name=="Zakros") {
			front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakrosAri.jpg")).getImage();
		}
		else {
			System.out.println(name+" ariadne doesn't exist");
		}
		
		
	}
	
	public String getName() {return this.palace_name;}
	
	public Image getImage() {return this.front;}

}
