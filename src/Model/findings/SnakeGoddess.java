package Model.findings;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Class for snake goddess statues, subclass of finding
 */
public class SnakeGoddess extends finding{
	Image image;
	/**
	 * Constructor
	 */
	public SnakeGoddess() {
		
		image=new ImageIcon(this.getClass().getResource("/assets/project_assets/images/findings/snakes.jpg")).getImage();
	}
	
	
}
