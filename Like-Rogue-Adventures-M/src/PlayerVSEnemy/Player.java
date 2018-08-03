package PlayerVSEnemy;
import CoreAndMap.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Erics changes: added getters and setters for every instance variables.
public class Player{
	private ImageView damageView = new ImageView();
    public ImageView player = new ImageView(); //PublicAwareness
    
	private Image playerSprite = new Image("file:linkDown.png");
	
	private Image playerRight = new Image("file:linkRight.png");
	private Image playerLeft = new Image("file:linkLeft.png");
    private Image playerDown = new Image("file:linkDown.png");
    private Image playerUp = new Image("file:linkUp.png");
	private Image damage=new Image ("file:damage.png");
	
	public Player(){
		getDamageView().setImage(damage);

    	player.setLayoutX(350);
    	player.setLayoutY(350);
    	player.setImage(playerSprite);
    	
    	Core.layout.getChildren().add(player);
    	Core.layout.getChildren().add(getDamageView());
	}

	public Image getPlayerRight() {
		return playerRight;
	}

	public void setPlayerRight(Image playerRight) {
		this.playerRight = playerRight;
	}
  
	public Image getPlayerLeft() {
		return playerLeft;
	}

	public void setPlayerLeft(Image playerLeft) {
		this.playerLeft = playerLeft;
	}
	public Image getPlayerDown() {
		return playerDown;
	}

	public void setPlayerDown(Image playerDown) {
		this.playerDown = playerDown;
	}
	public Image getPlayerUp() {
		return playerUp;
	}

	public void setPlayerUp(Image playerUp) {
		this.playerUp = playerUp;
	}

	public ImageView getDamageView() {
		return damageView;
	}

	public void setDamageView(ImageView damageView) {
		this.damageView = damageView;
	}
	
}
