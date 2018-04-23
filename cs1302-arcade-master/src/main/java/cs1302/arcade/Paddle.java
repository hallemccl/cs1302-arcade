package cs1302.arcade;

import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.*;
import javafx.scene.input.KeyEvent;

public class Paddle extends Rectangle {
	
	
	public Paddle(double width, double height, Paint color) {
		
		super(width, height, color);
		
	}//Paddle
	
	public void move(KeyEvent e) {
		
		if(this.getX() <= 0) {
			if (e.getCode() == KeyCode.LEFT)  
				this.setX(this.getX());
			if (e.getCode() == KeyCode.RIGHT) 
				this.setX(this.getX() + 15.0);
		}//if
		else if(this.getX() >= 716) { //fix this, rigth side goes off the page
			if (e.getCode() == KeyCode.LEFT)  
				this.setX(this.getX() - 15.0);
			if (e.getCode() == KeyCode.RIGHT) 
				this.setX(this.getX());
		}//else
		else{
			if (e.getCode() == KeyCode.LEFT)  
				this.setX(this.getX() - 15.0);
			if (e.getCode() == KeyCode.RIGHT) 
				this.setX(this.getX() + 15.0);
		}//else
		
	}//move
	
	public void setSize(double width, double height) {
		
	}//setSize

}//Paddle
