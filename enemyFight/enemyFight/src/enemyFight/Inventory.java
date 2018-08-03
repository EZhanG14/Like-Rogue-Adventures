package PlayerVSEnemy;
import CoreAndMap.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/** feature :
 * - Sword: change damage to 3
 * - Healthbag: return full health
 * - inventory bar: Store iteams
 * - chest return 3 choices
 * @author zhaoning meng
 */
public class Inventory{ 
	
	private int phealth=10;
	private int pdamage=1;
	private int chestchose=0;
	
	ImageView sworda=new ImageView();
	private Image sword = new Image("file:sword.jpg");
	
    ImageView healthbag=new ImageView(); 
    private Image health=new Image("file:health.png");
    
    ImageView inventory=new ImageView();
	private Image inventorybar=new Image("file:inventorybar.png");
	/**Those method in which add Image to the Core
	 * 
	 */
	Inventory(){
		
		inventory.setImage(inventorybar);
		inventory.setLayoutX(40);
    	inventory.setLayoutY(500);
    	inventory.setPreserveRatio(true);
        inventory.setFitHeight(300);
        inventory.setFitWidth(500);
        Core.layout.getChildren().add(inventory);
        
        sworda.setLayoutX(95);
	    sworda.setLayoutY(600);
	    sworda.setPreserveRatio(true);
	    sworda.setFitHeight(70);
	    sworda.setFitWidth(150);
	    sworda.setVisible(false);
	    sworda.setImage(sword);
	    Core.layout.getChildren().add(sworda);
	    
	    healthbag.setLayoutX(150);
		healthbag.setLayoutY(600);
		healthbag.setPreserveRatio(true);
		healthbag.setFitWidth(150);
		healthbag.setFitHeight(70);
		healthbag.setVisible(false);
		healthbag.setImage(health);
		Core.layout.getChildren().add(healthbag);
	}
	/** 
	 * This is the method to change the health
	*
	*/
	
	
	public void setpHealth(int a){
		if (phealth<=10)phealth=a;
	}
	  
	public int getpHealth(){
		return this.phealth;
	}
	   /**
	    * this method to change the Damage
	    * @param a
	    */
	public void setpDamage(int a) {
		     pdamage=a;
	}
	
	public int getpDamage(){
		return this.pdamage;
	}
	/**
	 * this method let chest make chose 
	 * @return 0,1,2
	 */
	public int getchestchose() {
		chestchose=(int)(Math.ceil(Math.random()*2 ));
	    return chestchose;
	}
}   
	
	 
	
	      
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	

	
	
