package Model.findings;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Class rare finding, subclass of finding
 */
public class RareFinding extends finding{
	
	
	int points;
	Image image;	
	String name;

	
	/**
	 * Constructor
	 * @param points
	 * @param found
	 * @param name
	 * @param image
	 */
	public RareFinding(int points, String name, Image image){
		this.name=name;
		this.points=points;
		this.image=image;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPoints() {return this.points;}

}
