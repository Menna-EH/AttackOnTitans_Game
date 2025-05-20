package game.gui;

import game.engine.Battle;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.weapons.PiercingCannon;
import game.engine.weapons.SniperCannon;
import game.engine.weapons.VolleySpreadCannon;
import game.engine.weapons.WallTrap;
import game.engine.weapons.Weapon;
import game.engine.weapons.WeaponRegistry;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MainContoller extends Application {


	 
		private Battle battle;

		private StartGameView startGameView;
		
		private BattleSceneController btlSceneController;
		private Stage stagePopUp;
		private TurnPopUp turnPopUp;
		private GameOverPopUp gameOverPopUp;
		private Scene sceneBattle;
		private Parent battleParent;
		private Button piercingCannonBtn;
		private Button sniperBtn;
		private Button volleySpreadBtn;
		private Button wallTrapBtn;
		private Scene strtscene;
		
		private FXMLLoader battle_loader;
		
		private VBox weaponShopVbox;
		private Scene sceneWeaponShopView;
		private int weaponCodeTurn;
		private Lane laneTurn;
		private Button easyButton;
		private Button hardButton;
		private Button playButton;
		private Boolean purchaseOn;


		@Override
		public void start(Stage primaryStage) throws Exception {

			 //TODO Auto-generated method stub
			startGameView = new StartGameView();
			gameOverPopUp = new GameOverPopUp(0);
			piercingCannonBtn = new Button();
			volleySpreadBtn = new Button();
			sniperBtn = new Button();
			wallTrapBtn = new Button();
			purchaseOn = false;


	//add here
			Button backButton = new Button("Back to Battle");
			backButton.setStyle("-fx-font-family:'Cooper Black';-fx-font-size: 30pt; -fx-text-fill: #ffffff; -fx-background-color: #002D62 ;-fx-pref-height: 15px;-fx-background-radius:10px;");

			Label weaponShopLabel = new Label("Weapon Shop");
			weaponShopLabel.setFont(new Font(100));
			weaponShopLabel.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: white;");
			HBox weaponTopHbox = new HBox(250);
			weaponTopHbox.getChildren().addAll(backButton,weaponShopLabel);
			
			GridPane gridPane = new GridPane();
			gridPane.setPadding(new Insets(10));
			gridPane.setHgap(20);
			gridPane.setVgap(20);
			
			weaponShopVbox = new VBox(10);
			


	       Button purchase_button = new Button("Purchase");
	       purchase_button.setStyle("-fx-font-family: 'Cooper Black';-fx-font-size: 30pt; -fx-text-fill: white; -fx-background-color: #002D62 ;-fx-pref-height: 15px;");

	       purchase_button.setDisable(true);
			weaponShopVbox.getChildren().addAll(weaponTopHbox,gridPane,purchase_button);
			try{
				Image imageStart = new Image("attack-on-titan-1920x1080.jpeg");
				ImageView imageStartView = new ImageView(imageStart);
				BackgroundImage backgroundImage = new BackgroundImage(imageStart,null,null, null,null);

				weaponShopVbox.setBackground(new Background(backgroundImage));

			}
			catch (Exception e){
				System.out.println("img loading error");
			}
	//ends here
			
			Weapon weaponTurn;
			Lane laneTurn;
			
			this.btlSceneController = new BattleSceneController();
			PopUpInfo popUpInfo = new PopUpInfo();
			stagePopUp = new Stage();
			
			
			VBox vBoxGameMode = startGameView.addGameMode();
			 playButton = startGameView.addPlay();
			//Button playButton = startGameView.addPlay();
			playButton.setVisible(false);
//			Button easyButton = (Button) vBoxGameMode.getChildren().get(1);
//			Button hardButton = (Button) vBoxGameMode.getChildren().get(2);
			 easyButton = (Button) vBoxGameMode.getChildren().get(1);
			 hardButton = (Button) vBoxGameMode.getChildren().get(2);


			BorderPane bpStartGameView = startGameView.getBorderPane();


//			battleSceneController battleController = battle_loader.getController();
			
			  easyButton.setOnMouseClicked(event -> {

					try {
						 battle = new Battle(1,0,50,3,250);
						 battle_loader = new FXMLLoader(getClass().getResource("EasyBattleView.fxml"));
						 battleParent = battle_loader.load();
						 sceneBattle = new Scene(battleParent,1920,990);
						playButton.setVisible(true);
							}
						catch (IOException ioe){
						}

		        });

			  hardButton.setOnMouseClicked(event -> {
					try {
						 battle = new Battle(1,0,50,5,125);
						 battle_loader = new FXMLLoader(getClass().getResource("HardBattleView.fxml"));
						 battleParent = battle_loader.load();
						 sceneBattle = new Scene(battleParent,1920,990);
						playButton.setVisible(true);
							}
						catch (IOException ioe){
						}
			  		});


			  playButton.setOnMouseClicked(event -> {
					this.addWeapon(gridPane, battle.getWeaponFactory().getWeaponShop());
					this.sceneWeaponShopView = new Scene(this.weaponShopVbox,1920,990);
			       // weaponShopView.addWeapon(battle.getWeaponFactory().getWeaponShop());

					 
					try{

						BattleSceneController battleController = battle_loader.getController();
						battleController.setBattle(battle);
						battleController.setWeaponShopScene(this.sceneWeaponShopView);
						battleController.setGameCurrentValues(battle);
						this.btlSceneController= battleController;
						this.btlSceneController.setMainController(this);
						this.btlSceneController.setStage(primaryStage);
						this.btlSceneController.initWeapToLane();


						primaryStage.setScene(sceneBattle);
						primaryStage.show();
						popUpInfo.infoPopUp(stagePopUp);

						}
						catch (Exception e){
							e.printStackTrace();
						}
				        
						 
		        });

			  	backButton.setOnMouseClicked(event -> {

			  		primaryStage.setScene(sceneBattle);
					primaryStage.show();
					
			        });
			  	Button startGameButton = (Button) popUpInfo.getPopUpVbox().getChildren().get(2);
			  	startGameButton.setOnMouseClicked(event -> {
					 stagePopUp.close();

				  		});
			  	
			  	
			  	wallTrapBtn.setOnMouseClicked(event->{
			        if (this.purchaseOn)
			  			purchase_button.setDisable(false);
			  		this.weaponCodeTurn = WallTrap.WEAPON_CODE;
			  	
			  	});
			  	volleySpreadBtn.setOnMouseClicked(event->{
			        if (this.purchaseOn)
			        	purchase_button.setDisable(false);

			  		this.weaponCodeTurn = VolleySpreadCannon.WEAPON_CODE;
			  	});
			  	sniperBtn.setOnMouseClicked(event->{
			        if (this.purchaseOn)
			        	purchase_button.setDisable(false);

			  		this.weaponCodeTurn = SniperCannon.WEAPON_CODE;
			  	});
			  	piercingCannonBtn.setOnMouseClicked(event->{
			        if (this.purchaseOn)
			        	purchase_button.setDisable(false);

			  		this.weaponCodeTurn = PiercingCannon.WEAPON_CODE;
			  	});
			  	
			  	purchase_button.setOnMouseClicked(event->{
			  		Lane lane = this.btlSceneController.getLaneTurn();
			  		this.btlSceneController.setLanesButtons();
			  		try{
			  			battle.purchaseWeapon(weaponCodeTurn, lane);
			  			//this.btlSceneController.addWeaponToLane(weaponCodeTurn,lane);
			  			this.btlSceneController.laneWeaponsAdd(weaponCodeTurn, lane);
			  			
						this.btlSceneController.setGameCurrentValues(battle);
						this.btlSceneController.addTitan();
				  		primaryStage.setScene(sceneBattle);
						primaryStage.show();
						purchase_button.setDisable(true);
						this.purchaseOn=false;

			  		}
			  		catch (InsufficientResourcesException ire){
			  			String wrong = "Not Enough Resources to Buy Weapon";
			  			turnPopUp = new TurnPopUp(wrong);
			  			turnPopUp.turnPopUp(stagePopUp);
					  	Button ok_button = (Button) this.turnPopUp.getTurnBottonHbox().getChildren().get(0);
					  	ok_button.setOnMouseClicked(Actionevent->{
					  		this.stagePopUp.close();
					  	});
			  		}
			  		catch (InvalidLaneException ile){
			  			String wrong = "Invalid Lane, choose another Lane";
			  			turnPopUp = new TurnPopUp(wrong);
			  			turnPopUp.turnPopUp(stagePopUp);
					  	Button ok_button = (Button) this.turnPopUp.getTurnBottonHbox().getChildren().get(0);
					  	ok_button.setOnMouseClicked(Actionevent2->{
					  		this.stagePopUp.close();
					  		primaryStage.setScene(sceneBattle);
							primaryStage.show();
					  	});
			  		}
			  	});
			  	

			  	
				 strtscene = new Scene(bpStartGameView,1920,990);
				 primaryStage.setScene(strtscene);
			     primaryStage.show();
			     

		}
	public void setPurchaseOn(Boolean purchaseOn) {
			this.purchaseOn = purchaseOn;
		}
	public void gameOver(int score,Stage primaryStage){
		gameOverPopUp = new GameOverPopUp(this.battle.getScore());
	    gameOverPopUp.gamePopUp(this.stagePopUp);
	    Button playAgainBtn = 	(Button)gameOverPopUp.getGameButtonHbox().getChildren().get(0);
	  	playAgainBtn.setOnMouseClicked(event->
	  	{	
	  		try {
				this.stagePopUp.close();
				this.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	});
	  	Button exitBtn = (Button)gameOverPopUp.getGameButtonHbox().getChildren().get(1);
	  	exitBtn.setOnMouseClicked(event->
	  	{
	  		this.stagePopUp.close();
	  		primaryStage.close();
	  	});

	}
	public void addWeapon(GridPane gridPane, HashMap<Integer, WeaponRegistry> weaponShop){
			
			int numOfWeapons = weaponShop.size();
			 Set<Map.Entry<Integer, WeaponRegistry>> weaponSet = weaponShop.entrySet();
			 int count = 0;
				Label weaponName;
	        	Label weaponDamage;
	        	Label weaponPrice;
	        	Label weaponMinRange;
	        	Label weaponMaxRange;
		        for (Entry<Integer, WeaponRegistry> weapon : weaponSet) {
		        	Button weaponButton = new Button();
		        	VBox vBoxWeapon = new VBox();
		        	
		    		if (weapon.getValue().getCode()==3) {
		        	 weaponName = new Label(weapon.getValue().getName());
		        	 weaponName.setStyle("-fx-font-family:'Cooper Black';");
		        	 weaponDamage = new Label("Damage " + weapon.getValue().getDamage());
		        	 weaponDamage.setStyle("-fx-font-family:'Cooper Black';");
		        	 weaponPrice = new Label("Price " +weapon.getValue().getPrice());
		        	 weaponPrice.setStyle("-fx-font-family:'Cooper Black';");
		        	 weaponMinRange = new Label("Min Range "+weapon.getValue().getMinRange());
		        	 weaponMinRange.setStyle("-fx-font-family:'Cooper Black';");
		        	 weaponMaxRange = new Label("Max Range "+weapon.getValue().getMaxRange());
		        	 weaponMaxRange.setStyle("-fx-font-family:'Cooper Black';");

			    	vBoxWeapon.getChildren().addAll(weaponName,weaponDamage,weaponPrice,weaponMinRange,weaponMaxRange);
		        	
		        	}
		    		
		    		else
		    		{
			        	 weaponName = new Label(weapon.getValue().getName());
			        	 weaponName.setStyle("-fx-font-family:'Cooper Black';");
			        	 weaponDamage = new Label("Damage " + weapon.getValue().getDamage());
			        	 weaponDamage.setStyle("-fx-font-family:'Cooper Black';");
			        	 weaponPrice = new Label("Price " +weapon.getValue().getPrice());
			        	 weaponPrice.setStyle("-fx-font-family:'Cooper Black';");
				    	vBoxWeapon.getChildren().addAll(weaponName,weaponDamage,weaponPrice);

		    		}
		        	weaponButton.setGraphic(vBoxWeapon);

		        	switch (weapon.getValue().getCode())
		    		{
		    		case PiercingCannon.WEAPON_CODE:

		    			
		    			Image imageStart = new Image("cannon_200.jpg");
		    			this.piercingCannonBtn.setGraphic(vBoxWeapon);

		    			ImageView imageStartView = new ImageView(imageStart);
		    			BackgroundImage backgroundImage = new BackgroundImage(imageStart,null,null, null,null);
		    			vBoxWeapon.setPrefWidth(200);
		    			vBoxWeapon.setPrefHeight(200);
		    			vBoxWeapon.setBackground(new Background(backgroundImage));
			        	gridPane.add(piercingCannonBtn, count%2, count/2);break;
			        	
		    		case SniperCannon.WEAPON_CODE:
		    			this.sniperBtn.setGraphic(vBoxWeapon);
		    			vBoxWeapon.setPrefWidth(200);
		    			vBoxWeapon.setPrefHeight(200);
		    			Image sniper = new Image("sniper_200.jpg");
		    			ImageView sniper1 = new ImageView(sniper);
		    			BackgroundImage backsniper = new BackgroundImage(sniper,null,null, null,null);
		    			vBoxWeapon.setBackground(new Background(backsniper));
		    			vBoxWeapon.setPrefWidth(200);
		    			vBoxWeapon.setPrefHeight(200);
		    			gridPane.add(sniperBtn, count%2, count/2);break;
		    			
		    			
		    		case VolleySpreadCannon.WEAPON_CODE:
		    			this.volleySpreadBtn.setGraphic(vBoxWeapon);
		    			Image volley = new Image("volleyspread_200.jpg");
		    			ImageView volleyspread = new ImageView(volley);
		    			BackgroundImage backvolley = new BackgroundImage(volley,null,null, null,null);
		    			vBoxWeapon.setBackground(new Background(backvolley));
		    			vBoxWeapon.setPrefWidth(200);
		    			vBoxWeapon.setPrefHeight(200);
			        	gridPane.add(volleySpreadBtn, count%2, count/2);break;
			        	
			        	
		    		case WallTrap.WEAPON_CODE:
		    			Image walltrap = new Image("wllt_200.jpg");
		    			ImageView walltrapview = new ImageView(walltrap);
		    			BackgroundImage backwall = new BackgroundImage(walltrap,null,null, null,null);
		    			vBoxWeapon.setBackground(new Background(backwall));
		    			this.wallTrapBtn.setGraphic(vBoxWeapon);
		    			vBoxWeapon.setPrefWidth(220);
		    			vBoxWeapon.setPrefHeight(200);
		    		gridPane.add(wallTrapBtn, count%2, count/2);break;
		    		
		    		
		    		default:
		    			System.out.println("wrong");
		    			break;
		    		}
		        	count++;
		        }
				     
		}
	public ImageView addWeaponImage(int weaponCode){
    	switch (weaponCode)
		{
		case PiercingCannon.WEAPON_CODE:

			Image image1 = new Image("cannon_mini_60.jpg");
			return new ImageView(image1);
        	
		case SniperCannon.WEAPON_CODE:
			Image image2 = new Image("sniper_mini_60.jpg");
			return new ImageView(image2);
			
		case VolleySpreadCannon.WEAPON_CODE:
			Image image3 = new Image("volley_mini_60.jpg");
			return new ImageView(image3);
        	
        	
		case WallTrap.WEAPON_CODE:
			Image image4 = new Image("wllt_mini_70.jpg");
			return new ImageView(image4);		
		default:
			System.out.println("wrong");
			return new ImageView();
		}
	}
	public void enableWeapons(){
		piercingCannonBtn.setDisable(false);
		wallTrapBtn.setDisable(false);
		sniperBtn.setDisable(false);
		volleySpreadBtn.setDisable(false);

	}
	public void disableWeapons(){
		piercingCannonBtn.setDisable(true);
		wallTrapBtn.setDisable(true);
		sniperBtn.setDisable(true);
		volleySpreadBtn.setDisable(true);
	}

		public static void main(String[] args) {
		        // Launch the application
		        launch(args);
		    }
	

}
