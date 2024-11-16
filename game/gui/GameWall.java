package game.gui;

import game.engine.base.Wall;
import game.engine.titans.Titan;
import javafx.scene.image.ImageView;

public class GameWall {
	ImageView iv;
	Wall wall;
	public GameWall(Wall wall, ImageView iv) {
		this.iv = iv;
		this.wall = wall;
	}
	
	public void setImageView(ImageView iv) {
		this.iv = iv;
	}
	
	
	
}
