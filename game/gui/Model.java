package game.gui;
import java.io.IOException;

import game.engine.Battle;
import game.engine.weapons.WeaponRegistry;
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
public class Model {
	
	public Battle startbattle(String diff) throws IOException
	{
		if(diff == "EASY")
		{
			Battle b= new Battle(1, 0, 1200, 3,250);
			return b;
		}
		
		else
		{
			Battle b = new Battle(1, 0, 1200, 5,125);
			return b;
		}		
	}
	
	public String weaponinfo(WeaponRegistry x)
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
	

}


