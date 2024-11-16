package game.gui;
	
import java.io.IOException;

import game.engine.Battle;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;


public class Main extends Application {
	static Model m = new Model();
	static Battle b;	
	String instr = "Attack on Titan: Utopia is a one-player, endless 2 , tower defense game 1 inspired by the hit anime Attack on Titan. The story of the anime revolves around how titans, gigantic humanoid creatures, emerged one day and wiped out most of humanity. The few surviving humans fled and hid behind 3 great walls that provided safe haven from the titan threats. Wall Maria is the outer wall, Wall Rose is the middle wall and Wall Sina is the inside wall. This game takes place in an imaginary scenario where the titans breached their way throughout Wall Maria and reached the northern border of Wall Rose at the Utopia District. The human forces stationed in Utopia engage the titans in battle for one last hope of preventing the titans from breaching Wall Rose. The humans fight by deploying different types of Anti-Titan weapons in order to stop the Titan’s onslaught and keep Utopia’s (and Wall Rose’s) walls safe. 1 Tower Defense Games: is a type of game where the player controls a base and the objective is to continue defending this base from incoming enemies by deploying some weapons/tools to get rid of these enemies. In our case the base we need to protect is the Utopia District Walls. 2 Endless: it means that the game will have no winning condition and the player will keep playing and defeat as many enemies as possible.";
			
	public void start(Stage primarystage) throws Exception{
		primarystage.setTitle("Attack On Titans");
	
		
		Font font = Font.loadFont(getClass().getResource("BloodScratchPersonalUse.ttf").toExternalForm(), 50);
		
		Button Start = new Button();
		Start.setTextFill(Color.rgb(168, 15, 15));
		Start.setFont(font);
		Start.setText("Start");
		Start.setPrefSize(290, 50);
		Start.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				if(Controller.diff==null)
				{
					Alert inst = new Alert(AlertType.ERROR);
					inst.setTitle("Error");
					inst.setHeaderText("Please Select a difficulty");
					inst.showAndWait();
				}
				else
				{
					try {
						b = m.startbattle(Controller.diff);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				try {
					Scene scene2 = new Scene (View.buildGame(primarystage,b));
					primarystage.setScene(scene2);
					primarystage.setMaximized(true);
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				}	
			}	
		});
		
		
		
		RadioButton Easy = new RadioButton("EASY");
		Easy.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				Controller.diff ="EASY";
			}
					
		});
		
		Easy.setTextFill(Color.WHITE);
		Easy.setFont(font);
		Easy.setText("Easy");
		Easy.setPrefSize(250, 50);
		
		RadioButton Hard = new RadioButton("HARD");
		Hard.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				Controller.diff ="HARD";
				
			}
		});	
		
		Hard.setTextFill(Color.WHITE);
		Hard.setFont(font);
		Hard.setText("Hard");
		Hard.setPrefSize(250, 100);
		Hard.setTranslateX(50);
		
		Button instructions = new Button("Instructions");
		instructions.setOnAction(new EventHandler <ActionEvent>() {

			public void handle(ActionEvent arg0) {
				Alert inst = new Alert(AlertType.INFORMATION);
				inst.setTitle("Game Instructions");
				inst.setHeaderText("Please Read the Instructions Carefully");
				inst.setContentText(instr);
				inst.showAndWait();
			}
			
			
			
			
		});
		
		ToggleGroup tg = new ToggleGroup();
		Easy.setToggleGroup(tg);
		Hard.setToggleGroup(tg);

		HBox hb = new HBox(30);
		hb.getChildren().addAll(Easy, Hard);
		hb.setAlignment(Pos.CENTER);

		
		VBox vb = new VBox(30);
		vb.getChildren().addAll(Start, hb);
		vb.setAlignment(Pos.CENTER);

		  
		BorderPane borderpane = new BorderPane();
		borderpane.setRight(instructions);
//		instructions.setTranslateX(100);
//		instructions.setTranslateY(400);

		borderpane.setCenter(vb);
		borderpane.setPadding(new Insets(500,500,500,500));
		
		Image image = new Image("aot-scary-titan-desktop-wallpaper-preview.jpg");
		BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		borderpane.setBackground(background);
		 
		 Scene scene = new Scene(borderpane,1750,1200);
			
			primarystage.setScene(scene);
			primarystage.show();
			primarystage.isMaximized();
			
			
			primarystage.show();
			
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}