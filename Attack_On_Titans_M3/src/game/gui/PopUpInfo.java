package game.gui;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PopUpInfo {
	private VBox popUpVbox;
	public VBox getPopUpVbox() {
		return popUpVbox;
	}

	public PopUpInfo(){
		popUpVbox = new VBox(20);
		Label titleLabel = new Label("Battle Info");
		titleLabel.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 14pt; -fx-text-fill:#ffffff");
		
		Text textInstructions = new Text("Press on Wall to know its Health and Danger Level"
				+ "   If Player chooses to deploy a weapon, then player must press on an available lane to "
				+ " deploy the weapon to.");
		textInstructions.setWrappingWidth(220);
		textInstructions.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 10pt; -fx-fill:#ffffff;");

		Button strtButton = new Button("Start Game");
		strtButton.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 10pt; -fx-text-fill: #002D62; -fx-background-color: #ffffff ;-fx-pref-height: 15px;-fx-pref-width:150px;-fx-background-radius: 10px;");
		popUpVbox.setStyle("-fx-background-color: #002D62;");
		popUpVbox.getChildren().addAll(titleLabel,textInstructions,strtButton);
		popUpVbox.setPadding(new Insets(10));
		popUpVbox.setAlignment(Pos.CENTER);


	}
	
	public void infoPopUp(Stage stagePopUp){
		Scene scenePopUp = new Scene(popUpVbox,500,300);
		stagePopUp.setScene(scenePopUp);
		stagePopUp.show();
	};



}
