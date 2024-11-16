package game.gui;

import game.engine.titans.Titan;
import game.engine.weapons.Weapon;
import javafx.scene.image.ImageView;

public class GameWeapon {
	ImageView iv;
	Weapon weapon;
	public GameWeapon(ImageView iv, Weapon weapon) {
		
		this.iv = iv;
		this.weapon = weapon;
	}
	
	
}
