


package game.gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOverPopUp {
	private VBox popUpVbox;
	private HBox gameButtonHbox;
	private int score;
	
	public HBox getGameButtonHbox() {
		return gameButtonHbox;
	}


	public GameOverPopUp(int score) {
		this.score = score;
		popUpVbox = new VBox(20);
		gameButtonHbox = new HBox(20);
		Label titleLabel = new Label("Game is Over");
		titleLabel.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 30pt; -fx-text-fill:#ffffff");

		Label scoreLabel = new Label("Score " + this.score);
		scoreLabel.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 20pt; -fx-text-fill:#ffffff");

		Button exitBtn = new Button("Exit");
		exitBtn.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 10pt; -fx-text-fill: #002D62; -fx-background-color: white ;-fx-pref-height: 15px;-fx-pref-width:150px;-fx-background-radius: 10px;");

		Button playAgainBtn = new Button("Play Again");
		playAgainBtn.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 10pt; -fx-text-fill: #002D62; -fx-background-color: white ;-fx-pref-height: 15px;-fx-pref-width:150px;-fx-background-radius: 10px;");

		gameButtonHbox.getChildren().addAll(playAgainBtn,exitBtn);
		popUpVbox.getChildren().addAll(titleLabel,scoreLabel,gameButtonHbox);
		gameButtonHbox.setAlignment(Pos.CENTER);

		popUpVbox.setPadding(new Insets(10));
		
		popUpVbox.setAlignment(Pos.CENTER);
		popUpVbox.setStyle("-fx-background-color: #002D62;");


	}
	
	public void gamePopUp(Stage stagePopUp){
		Scene scenePopUp = new Scene(popUpVbox,500,200);
		stagePopUp.setScene(scenePopUp);
		stagePopUp.show();
	};
}
