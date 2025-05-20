package game.gui;




import java.util.ArrayList;
import java.util.PriorityQueue;

import game.engine.Battle;
import game.engine.lanes.Lane;
import game.engine.titans.AbnormalTitan;
import game.engine.titans.ColossalTitan;
import game.engine.titans.PureTitan;
import game.engine.titans.Titan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BattleSceneController {
	@FXML
	private Button weaponShopID;
	@FXML
	private Label scoreID;
	@FXML
	private Label turnID;	
	@FXML
	private Label phaseID;	
	@FXML
	private Label resourcesID;
	@FXML
	private Button wall_1_b;
	@FXML
	private Button wall_2_b;	
	@FXML
	private Button wall_3_b;
	@FXML
	private Button wall_4_b;	
	@FXML
	private Button wall_5_b;
	@FXML
	private Button lane_1;
	@FXML
	private Button lane_2;	
	@FXML
	private Button lane_3;
	@FXML
	private Button lane_4;
	@FXML
	private Button lane_5;
	
	public Button getLane_1() {
		return lane_1;
	}
	public Button getLane_2() {
		return lane_2;
	}
	public Button getLane_3() {
		return lane_3;
	}
	@FXML Button next_turn_id;
	public Button getNext_turn_id() {
		return next_turn_id;
	}
	@FXML 
	Button purchase_btn_id;
	@FXML 
	Button skip_btn_id;
	@FXML
	Pane laneTit_1;
	@FXML
	Pane laneTit_2;	
	@FXML
	Pane laneTit_3;
	@FXML 
	Pane laneTit_4;
	@FXML 
	Pane laneTit_5;
	
	@FXML 
	VBox weaponsLane_1;
	@FXML 
	VBox weaponsLane_2;
	@FXML 
	VBox weaponsLane_3;
	@FXML 
	VBox weaponsLane_4;
	@FXML 
	VBox weaponsLane_5;
	
	
	
	
	private Battle battle;
	private ArrayList<Lane>  lanesArr;
	private ArrayList<Button> buttonsArr;
	private MainContoller mainController;
	private int [] numOfWeapons1 = {0,0,0,0};
	private int [] numOfWeapons2 = {0,0,0,0};
	private int [] numOfWeapons3 = {0,0,0,0};
	private int [] numOfWeapons4 = {0,0,0,0};
	private int [] numOfWeapons5 = {0,0,0,0};



	public void setMainController(MainContoller mainController) {
		this.mainController = mainController;
	}
	private Lane laneTurn;
	public Lane getLaneTurn() {
		return laneTurn;
	}
	

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	private Stage stage;
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	private Scene weaponShopScene;
	//private WeaponShopView weaponShopView;
	
	public BattleSceneController(){
		ArrayList<Button> buttonsArr  = new ArrayList<Button>();
		buttonsArr.add(wall_1_b);
		buttonsArr.add(wall_2_b);
		buttonsArr.add(wall_3_b);
		
	}
	public void wallInfoClicked1(ActionEvent event){
		lanesArr = battle.getOriginalLanes();

		if (wall_1_b.getText().equals("Wall")){
			String setText =  "Wall Health " + lanesArr.get(0).getLaneWall().getCurrentHealth()+"\n"+
					"Danger Level "+lanesArr.get(0).getDangerLevel();
			wall_1_b.setText(setText);
			}
		else
			wall_1_b.setText("Wall");

	}
	
	public void wallInfoClicked2(ActionEvent event){
		lanesArr = battle.getOriginalLanes();

		if (wall_2_b.getText().equals("Wall")){
			String setText =  "Wall Health " + lanesArr.get(1).getLaneWall().getCurrentHealth()+"\n"+
					"Danger Level "+lanesArr.get(1).getDangerLevel();
			wall_2_b.setText(setText);
			}
		else
			wall_2_b.setText("Wall");

	}
	public void wallInfoClicked3(ActionEvent event){
		lanesArr = battle.getOriginalLanes();

		if (wall_3_b.getText().equals("Wall")){
			String setText =  "Wall Health " + lanesArr.get(2).getLaneWall().getCurrentHealth()+"\n"+
					"Danger Level "+lanesArr.get(2).getDangerLevel();
			wall_3_b.setText(setText);
			}
		else
			wall_3_b.setText("Wall");

	}
	public void wallInfoClicked4(ActionEvent event){
		lanesArr = battle.getOriginalLanes();

		if (wall_4_b.getText().equals("Wall")){
			String setText =  "Wall Health " + lanesArr.get(3).getLaneWall().getCurrentHealth()+"\n"+
					"Danger Level "+lanesArr.get(3).getDangerLevel();
			wall_4_b.setText(setText);
			}
		else
			wall_4_b.setText("Wall");

	}
	public void wallInfoClicked5(ActionEvent event){
		lanesArr = battle.getOriginalLanes();

		if (wall_5_b.getText().equals("Wall")){
			String setText =  "Wall Health " + lanesArr.get(4).getLaneWall().getCurrentHealth()+"\n"+
					"Danger Level "+lanesArr.get(4).getDangerLevel();
			wall_5_b.setText(setText);
			}
		else
			wall_5_b.setText("Wall");

	}
		
	public void lane_1_clicked(ActionEvent event) {
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    laneTurn = battle.getOriginalLanes().get(0);
	    this.mainController.setPurchaseOn(true);

	    stage.setScene(this.weaponShopScene);

	}
	public void lane_2_clicked(ActionEvent event) {
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    laneTurn = battle.getOriginalLanes().get(1);
	    this.mainController.setPurchaseOn(true);

	    stage.setScene(weaponShopScene);

	}	
	public void lane_3_clicked(ActionEvent event) {
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    laneTurn = battle.getOriginalLanes().get(2);
	    this.mainController.setPurchaseOn(true);

		    stage.setScene(weaponShopScene);


	}
	
	public void lane_4_clicked(ActionEvent event) {
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    laneTurn = battle.getOriginalLanes().get(3);
	    this.mainController.setPurchaseOn(true);

		    stage.setScene(weaponShopScene);

	}
	
	public void lane_5_clicked(ActionEvent event) {
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    laneTurn = battle.getOriginalLanes().get(4);
	    this.mainController.setPurchaseOn(true);

		    stage.setScene(weaponShopScene);

	}
	
	public void weaponShopClicked(ActionEvent event){

	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();

	    stage.setScene(weaponShopScene);


	}
	public void setGameCurrentValues(Battle battle){
		scoreID.setText("Score " + battle.getScore());
		turnID.setText(" Turn "+battle.getNumberOfTurns() );
		phaseID.setText(" Phase "+battle.getBattlePhase());
		resourcesID.setText(" Resources "+battle.getResourcesGathered());

		
	}
	
	public void next_turn_clicked(){
		this.purchase_btn_id.setVisible(true);
		this.skip_btn_id.setVisible(true);
		this.next_turn_id.setVisible(false);
		this.lane_1.setVisible(false);
		this.lane_2.setVisible(false);
		this.lane_3.setVisible(false);
		if (this.battle.getOriginalLanes().size()==5){
			this.lane_4.setVisible(false);
			this.lane_5.setVisible(false);
		}

		

		
	}
	public void purchaseWeaponClicked(){
		addTitan();
		this.purchase_btn_id.setVisible(false);
		this.skip_btn_id.setVisible(false);
		if (battle.getLanes().contains(battle.getOriginalLanes().get(0)))
			this.lane_1.setVisible(true);
		else
			this.lane_1.setDisable(true);

		if (battle.getLanes().contains(battle.getOriginalLanes().get(1)))
			this.lane_2.setVisible(true);
		else
			this.lane_2.setDisable(true);

		if (battle.getLanes().contains(battle.getOriginalLanes().get(2)))
				this.lane_3.setVisible(true);
		else
			this.lane_3.setDisable(true);
		if (battle.getOriginalLanes().size()==5)
		{
		if (battle.getLanes().contains(battle.getOriginalLanes().get(3)))
			this.lane_4.setVisible(true);
	else
		this.lane_4.setDisable(true);
		if (battle.getLanes().contains(battle.getOriginalLanes().get(4)))
			this.lane_5.setVisible(true);
	else
		this.lane_5.setDisable(true);
		}
		if (this.battle.isGameOver())
			mainController.gameOver(this.battle.getScore(),stage);
		else
			this.next_turn_id.setVisible(true);

	}
	
	public void skipPurchaseClicked(){
		this.purchase_btn_id.setVisible(false);
		this.skip_btn_id.setVisible(false);
		this.battle.passTurn();
		addTitan();
		this.setGameCurrentValues(this.battle);
		if (this.battle.isGameOver())
			mainController.gameOver(this.battle.getScore(),stage);
		else
			this.next_turn_id.setVisible(true);

	}
	
	public void addTitan(){

		if (!battle.getOriginalLanes().get(0).isLaneLost()){
		PriorityQueue<Titan> titans = battle.getOriginalLanes().get(0).getTitans();
		PriorityQueue<Titan> tempPQ = new PriorityQueue<Titan>();
		laneTit_1.getChildren().clear();

		
		while (!titans.isEmpty()){
			VBox titVbox = new VBox();
			Titan t = titans.remove();
			tempPQ.add(t);
			int height = t.getHeightInMeters();
			int dist = t.getDistance();
			Image imageT;
			if (t instanceof PureTitan)
				 {imageT = new Image("titan_blue_j_70.jpg");
				titVbox.setPrefHeight(70);
				titVbox.setPrefWidth(70);
				 }
				 else
				 {
					 if (t instanceof AbnormalTitan)
						 {imageT = new Image("titan_ngreen_60.jpg");
							titVbox.setPrefHeight(60);
							titVbox.setPrefWidth(60);
						}
					 else
						 if (t instanceof ColossalTitan)
						 {imageT = new Image("titan_pink_100.jpg");
							titVbox.setPrefHeight(100);
							titVbox.setPrefWidth(100);
						 }
						 else{
							 imageT = new Image("titan_yellow_70.jpg");
								titVbox.setPrefHeight(70);
								titVbox.setPrefWidth(70); 
			
					 }
						 
				 }

			ImageView imageViewT = new ImageView(imageT);
			Label labelHP = new Label("HP " + t.getCurrentHealth());
			labelHP.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;-fx-font-size:9pt;");
			titVbox.getChildren().addAll(labelHP,imageViewT);	
			laneTit_1.getChildren().addAll(titVbox);
			titVbox.setLayoutX(dist*30);

		}
		
		while (!tempPQ.isEmpty()){
			titans.add(tempPQ.remove());
		}
		}
		else{
			laneTit_1.getChildren().clear();
			Label label_lost = new Label("Lane is Lost");
			label_lost.setFont(new Font(40));
			label_lost.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;");
			

			laneTit_1.getChildren().add(label_lost);
			label_lost.setLayoutX(700);
			
		}
		if (battle.getLanes().contains(battle.getOriginalLanes().get(1))){
		PriorityQueue<Titan> titans = battle.getOriginalLanes().get(1).getTitans();
		PriorityQueue<Titan> tempPQ = new PriorityQueue<Titan>();
		laneTit_2.getChildren().clear();

		
		while (!titans.isEmpty()){
			VBox titVbox = new VBox();
			Titan t = titans.remove();
			tempPQ.add(t);
			int height = t.getHeightInMeters();
			int dist = t.getDistance();
			Image imageT;
			if (t instanceof PureTitan)
				 {imageT = new Image("titan_blue_j_70.jpg");
				titVbox.setPrefHeight(70);
				titVbox.setPrefWidth(70);
				 }
				 else
				 {
					 if (t instanceof AbnormalTitan)
						 {imageT = new Image("titan_ngreen_60.jpg");
							titVbox.setPrefHeight(60);
							titVbox.setPrefWidth(60);
						}
					 else
						 if (t instanceof ColossalTitan)
						 {imageT = new Image("titan_pink_100.jpg");
							titVbox.setPrefHeight(100);
							titVbox.setPrefWidth(100);
						 }
						 else{
							 imageT = new Image("titan_yellow_70.jpg");
								titVbox.setPrefHeight(70);
								titVbox.setPrefWidth(70); 
			
					 }
						 
				 }

			ImageView imageViewT = new ImageView(imageT);
			Label labelHP = new Label("HP " + t.getCurrentHealth());
			labelHP.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;-fx-font-size:9pt;");
			titVbox.getChildren().addAll(labelHP,imageViewT);				
			laneTit_2.getChildren().addAll(titVbox);

			titVbox.setLayoutX(dist*30);


		}
		while (!tempPQ.isEmpty()){
			titans.add(tempPQ.remove());
		}
		}
		else{
			laneTit_2.getChildren().clear();
			Label label_lost = new Label("Lane is Lost");
			label_lost.setFont(new Font(40));
			label_lost.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;");
			

			laneTit_2.getChildren().add(label_lost);
			label_lost.setLayoutX(700);
			
		}
		if (battle.getLanes().contains(battle.getOriginalLanes().get(2))){
		PriorityQueue<Titan> titans = battle.getOriginalLanes().get(2).getTitans();
		PriorityQueue<Titan> tempPQ = new PriorityQueue<Titan>();
		laneTit_3.getChildren().clear();

		
		while (!titans.isEmpty()){
			VBox titVbox = new VBox();
			Titan t = titans.remove();
			tempPQ.add(t);
			int height = t.getHeightInMeters();
			int dist = t.getDistance();
			Image imageT;
			if (t instanceof PureTitan)
				 {imageT = new Image("titan_blue_j_70.jpg");
				titVbox.setPrefHeight(70);
				titVbox.setPrefWidth(70);
				 }
				 else
				 {
					 if (t instanceof AbnormalTitan)
						 {imageT = new Image("titan_ngreen_60.jpg");
							titVbox.setPrefHeight(60);
							titVbox.setPrefWidth(60);
						}
					 else
						 if (t instanceof ColossalTitan)
						 {imageT = new Image("titan_pink_100.jpg");
							titVbox.setPrefHeight(100);
							titVbox.setPrefWidth(100);
						 }
						 else{
							 imageT = new Image("titan_yellow_70.jpg");
								titVbox.setPrefHeight(70);
								titVbox.setPrefWidth(70); 
			
					 }
						 
				 }

			ImageView imageViewT = new ImageView(imageT);
			Label labelHP = new Label("HP " + t.getCurrentHealth());
			labelHP.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;-fx-font-size:9pt;");
			titVbox.getChildren().addAll(labelHP,imageViewT);				
			laneTit_3.getChildren().addAll(titVbox);

			titVbox.setLayoutX(dist*30);


		}
		while (!tempPQ.isEmpty()){
			titans.add(tempPQ.remove());
		}
		}
		else{
			laneTit_3.getChildren().clear();
			Label label_lost = new Label("Lane is Lost");
			label_lost.setFont(new Font(40));
			label_lost.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;");
			

			laneTit_3.getChildren().add(label_lost);
			label_lost.setLayoutX(700);
			
		}

		if (this.battle.getOriginalLanes().size()==5){
		if (battle.getLanes().contains(battle.getOriginalLanes().get(3))){
			PriorityQueue<Titan> titans = battle.getOriginalLanes().get(3).getTitans();
			PriorityQueue<Titan> tempPQ = new PriorityQueue<Titan>();
			laneTit_4.getChildren().clear();

			while (!titans.isEmpty()){
				VBox titVbox = new VBox();
				Titan t = titans.remove();
				tempPQ.add(t);
				int height = t.getHeightInMeters();
				int dist = t.getDistance();
				Image imageT;
				if (t instanceof PureTitan)
					 {imageT = new Image("titan_blue_j_70.jpg");
					titVbox.setPrefHeight(70);
					titVbox.setPrefWidth(70);
					 }
					 else
					 {
						 if (t instanceof AbnormalTitan)
							 {imageT = new Image("titan_ngreen_60.jpg");
								titVbox.setPrefHeight(60);
								titVbox.setPrefWidth(60);
							}
						 else
							 if (t instanceof ColossalTitan)
							 {imageT = new Image("titan_pink_100.jpg");
								titVbox.setPrefHeight(100);
								titVbox.setPrefWidth(100);
							 }
							 else{
								 imageT = new Image("titan_yellow_70.jpg");
									titVbox.setPrefHeight(70);
									titVbox.setPrefWidth(70); 
				
						 }
							 
					 }


				ImageView imageViewT = new ImageView(imageT);
				Label labelHP = new Label("HP " + t.getCurrentHealth());
				labelHP.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;-fx-font-size:9pt;");
				titVbox.getChildren().addAll(labelHP,imageViewT);				
				laneTit_4.getChildren().addAll(titVbox);
				titVbox.setLayoutX(dist*30);

			}
			while (!tempPQ.isEmpty()){
				titans.add(tempPQ.remove());
			}
			}
		else{
			laneTit_4.getChildren().clear();
			Label label_lost = new Label("Lane is Lost");
			label_lost.setFont(new Font(40));
			label_lost.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;");
			laneTit_4.getChildren().add(label_lost);
			label_lost.setLayoutX(700);
			
		}
		if (battle.getLanes().contains(battle.getOriginalLanes().get(4))){
			PriorityQueue<Titan> titans = battle.getOriginalLanes().get(4).getTitans();
			PriorityQueue<Titan> tempPQ = new PriorityQueue<Titan>();
			laneTit_5.getChildren().clear();

			while (!titans.isEmpty()){
				VBox titVbox = new VBox();
				Titan t = titans.remove();
				tempPQ.add(t);
				int height = t.getHeightInMeters();
				int dist = t.getDistance();
				Image imageT;
				if (t instanceof PureTitan)
					 {imageT = new Image("titan_blue_j_70.jpg");
					titVbox.setPrefHeight(70);
					titVbox.setPrefWidth(70);
					 }
					 else
					 {
						 if (t instanceof AbnormalTitan)
							 {imageT = new Image("titan_ngreen_60.jpg");
								titVbox.setPrefHeight(60);
								titVbox.setPrefWidth(60);
							}
						 else
							 if (t instanceof ColossalTitan)
							 {imageT = new Image("titan_pink_100.jpg");
								titVbox.setPrefHeight(100);
								titVbox.setPrefWidth(100);
							 }
							 else{
								 imageT = new Image("titan_yellow_70.jpg");
									titVbox.setPrefHeight(70);
									titVbox.setPrefWidth(70); 
				
						 }
							 
					 }


				ImageView imageViewT = new ImageView(imageT);
				Label labelHP = new Label("HP " + t.getCurrentHealth());
				labelHP.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;-fx-font-size:9pt;");
				titVbox.getChildren().addAll(labelHP,imageViewT);				
				laneTit_5.getChildren().addAll(titVbox);
				titVbox.setLayoutX(dist*30);

			}
			while (!tempPQ.isEmpty()){
				titans.add(tempPQ.remove());
			}
			}
		else{
			laneTit_5.getChildren().clear();
			Label label_lost = new Label("Lane is Lost");
			label_lost.setFont(new Font(40));
			label_lost.setStyle("-fx-font-family: 'Cooper Black'; -fx-text-fill: #002D62;");
			laneTit_5.getChildren().add(label_lost);
			label_lost.setLayoutX(700);
			
		}
		}

			
	}
	public void setLanesButtons(){
		lane_1.setVisible(false);
		lane_2.setVisible(false);
		lane_3.setVisible(false);
		if (this.battle.getOriginalLanes().size()==5)
		{lane_4.setVisible(false);
		lane_5.setVisible(false);}

	}
//	public void addWeaponToLane(int weaponCode, Lane lane){
//		 ImageView imgview = mainController.addWeaponImage(weaponCode);
//		 
//		if (this.battle.getOriginalLanes().get(0)==lane){
//				this.weaponsLane_1.getChildren().add(imgview);
//				}
//		else{
//			if (this.battle.getOriginalLanes().get(1)==lane){
//				this.weaponsLane_2.getChildren().add(imgview);
//				}
//			else{
//				if (this.battle.getOriginalLanes().get(2)==lane){
//					this.weaponsLane_3.getChildren().add(imgview);
//					}
//				else{
//					if (this.battle.getOriginalLanes().get(3)==lane){
//							this.weaponsLane_4.getChildren().add(imgview);
//						}
//					else
//						this.weaponsLane_5.getChildren().add(imgview);
//					}
//				}
//		}		
//						
//					
//	}
	public void laneWeaponsAdd(int weaponCode, Lane lane){
		 
		if (this.battle.getOriginalLanes().get(0)==lane){
				this.numOfWeapons1[weaponCode-1]++;
				HBox hboxT = (HBox) this.weaponsLane_1.getChildren().get(weaponCode-1);
				hboxT.setVisible(true);
				((Label)hboxT.getChildren().get(1)).setText(this.numOfWeapons1[weaponCode-1]+"");;
				}
		else{
			if (this.battle.getOriginalLanes().get(1)==lane){
				this.numOfWeapons2[weaponCode-1]++;
				HBox hboxT = (HBox) this.weaponsLane_2.getChildren().get(weaponCode-1);
				hboxT.setVisible(true);
				((Label)hboxT.getChildren().get(1)).setText(this.numOfWeapons2[weaponCode-1]+"");;
								}
			else{
				if (this.battle.getOriginalLanes().get(2)==lane){
					this.numOfWeapons3[weaponCode-1]++;
					HBox hboxT = (HBox) this.weaponsLane_3.getChildren().get(weaponCode-1);
					hboxT.setVisible(true);
					((Label)hboxT.getChildren().get(1)).setText(this.numOfWeapons3[weaponCode-1]+"");;
										}
				else{
					if (this.battle.getOriginalLanes().get(3)==lane){
						this.numOfWeapons4[weaponCode-1]++;
						HBox hboxT = (HBox) this.weaponsLane_4.getChildren().get(weaponCode-1);
						hboxT.setVisible(true);
						((Label)hboxT.getChildren().get(1)).setText(this.numOfWeapons4[weaponCode-1]+"");;
																}
					else{
						this.numOfWeapons5[weaponCode-1]++;
						HBox hboxT = (HBox) this.weaponsLane_5.getChildren().get(weaponCode-1);
						hboxT.setVisible(true);
						((Label)hboxT.getChildren().get(1)).setText(this.numOfWeapons5[weaponCode-1]+"");;
					}	}
				}
		}		
			
	}
	public void initWeapToLane(){
			VBox [] vboxArr = new VBox[5];
			vboxArr[0] = this.weaponsLane_1;
			vboxArr[1] = this.weaponsLane_2;
			vboxArr[2] = this.weaponsLane_3;
			vboxArr[3] = this.weaponsLane_4;
			vboxArr[4] = this.weaponsLane_5;
			int [][]numOfweap = new int [5][4];
			numOfweap[0] = this.numOfWeapons1;
			numOfweap[1] = this.numOfWeapons2;
			numOfweap[2] = this.numOfWeapons3;
			numOfweap[3] = this.numOfWeapons4;
			numOfweap[4] = this.numOfWeapons5;
			

			int c = this.battle.getOriginalLanes().size();
			for (int i=0;i<c;i++){
				for (int j=0;j<4;j++){
					ImageView imgview = mainController.addWeaponImage(j+1);
					HBox hbox = new HBox();
					Label num = new Label(numOfweap[i][j]+"");
					hbox.getChildren().addAll(imgview,num);
					hbox.setVisible(false);
					vboxArr[i].getChildren().addAll(hbox);
					
				}
				if (c==5)
					vboxArr[i].setPrefHeight(130);
				else
					vboxArr[i].setPrefHeight(200);

		}
	}
	
	public void setWeaponShopScene(Scene sceneWeaponShopView) {
			this.weaponShopScene = sceneWeaponShopView;
	}

}
