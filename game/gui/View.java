package game.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import game.engine.Battle;
import game.engine.base.Wall;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.weapons.PiercingCannon;
import game.engine.weapons.SniperCannon;
import game.engine.weapons.VolleySpreadCannon;
import game.engine.weapons.WallTrap;
import game.engine.weapons.Weapon;
import game.engine.weapons.WeaponRegistry;
import game.engine.weapons.factory.WeaponFactory;
import javafx.application.Application;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
public class View {
	static ArrayList<GameLane> gl= new ArrayList<>();
	static GridPane gplane1 = new GridPane();
	static ArrayList <Button> weaponButtons = new ArrayList<>();

	static int Yaxis[] = new int[] {-460,-295,-190,-85,15};
	

	public static BorderPane buildGame(Stage primarystage,Battle b) throws IOException
	{	
		BorderPane game = new BorderPane();
		
		
		BorderPane Shop = buildWeaponShop(b,primarystage);
		game.setTop(Shop);
		
		
		Button pass = passButton(b,primarystage);
		HBox stats = gameStats(b);
		
		HBox bottom = new HBox(20);
		bottom.getChildren().addAll(stats,pass);
		game.setBottom(bottom);
		

		game.setPadding(new Insets(0,0,0,0));
		BorderPane.setAlignment(bottom, Pos.CENTER);
		
		
		VBox allLanes = lanes(b);
		game.setCenter(allLanes);
		
		
		
		return game;
		
	}
	
	public static BorderPane buildWeaponShop(Battle b,Stage primaryStage) {
		BorderPane Shop = new BorderPane();
		Shop.setPadding(new Insets(10,20,10,100));
		
		WeaponFactory factory = b.getWeaponFactory();
		
		HashMap<Integer, WeaponRegistry> wrMap = factory.getWeaponShop();

		Image image1 = new Image("Piercing.jpg");
		Image image2 = new Image("sniper.jpg");
		Image image3 = new Image("Volleyspread .jpg");
		Image image4 = new Image("Wall trap.jpg");
		ArrayList<Image> img = new ArrayList<>();
		img.add(image1);
		img.add(image2);
		img.add(image3);
		img.add(image4);
		
		int i = 0;
		HBox hx = new HBox(50);
	
		
		for(Map.Entry<Integer, WeaponRegistry> wr : wrMap.entrySet() ) {	
			WeaponRegistry wR = wr.getValue();			
			Label weaponinfo = new Label(weaponinfo(wR));
			VBox vx = new VBox(5);
			Button buy = new Button();
			buy.setText("Buy Weapon");
			buy.setId(wR.getName());
			buy.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
						Popup p = new Popup();
						Stage c = new Stage();
						
						
						ToggleGroup tg = new ToggleGroup();
						Label inst = new Label("Please Choose a Lane");
						Button lane1 = new Button("Lane 1");
						
						Button lane2 = new Button("Lane 2");
						
						Button lane3 = new Button("Lane 3");
						
						
						
						lane1.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent arg0) {
								try {
									Controller.chosenLane = b.getOriginalLanes().get(0);
									b.purchaseWeapon(wR.getCode(), Controller.chosenLane);
								} catch (InsufficientResourcesException | InvalidLaneException e) {
									if(e instanceof InsufficientResourcesException) {
										Alert inst = new Alert(AlertType.ERROR);
										inst.setTitle("Error");
										inst.setHeaderText("You do not have enough resources to buy this weapon");
										inst.showAndWait();
									}
									if(e instanceof InvalidLaneException) {
										Alert inst = new Alert(AlertType.ERROR);
										inst.setTitle("Error");
										inst.setHeaderText("Please Select a Lane");
										inst.showAndWait();
									}
								}
								try {
									
									primaryStage.getScene().setRoot(buildGame(primaryStage,b));
								} catch (IOException e) {
								
									e.printStackTrace();
								}
								if (b.isGameOver()) {
									primaryStage.setScene(endscene(primaryStage,b));
									primaryStage.setMaximized(true);
								}
								else {
									c.close();
									primaryStage.setMaximized(true);
								}
								
								
							}
							
						});
						
						lane2.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent arg0) {
								try {
									Controller.chosenLane = b.getOriginalLanes().get(1);
									b.purchaseWeapon(wR.getCode(), Controller.chosenLane);
								} catch (InsufficientResourcesException | InvalidLaneException e) {
									if(e instanceof InsufficientResourcesException) {
										Alert inst = new Alert(AlertType.ERROR);
										inst.setTitle("Error");
										inst.setHeaderText("You do not have enough resources to buy this weapon");
										inst.showAndWait();
									}
									if(e instanceof InvalidLaneException) {
										Alert inst = new Alert(AlertType.ERROR);
										inst.setTitle("Error");
										inst.setHeaderText("Please Select a Lane");
										inst.showAndWait();
									}
								}
								try {
									primaryStage.getScene().setRoot(buildGame(primaryStage,b));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if (b.isGameOver()) {
									primaryStage.setScene(endscene(primaryStage,b));
									primaryStage.setMaximized(true);
								}
								else {
									c.close();
									primaryStage.setMaximized(true);
								}
								
							}
							
						});
						
						lane3.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent arg0) {
								try {
									Controller.chosenLane = b.getOriginalLanes().get(2);
									b.purchaseWeapon(wR.getCode(), Controller.chosenLane);
								} catch (InsufficientResourcesException | InvalidLaneException e) {
									if(e instanceof InsufficientResourcesException) {
										Alert inst = new Alert(AlertType.ERROR);
										inst.setTitle("Error");
										inst.setHeaderText("You do not have enough resources to buy this weapon");
										inst.showAndWait();
									}
									if(e instanceof InvalidLaneException) {
										Alert inst = new Alert(AlertType.ERROR);
										inst.setTitle("Error");
										inst.setHeaderText("Please Select a Lane");
										inst.showAndWait();
									}
								}
								try {
									
									primaryStage.getScene().setRoot(buildGame(primaryStage,b));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if (b.isGameOver()) {
									primaryStage.setScene(endscene(primaryStage,b));
									primaryStage.setMaximized(true);
								}
								else {
									c.close();
									primaryStage.setMaximized(true);
								}
								
							}
							
						});
						
						
						

						
							
						
						HBox hx = new HBox();
						hx.getChildren().addAll(lane1,lane2,lane3);
						VBox vx = new VBox();
						
						
					
						
						if (Controller.diff.equals("HARD")) {
							Button lane4 = new Button("Lane 4");
							
							Button lane5 = new Button("Lane 5");
							
							
							
							hx.getChildren().addAll(lane4,lane5);
							
							lane4.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent arg0) {
									try {
										Controller.chosenLane = b.getOriginalLanes().get(3);
										b.purchaseWeapon(wR.getCode(), Controller.chosenLane);
									} catch (InsufficientResourcesException | InvalidLaneException e) {
										if(e instanceof InsufficientResourcesException) {
											Alert inst = new Alert(AlertType.ERROR);
											inst.setTitle("Error");
											inst.setHeaderText("You do not have enough resources to buy this weapon");
											inst.showAndWait();
										}
										if(e instanceof InvalidLaneException) {
											Alert inst = new Alert(AlertType.ERROR);
											inst.setTitle("Error");
											inst.setHeaderText("Please Select a Lane");
											inst.showAndWait();
										}
									}
									try {
										
										primaryStage.getScene().setRoot(buildGame(primaryStage,b));
									} catch (IOException e) {
										
										e.printStackTrace();
									}
									if (b.isGameOver()) {
										primaryStage.setScene(endscene(primaryStage,b));
										primaryStage.setMaximized(true);
									}
									else {
										c.close();
										primaryStage.setMaximized(true);
									}
									
								}
								
							});
							lane5.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent arg0) {
									try {
										Controller.chosenLane = b.getOriginalLanes().get(4);
										b.purchaseWeapon(wR.getCode(), Controller.chosenLane);
									} catch (InsufficientResourcesException | InvalidLaneException e) {
										if(e instanceof InsufficientResourcesException) {
											Alert inst = new Alert(AlertType.ERROR);
											inst.setTitle("Error");
											inst.setHeaderText("You do not have enough resources to buy this weapon");
											inst.showAndWait();
										}
										if(e instanceof InvalidLaneException) {
											Alert inst = new Alert(AlertType.ERROR);
											inst.setTitle("Error");
											inst.setHeaderText("Please Select a Lane");
											inst.showAndWait();
										}
									}
									try {
										
										primaryStage.getScene().setRoot(buildGame(primaryStage,b));
									} catch (IOException e) {
										
										e.printStackTrace();
									}
									
									if (b.isGameOver()) {
										primaryStage.setScene(endscene(primaryStage,b));
										primaryStage.setMaximized(true);
									}
									else {
										c.close();
										primaryStage.setMaximized(true);
									}
									
								}
								
							});
							
						}		
						vx.getChildren().addAll(inst,hx);
						
						c.setScene(new Scene(vx));
						p.getContent().add(vx);
						p.show(c);
						c.showAndWait();
						
				}
			});			
			weaponButtons.add(buy);
			ImageView iv = new ImageView(img.get(i));
			iv.setFitWidth(280);
			iv.setFitHeight(10);
		        
			vx.getChildren().addAll(weaponinfo,buy);
			hx.getChildren().add(vx);
			i++;
		}
		i=0;	
		Shop.setCenter(hx);
		return Shop;
	}
	
	public static Popup chooseLane(Battle b,WeaponRegistry wR,Stage primaryStage) { 
		ToggleGroup tg = new ToggleGroup();
		Label inst = new Label("Please Choose a Lane");
		RadioButton lane1 = new RadioButton();
		Label lane1txt = new Label("Lane 1");
		RadioButton lane2 = new RadioButton();
		Label lane2txt = new Label("Lane 2");
		RadioButton lane3 = new RadioButton();
		Label lane3txt = new Label("Lane 3");
		
		
		lane1.setToggleGroup(tg);
		lane2.setToggleGroup(tg);
		lane3.setToggleGroup(tg);
		
		lane1.setSelected(true);
		lane2.setSelected(true);
		lane3.setSelected(true);
		
		if (lane1.isSelected())
			Controller.chosenLane = b.getOriginalLanes().get(0);
		if (lane2.isSelected())
			Controller.chosenLane = b.getOriginalLanes().get(1);
		if (lane3.isSelected())
			Controller.chosenLane = b.getOriginalLanes().get(2);
		
		HBox hx = new HBox();
		hx.getChildren().addAll(lane1,lane1txt,lane2,lane2txt,lane3,lane3txt);
		VBox vx = new VBox();
		Popup chooseLane = new Popup();
		
		if (Controller.diff.equals("HARD")) {
			RadioButton lane4 = new RadioButton();
			Label lane4txt = new Label("Lane 4");
			RadioButton lane5 = new RadioButton();
			Label lane5txt = new Label("Lane 5");
			
			lane4.setToggleGroup(tg);
			lane5.setToggleGroup(tg);
			
			lane4.setSelected(true);
			lane5.setSelected(true);
			
			if (lane4.isSelected())
				Controller.chosenLane = b.getOriginalLanes().get(3);
			if (lane5.isSelected())
				Controller.chosenLane = b.getOriginalLanes().get(4);
			hx.getChildren().addAll(lane4,lane4txt,lane5,lane5txt);
			
		}
		
		Button bt = new Button ("Confirm");
		bt.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					b.purchaseWeapon(wR.getCode(), Controller.chosenLane);
				} catch (InsufficientResourcesException | InvalidLaneException e) {
					if(e instanceof InsufficientResourcesException) {
						Alert inst = new Alert(AlertType.ERROR);
						inst.setTitle("Error");
						inst.setHeaderText("You do not have enough resources to buy this weapon");
						inst.showAndWait();
					}
					if(e instanceof InvalidLaneException) {
						Alert inst = new Alert(AlertType.ERROR);
						inst.setTitle("Error");
						inst.setHeaderText("Please Select a difficulty");
						inst.showAndWait();
					}
				}
				try {
					primaryStage.getScene().setRoot(buildGame(primaryStage,b));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				primaryStage.setMaximized(true);
			}
			
		});
		
		vx.getChildren().addAll(inst,hx,bt);
		chooseLane.getContent().add(vx);
		return chooseLane;
	}
	
	public static VBox lanes(Battle b)
	{	
		
		VBox allLanes = new VBox(0);
		Image wallimg= new Image("wall.png");
		Image laneimg = new Image("Lane.png");
		int i = 0;
		
		for (Lane lane : b.getOriginalLanes()) {
			if(!lane.isLaneLost()) {
			StackPane lane1 = new StackPane();
			GameWall gw = new GameWall(lane.getLaneWall(),new ImageView(wallimg));		
			GameLane gl = new GameLane(new ImageView(laneimg),lane,gw);
			Button wallStats = wallStatsButton(lane,b);
			GridPane titans = buildTitans(gl.lane.getTitans());
			lane1.getChildren().addAll(makelane(gl),titans);
			HBox bottom = new HBox();
			bottom.getChildren().addAll(wallStats);
			allLanes.getChildren().addAll(lane1,bottom);
			i++;
		}
		}
		
		return allLanes;         
	}
	public static Button wallStatsButton(Lane lane,Battle b) {
		Button wallStats = new Button("Wall Stats");
		Tooltip stats = new Tooltip(wallStats(lane,b));
		Tooltip.install(wallStats, stats);
		return wallStats;
	}
	
	public static String wallStats(Lane lane,Battle b) {
		ArrayList<Weapon> weapons = lane.getWeapons();
		int p = 0;
		int s = 0;
		int v = 0;
		int t = 0;
		for (Weapon w : weapons) {
			if(w instanceof PiercingCannon) 
				p++;
			if(w instanceof SniperCannon) 
				s++;
			if(w instanceof VolleySpreadCannon) 
				v++;
			if(w instanceof WallTrap) 
				t++;
		}
		String wallStats = "Wall on lane: "+(b.getOriginalLanes().indexOf(lane)+1)+"\n"+"Wall Danger Level: "+lane.getDangerLevel()+"\n"+" Piercing Cannons : "+p+"\n" +"Snuper Cannons : "+s+"\n" +"VolleySpread Cannons : "+v+"\n" + "Wall Traps : "+t+"\n"+"Wall Health : "+lane.getLaneWall().getCurrentHealth();
		
		return wallStats;
		
	}
	
	public static GridPane buildTitans(PriorityQueue<Titan> titans) {
		GridPane laneTitan = new GridPane();
		
		for(Titan titan : titans) {
			GameTitan t = new GameTitan(titanview(titan),titan);
			laneTitan.add(t.iv, 20, 20);
			t.iv.setTranslateX(titan.getDistance());
		}
		return laneTitan;
	}
	
	
	
	public static Scene endscene(Stage primaryStage,Battle b) {
		 //endscene.widthProperty().bind(Primarystage.widthProperty());
	      //  endscene.heightProperty().bind(Primarystage.heightProperty());
		BorderPane bp4 = new BorderPane();
	    Scene endscene = new Scene(bp4, 1750,1200);
        Label gameOver = new Label("Game Over :("+"\n"+ "Better luck next time :)"+"\n"+"Your Score: "+b.getScore());
        gameOver.getStyleClass().add("gameOver-label");
        gameOver.setTextFill(Color.WHITE);
        
        bp4.setCenter(gameOver);
        
        Image image = new Image("gameover.jpg.jpeg");
		BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		bp4.setBackground(background);
		
		Button tryagain = new Button();
		tryagain.setText("Try Again ;)");
		bp4.setLeft(tryagain);
		tryagain.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Main m = new Main();
				try {
					m.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		return endscene;
	}
	public static String weaponinfo(WeaponRegistry x)
	{
		String y = "Weapon Name: " + x.getName() + "\n" + "Weapon Damage: " +  x.getDamage()+ "\n"+ "Weapon Price: " +  x.getPrice();
		if(x.getCode()==1)
			y = "Weapon Type: Piercing Cannon" + "\n" + y;
		if(x.getCode()==2)
			y = "Weapon Type: Sniper Cannon" + "\n" + y;
		if(x.getCode()==3)
			y = "Weapon Type: Volley Spread Cannon" + "\n" + y;
		if(x.getCode()==4)
			y = "Weapon Type: Wall Trap" + "\n" + y;
		return y;
	}
	
	public static Button passButton(Battle b,Stage primaryStage) {
		Button pass = new Button("Pass Turn");
		pass.setPrefSize(200, 50);
		pass.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			
			public void handle(ActionEvent arg0) {
				b.passTurn();
				if(b.isGameOver()) {
					primaryStage.setScene(endscene(primaryStage,b));
					primaryStage.setMaximized(true);
				}
				else {
				try {
					primaryStage.getScene().setRoot(buildGame(primaryStage,b));
					primaryStage.setMaximized(true);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	
			}
		});
		return pass;
	}
	
	public static GridPane makelane(GameLane lane) {
		GridPane lane1 = new GridPane();
		lane1.add(lane.gw.iv,0,0);
		lane1.add(lane.iv,1,0);
		GridPane sp = new GridPane();
		int size = lane.lane.getTitans().size();
		sp.getChildren().addAll(lane1);
		return sp;
	}
	public static ImageView titanview(Titan x)
	{
		String titanStats = "Titan Health : "+x.getCurrentHealth()+"\n"+"Titan Height : "+x.getHeightInMeters()+"";
		Tooltip stats = new Tooltip(titanStats);
		if(x.getDangerLevel()==1)
		{
			Image i = new Image("pure.png");
			ImageView iv1 = new ImageView(i);
			iv1.prefHeight(5);
			iv1.prefWidth(5);
			Tooltip.install(iv1, stats);
			return iv1;
		}
		if(x.getDangerLevel()==2)
		{
			Image i = new Image("abnormal.png");
			ImageView iv1 = new ImageView(i);
			iv1.prefHeight(10);
			iv1.prefWidth(10);
			Tooltip.install(iv1, stats);
			return iv1;
		}
		if(x.getDangerLevel()==3)
		{
			Image i = new Image("armored.png");
			ImageView iv1 = new ImageView(i);
			iv1.prefHeight(10);
			iv1.prefWidth(10);
			Tooltip.install(iv1, stats);
			return iv1;
		}
		else
		{
			Image i = new Image("collosal.png");
			ImageView iv1 = new ImageView(i);
			iv1.prefHeight(100);
			iv1.prefWidth(100);
			Tooltip.install(iv1, stats);
			return iv1;
		}
		
      
	
}
	public static HBox gameStats(Battle b) {
		HBox stats = new HBox(10);
		Label score = new Label("Score: "+b.getScore());
		Label turn = new Label("Number of Turns: "+b.getNumberOfTurns());
		Label phase = new Label("Battle Phase: "+b.getBattlePhase());
		Label resources = new Label("Resources: "+b.getResourcesGathered());
		
		stats.getChildren().addAll(score,turn,phase,resources);
		return stats;
	}
}
