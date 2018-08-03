package PlayerVSEnemy;
import CoreAndMap.*;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Eric's changes: Added getter and setter to Imageview enemy, hostileG.
public class Enemy {
	private Group hostileG = new Group();
	 private Image enemySprite = new Image("file:frown.png");
	 private ImageView enemy = new ImageView();
	 public Enemy(){
		getEnemy().setLayoutX(400);
    	getEnemy().setLayoutY(400);	
    	getEnemy().setImage(enemySprite);
    	getHostileG().getChildren().add(getEnemy());
    	Core.layout.getChildren().add(getHostileG());
    	
	 
	 }
	public ImageView getEnemy() {
		return enemy;
	}
	public void setEnemy(ImageView enemy) {
		this.enemy = enemy;
	}
	public Group getHostileG() {
		return hostileG;
	}
	public void setHostileG(Group hostileG) {
		this.hostileG = hostileG;
	}

}
