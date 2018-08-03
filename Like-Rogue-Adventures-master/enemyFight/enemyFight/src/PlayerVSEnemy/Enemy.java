package PlayerVSEnemy;
import CoreAndMap.*;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy {
	Group hostileG = new Group();
	 private Image enemySprite = new Image("file:frown.png");
	 ImageView enemy = new ImageView();
	 Enemy(){
		enemy.setLayoutX(400);
    	enemy.setLayoutY(400);	
    	enemy.setImage(enemySprite);
    	hostileG.getChildren().add(enemy);
    	Core.layout.getChildren().add(hostileG);
    	
	 
	 }

}
