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
//Eric's Changes: Added getter and setter for healthbag, sworda.
public class Inventory  {
	
	private static int phealth=10;
	private int pdamage=1;
	private int chestchose=0;
	
	private ImageView sworda=new ImageView();
	private Image sword = new Image("file:sword.jpg");
	
    private ImageView healthbag=new ImageView(); 
    private Image health=new Image("file:health.png");
    
    private ImageView inventory=new ImageView();
	private Image inventorybar=new Image("file:inventorybar.png");
   
	/**Those method in which add Image to the Core
	 * 
	 */
	public Inventory(){

	
		
		
		
		inventory.setImage(inventorybar);
		inventory.setLayoutX(40);
    	inventory.setLayoutY(500);
    	inventory.setPreserveRatio(true);
        inventory.setFitHeight(300);
        inventory.setFitWidth(500);
        Core.layout.getChildren().add(inventory);
        
        getSworda().setLayoutX(95);
	    getSworda().setLayoutY(600);
	    getSworda().setPreserveRatio(true);
	    getSworda().setFitHeight(70);
	    getSworda().setFitWidth(150);
	    getSworda().setVisible(false);
	    getSworda().setImage(sword);
	    Core.layout.getChildren().add(getSworda());
	    
	    getHealthbag().setLayoutX(150);
		getHealthbag().setLayoutY(600);
		getHealthbag().setPreserveRatio(true);
		getHealthbag().setFitWidth(150);
		getHealthbag().setFitHeight(70);
		getHealthbag().setVisible(false);
		getHealthbag().setImage(health);
		Core.layout.getChildren().add(getHealthbag());
		
		
		
	}
	/** 
	 * This is the method to change the health
	*
	*/


	public void setpHealth(int a){
		if (phealth<=10)phealth=a;
	}
	  
	public static int getpHealth(){
		return phealth;
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
	public ImageView getHealthbag() {
		return healthbag;
	}
	public void setHealthbag(ImageView healthbag) {
		this.healthbag = healthbag;
	}
	public ImageView getSworda() {
		return sworda;
	}
	public void setSworda(ImageView sworda) {
		this.sworda = sworda;
	}
}   
	
	 
	
	      
	  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	

	
	
