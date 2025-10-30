package Model.findings;

import java.awt.Image;


/**
 *Class for fresco, subclass of findings
 */
public class fresco extends finding{
	int points;
	Image image;
	/**
	 * Constructor
	 * @param points
	 * @param image
	 */
	public fresco(int points, Image image){
		this.points=points;
		this.image=image;
	}
	
	public int getPoints() {return this.points;}

}
