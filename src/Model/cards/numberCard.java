package Model.cards;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Subclass of Cards, for the palace number cards
 */
public class numberCard extends Cards{
	
	String palace_name;
	int number;
	Image front;
	
	/**
	 * Constructor
	 * @param palace_name
	 * @param number
	 * @param image
	 * @param cardPosition
	 */
	
	public Image getImage() {return this.front;}
	
	public numberCard(String palace_name, int number){
		
		super();
		this.palace_name=palace_name;
		this.number=number;
		switch (number) {
		
		case 1:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos1.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos1.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia1.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros1.jpg")).getImage();
			}
			break;
			
		case 2:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos2.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos2.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia2.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros2.jpg")).getImage();
			}
			break;
			
		case 3:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos3.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos3.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia3.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros3.jpg")).getImage();
			}
			break;
			
		case 4:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos4.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos4.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia4.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros4.jpg")).getImage();
			}
			break;
			
		case 5:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos5.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos5.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia5.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros5.jpg")).getImage();
			}
			break;
			
		case 6:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos6.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos6.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia6.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros6.jpg")).getImage();
			}
			break;
		case 7:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos7.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos7.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia7.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros7.jpg")).getImage();
			}
			break;
			
		case 8:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos8.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos8.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia8.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros8.jpg")).getImage();
			}
			break;
		case 9:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos9.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos9.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia9.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros9.jpg")).getImage();
			}
			break;
		case 10:
			if(palace_name=="Knossos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/knossos10.jpg")).getImage(); 
			}
			else if(palace_name=="Faistos") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/phaistos10.jpg")).getImage();
			}
			else if(palace_name=="Mallia") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/malia10.jpg")).getImage();
			}
			else if(palace_name=="Zakros") {
				front=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/cards/zakros10.jpg")).getImage();
			}
			break;
			
		default:
				System.out.println(palace_name+" number doesn't exist");
				break;
		}
			
			
		
	}
	
	
	
	/**
	 * @return name of the palace
	 */
	public String getName() {return this.palace_name;}
	
	
	
	/**
	 * @return number of the card
	 */
	public int getNumber() {return this.number;}
}
