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

public class TurnPopUp {
	private VBox popUpVbox;
	private HBox turnBottonHbox;
	
	public HBox getTurnBottonHbox() {
		return turnBottonHbox;
	}


	public TurnPopUp(String wrong){
		popUpVbox = new VBox(20);
		turnBottonHbox = new HBox(20);
		Label titleLabel = new Label("Wrong Move");
		titleLabel.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 20pt; -fx-text-fill:#ffffff");

		Label wrongLabel = new Label(wrong);
		wrongLabel.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 12pt; -fx-text-fill:#ffffff;");

		//text.setWrappingWidth(400);
		Button ok_btn = new Button("Ok");
		ok_btn.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 12pt; -fx-text-fill: #002D62; -fx-background-color: white ;-fx-pref-height: 15px;-fx-pref-width:150px;-fx-background-radius: 10px;");

		
		turnBottonHbox.getChildren().addAll(ok_btn);
		popUpVbox.getChildren().addAll(titleLabel,wrongLabel,turnBottonHbox);
		turnBottonHbox.setAlignment(Pos.CENTER);

		popUpVbox.setPadding(new Insets(10));
		
		popUpVbox.setAlignment(Pos.CENTER);
		popUpVbox.setStyle("-fx-background-color: #002D62;");



	}
	
	public void turnPopUp(Stage stagePopUp){
		Scene scenePopUp = new Scene(popUpVbox,500,200);
		stagePopUp.setScene(scenePopUp);
		stagePopUp.show();
	};
}
