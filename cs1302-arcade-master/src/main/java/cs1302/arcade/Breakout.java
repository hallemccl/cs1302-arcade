package cs1302.arcade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Breakout extends Application{
	
	int rows = 8;
	int cols = 8;
	
	public void start(Stage stage) {
		
		Group group = new Group();
		Scene scene = new Scene(group);
		Rectangle background = new Rectangle(816, 516, Color.BLACK);
		
		
		HBox data = new HBox();
		Label level = new Label("Level: \t");
		level.setTextFill(Color.WHITE);
		Label lives = new Label("Lives: \t");
		lives.setTextFill(Color.WHITE);
		Label score = new Label("Score: ");
		score.setTextFill(Color.WHITE);
		data.getChildren().addAll(level, lives, score);
		
		
		FlowPane fp = new FlowPane();
		fp.setPrefWrapLength(816);
		Rectangle [][] bricks = new Rectangle[rows][cols];
		for(int r = 0; r < rows; r++)
			for(int c = 0; c < cols; c++) {
				bricks[r][c] = new Rectangle(100, 20);
				if(r == 0 || r == 1)
					bricks[r][c].setFill(Color.RED);
				if(r == 2 || r == 3)
					bricks[r][c].setFill(Color.ORANGE);
				if(r == 4 || r == 5)
					bricks[r][c].setFill(Color.LAWNGREEN);
				if(r == 6 || r == 7)
					bricks[r][c].setFill(Color.YELLOW);
				fp.getChildren().add(bricks[r][c]);
				fp.setHgap(2);
				fp.setVgap(2);
			}
		
		
		Paddle paddle = new Paddle(100, 20, Color.WHITE);
		paddle.setX(400);
		paddle.setY(408);
		Ball ball = new Ball(7, Color.WHITE);
		ball.setCenterX(350);
		ball.setCenterY(380);
		group.getChildren().addAll(background, data, fp, paddle, ball);
		
		
		// when the user presses left and right, move the rectangle
		scene.setOnKeyPressed(e -> {
			if(paddle.getX() == 0) {
				if (e.getCode() == KeyCode.LEFT)  
					paddle.setX(paddle.getX());
				if (e.getCode() == KeyCode.RIGHT) 
					paddle.setX(paddle.getX() + 10.0);
			}
			else if(paddle.getX() >= 716) {
				if (e.getCode() == KeyCode.LEFT)  
					paddle.setX(paddle.getX() - 10.0);
				if (e.getCode() == KeyCode.RIGHT) 
					paddle.setX(paddle.getX());
			}
			else{
				if (e.getCode() == KeyCode.LEFT)  
					paddle.setX(paddle.getX() - 10.0);
				if (e.getCode() == KeyCode.RIGHT) 
					paddle.setX(paddle.getX() + 10.0);
			}
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

}
