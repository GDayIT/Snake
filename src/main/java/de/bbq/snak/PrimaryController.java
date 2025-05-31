package de.bbq.snak;


import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class PrimaryController {
	// 0 = UP, 1 = Right, 2 = Down, 3 = Left
	int direction = 0;
	boolean tastendruck = false;
	boolean isGameover = false;
	
	@FXML
	AnchorPane pane;

	@FXML
	Rectangle kopf, food;
	ArrayList<Rectangle> body = new ArrayList<>();
	
	
	public void checkCollision() {
		double x = kopf.getLayoutX();
		double y = kopf.getLayoutY();
		
		//Ausßerhalb des Spielfelds (Wand)
		if (x < 0 || y < 0 || x > 400 || y > 400) {
			
			gameover();
			return;
		}
		
		// Gegen sich selber
		for(Rectangle sbod : body) {
			if (sbod.getLayoutX() == x && sbod.getLayoutY() == y) {
				gameover();
				return;
			}
		}
		
	}
	
	public void gameover() {
	
		isGameover = true;
		// Hinweis Game Over
		Alert gameover = new Alert(AlertType.ERROR);
		gameover.setTitle("Du hast verloren!");
		gameover.setHeaderText("Du hast verloren! Dein Rekord: " + body.size());
		gameover.setContentText("Try Again! ");
		gameover.showAndWait();
		
		// Reset
		direction = 0;
		kopf.setLayoutX(200);;
		kopf.setLayoutY(200);
		
		
		pane.getChildren().removeAll(body);
		body.clear();
		
		isGameover = false;
		
		
		//
		
		
	}
	
	
	
	
	public void onGameloop() {
		
		if (isGameover) {
			return;
		}
		

		double x = kopf.getLayoutX();
		double y = kopf.getLayoutY();
		
		
		
		
		//Körper "bewegen"
		Rectangle neu = new Rectangle(20, 20);
		neu.setFill(kopf.getFill());
		neu.setStroke(kopf.getStroke());
		neu.setLayoutX(x);
		neu.setLayoutY(y);
		pane.getChildren().add(neu);
		body.add(neu);
		
		boolean bodyOnFood = false;
		for (Rectangle sbod : body) {
			if(sbod.getLayoutX() == food.getLayoutX() && sbod.getLayoutY() == food.getLayoutY()) {
				bodyOnFood =true;
			}
		}
		
		if (x != food.getLayoutX() || y != food.getLayoutY() && !bodyOnFood){
			pane.getChildren().remove(body.get(0));
			body.remove(0);
		} else {
			int zufallX = new Random().nextInt(440 / 20) * 20;
			int zufallY = new Random().nextInt(440 / 20) * 20;
			food.setLayoutX(zufallX);
			food.setLayoutY(zufallY);
		}
		
		

		
		
//		switch (direction) {
//		case 0:
//			y = y - 20;
//			break;
//		case 1:
//			x = x + 20;
//			break;
//		case 2:
//			y = y + 20;
//			break;
//		case 3:
//			x = x - 20;
//			//x-=20 alternativ
//			break;
//			//default nicht notwendig
//		default:
//			break;
//		}
		
		if (direction == 0) y -= 20;
		else if(direction == 1) x += 20;
		else if(direction == 2) y += 20;
		else if(direction == 3) x -= 20;
		
		
		kopf.setLayoutX(x);
		kopf.setLayoutY(y);
		tastendruck = false;
		
		checkCollision();
	}
	
	
	@FXML
	public void onSteuerung(KeyEvent e) {

		if (e.getCode().equals(KeyCode.LEFT) && !tastendruck) {
			direction = (4 + direction - 1) % 4;
			tastendruck = true;
		}
		if (e.getCode().equals(KeyCode.RIGHT)&& !tastendruck) {
			direction = (4 + direction + 1) % 4;
			tastendruck = true;
		}
	}
	
	@FXML
	public void initialize() {
		// Game Loop

		
		  TimerTask gameloop = new TimerTask() {
			   public void run() {
				// Scene existiert jetzt :O
				    App.scene.setOnKeyPressed(event -> {
				     onSteuerung(event);
				    });
			    Platform.runLater(new Runnable() {
			        @Override
			        public void run() {
			         onGameloop();
			        }
			    });
			   }
			   
			  };
			  new Timer().scheduleAtFixedRate(gameloop, 200, 200);
			  
	}
}

