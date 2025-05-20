package game.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartGameView {
	private BorderPane borderPane;
	
	public BorderPane getBorderPane() {
		return borderPane;
	}
	public StartGameView() {
		
		borderPane = new BorderPane();
		borderPane.setPadding(new Insets(40));
	
		Label labelTitle = new Label("Attack On Titans");
		labelTitle.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 70pt; -fx-text-fill:#002244");
		
		labelTitle.setFont(new Font(100));

		Label labelInstuctionsTitle = new Label("Game Instructions");
		labelInstuctionsTitle.setFont(new Font(50));
		labelInstuctionsTitle.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 40pt; -fx-text-fill:#002D62");

		
		Text textInstructions = new Text(
"Players are required to defeat Titans"
+ " attacking lanes by Defending the wall."
+ " The wall is defended by attacking the Titans using weapons bought by the Player."
+ " Each turn, the Player will have the option to either buy and deploy a weapon to "
+ "their choice of lane or choose to skip buying a weapon."
+ " The Player must have enough resources to buy the weapon.");

		textInstructions.setWrappingWidth(500);
		textInstructions.setFont(new Font(30));
		textInstructions.setStyle("-fx-text-fill: #00416A;");
		textInstructions.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 20pt; -fx-fill:#002D62;");
		
		VBox vBoxInstructions = new VBox(20);
		vBoxInstructions.getChildren().addAll(labelInstuctionsTitle,textInstructions);
		labelTitle.setPadding(new Insets(80));
		VBox vboxTitle = new VBox();
		vboxTitle.getChildren().add(labelTitle);
		borderPane.setTop(vboxTitle);
		vboxTitle.setAlignment(Pos.CENTER);
		borderPane.setRight(vBoxInstructions);
		try{
		Image imageStart = new Image("attack-on-titan-wallpaper-12_2.jpg");
		ImageView imageStartView = new ImageView(imageStart);
		BackgroundImage backgroundImage = new BackgroundImage(imageStart,null,null, null,null);

		borderPane.setBackground(new Background(backgroundImage));

	}
	catch (Exception e) {
        System.err.println("Error in image Background: " + e.getMessage());
    }
		
	}
	
	public VBox addGameMode(){
		Label labelGameMode = new Label("Choose Game Mode");
		labelGameMode.setFont(new Font(60));
		labelGameMode.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 40pt; -fx-text-fill:#002D62");

		Button buttonEasy = new Button("Easy");
		buttonEasy.setPrefSize(200,100);
		buttonEasy.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 40pt; -fx-text-fill: white; -fx-background-color: #002D62 ;-fx-pref-height: 15px;-fx-pref-width:250px;-fx-background-radius: 10px;");

		Button buttonHard = new Button("Hard");
		buttonHard.setPrefSize(200,100);
		buttonHard.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 40pt; -fx-text-fill: white; -fx-background-color: #002D62 ;-fx-pref-height: 15px;-fx-pref-width:250px;-fx-background-radius: 10px;");

		
		VBox vBoxGameMode = new VBox(50);
		vBoxGameMode.getChildren().addAll(labelGameMode, buttonEasy, buttonHard);
		borderPane.setLeft(vBoxGameMode);
		return vBoxGameMode;

	}
	public Button addPlay(){
		Button buttonPlay = new Button("Play");
		buttonPlay.setPrefSize(300,200);
		buttonPlay.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 50pt; -fx-text-fill: white; -fx-background-color: #002D62 ;-fx-pref-height: 15px;-fx-pref-width:250px;-fx-background-radius: 10px;");

		borderPane.setCenter(buttonPlay);
		return buttonPlay;
	}
	

	
	
	
}
