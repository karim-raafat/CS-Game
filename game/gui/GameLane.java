package game.gui;
import java.util.*;
import game.engine.titans.*;

import game.engine.lanes.Lane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GameLane {
	static ImageView iv;
	static Lane lane;
	static ArrayList<GameTitan> gt = new ArrayList<>(); 
	static GameWall gw;
	static int LaneNumber;
	
	
	public GameLane(ImageView iv, Lane lane, GameWall gw) {
		this.iv = iv;
		this.lane = lane;
		this.gw= gw;
		this.LaneNumber = LaneNumber;
		
	}
//		public StackPane makelane() {
//			GridPane lane1 = new GridPane();
//			lane1.add(gw.iv,0,0);
//			lane1.add(iv,1,0);
//			StackPane sp = new StackPane();
//			int size = lane.getTitans().size();
//			ArrayList<Titan> titans = new ArrayList<>();
//			for(int i =0;i<size ;i++) {
//				Titan temp = lane.getTitans().remove();
//				GameTitan tito = new GameTitan(titanview(temp), temp,LaneNumber);
//				titans.add(temp);
//				gt.add(tito);	
//			}
//			for(int i =0;i<size ;i++) {
//				lane.addTitan(titans.get(i));
//			}
//			sp.getChildren().addAll(lane1);
//			return sp;
//		
//		}
		
		
		
		
		
				
			
			
			
			
			
			
			
			
		}
		
	
		
	

	
