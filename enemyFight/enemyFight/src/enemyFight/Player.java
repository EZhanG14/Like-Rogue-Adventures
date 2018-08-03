package enemyFight;
import CoreAndMap.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player{
	ImageView damageView = new ImageView();
    ImageView player = new ImageView();
    
	private Image playerSprite = new Image("file:linkDown.png");
	
	Image playerRight = new Image("file:linkRight.png");
	Image playerLeft = new Image("file:linkLeft.png");
    Image playerDown = new Image("file:linkDown.png");
    Image playerUp = new Image("file:linkUp.png");
	Image damage=new Image ("file:damage.png");
	
	Player(){
		damageView.setImage(damage);

    	player.setLayoutX(350);
    	player.setLayoutY(350);
    	player.setImage(playerSprite);
    	
    	Core.layout.getChildren().add(player);
    	Core.layout.getChildren().add(damageView);
	}
  
}
