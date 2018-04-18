package cs1302.arcade;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Breakout extends Application{
	
	int rows = 8;
	int cols = 8;

	public void start(Stage stage) {
		
		Group group = new Group(); //main container
		Rectangle rect = new Rectangle(816, 516); //black background
		HBox hbox1 = new HBox();
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
		
		Label level = new Label("Level: \t");
		level.setTextFill(Color.WHITE);
		
		Label lives = new Label("Lives: \t");
		lives.setTextFill(Color.WHITE);
		
		Label score = new Label("Score: ");
		score.setTextFill(Color.WHITE);
		
		hbox1.getChildren().addAll(level, lives, score);
		group.getChildren().addAll(rect, hbox1, fp);  
		
		
		Scene scene = new Scene(group);
        stage.setTitle("Breakout");
        stage.setMinHeight(516);
        stage.setMinWidth(816);
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
