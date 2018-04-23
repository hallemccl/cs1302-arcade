package cs1302.arcade;

import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.*;

public class Ball extends Circle {
	
	int dX = 5;
	int dY = 5;
	
	public Ball(double radius, Paint color) {
		
		super(radius, color);
		
	}//Ball
	
	public void move(Rectangle r, Brick[][] bricks) {
		
		EventHandler<ActionEvent> handler = event -> this.movements(r, bricks);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(35), handler);
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		
	}//move
	
	public void movements(Rectangle paddle, Brick [][] bricks) {
		
		this.setCenterX(this.getCenterX() + dX);
		this.setCenterY(this.getCenterY() + dY);
		
		if(this.getCenterX() <= 7) {
			dX *= -1;
			//paddle.setSize(paddle.getWidth(), paddle.getHeight()/2);
		}
		else if(this.getCenterX() >= 809)
			dX *= -1;
		
		if(this.getCenterY() <= 7)
			dY *= -1;
		else if(this.getCenterY() >= 485)
			dY *= -1;
			//needs to pause game, lose one life, and start over
		
		if(this.getBoundsInParent().intersects(paddle.getBoundsInParent())) 
			dY *= -1;
		
		for(Brick[] arr : bricks) {	
			for(Brick b: arr) {
				if(b.isVisible()) {
					if(this.getBoundsInParent().intersects(b.getBoundsInParent())) {
						if (b.getWidth() >= b.getHeight())
							dY *= -1;
						if (b.getHeight() >= b.getWidth())
							dX *= -1;
						b.setVisible(false);
					}//if
				}//if
			}//for
		}//for
		

	}//movements

}//Ball
