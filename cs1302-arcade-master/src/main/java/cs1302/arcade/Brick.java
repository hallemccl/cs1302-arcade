package cs1302.arcade;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle{
	
	boolean destroyed;
	
	public Brick(double width, double height) {
		
		super(width, height);
		destroyed = false;
		
	}//brick
	
	public void setColor(int r) {
		
		if(r == 0 || r == 1)
			this.setFill(Color.RED);
		if(r == 2 || r == 3)
			this.setFill(Color.ORANGE);
		if(r == 4 || r == 5)
			this.setFill(Color.LAWNGREEN);
		if(r == 6 || r == 7)
			this.setFill(Color.YELLOW);
		
	}//setColor
	

}//Brick
