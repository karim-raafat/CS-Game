package game.gui;

import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import javafx.scene.image.ImageView;

public class GameTitan {
	ImageView iv;
	Titan titan;
	static int Yaxis;
	public GameTitan(ImageView iv, Titan titan) {
		this.iv = iv;
		this.titan = titan;
		this.Yaxis = Yaxis;
	}
}
	