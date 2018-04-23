package cs1302.arcade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Breakout extends Application{
	
	int rows = 8;
	int cols = 8;
	Integer score = 0;
	
	public void start(Stage stage) {
		
		Group group = new Group();
		Scene scene = new Scene(group);
		Rectangle background = new Rectangle(816, 516, Color.BLACK);
		
		
		HBox data = new HBox();
		
		Label level = new Label("Level: \t\t");
		level.setTextFill(Color.WHITE);
		
		Label lives = new Label("Lives: \t\t");
		lives.setTextFill(Color.WHITE);
		
		Label scoring = new Label("Score: ");
		scoring.setTextFill(Color.WHITE);
		
		Text score = new Text("0");
		score.setFill(Color.WHITE);
		
		data.getChildren().addAll(level, lives, scoring, score);
		
		
		FlowPane fp = new FlowPane();
		fp.setHgap(2);
		fp.setVgap(2);
		fp.setPrefWrapLength(816);
		
		Brick [][] bricks = new Brick[rows][cols];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				bricks[r][c] = new Brick(100, 20);
				bricks[r][c].setColor(r);
				fp.getChildren().add(bricks[r][c]);
			}//for
		}//for
		
		
		Paddle paddle = new Paddle(100, 20, Color.WHITE);
		paddle.setX(400);
		paddle.setY(440);
		Ball ball = new Ball(7, Color.WHITE);
		ball.setCenterX(350);
		ball.setCenterY(380);
		group.getChildren().addAll(background, fp, paddle, ball, data);
		
		
		// when the user presses left and right, move the rectangle
		scene.setOnKeyPressed(e -> {
			
			paddle.move(e);
			if(e.getCode() == KeyCode.SPACE)
				ball.move(paddle, bricks);

		});
		
		
        stage.setTitle("Breakout");
        stage.setMinHeight(516);
        stage.setMinWidth(816);
        stage.setMaxHeight(516);
        stage.setMaxWidth(816);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        
	}//start
	
	
	public Integer updateScore(Color color) {
		
		if(color.equals(Color.YELLOW))
			score = score + 1;
		if(color.equals(Color.LAWNGREEN))
			score = score + 3;
		if(color.equals(Color.ORANGE))
			score = score + 5;
		if(color.equals(Color.RED))
			score = score + 7;
		
		return score;
		
	}//updateScore
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    Application.launch(args);
		} catch (UnsupportedOperationException e) {
		    System.out.println(e);
		    System.err.println("If this is a DISPLAY problem, then your X server connection");
		    System.err.println("has likely timed out. This can generally be fixed by logging");
		    System.err.println("out and logging back in.");
		    System.exit(1);
		} // try

	}//main

}//Breakout
