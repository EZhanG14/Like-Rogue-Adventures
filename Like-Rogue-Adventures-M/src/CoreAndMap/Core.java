package CoreAndMap;
import PlayerVSEnemy.*;

import javafx.scene.layout.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

/**Haven't found a way to check the boundaries of the window. ~Eric.Z
 * Features that are in here:
 * - Movement with WASD
 *
 * @author Eric Zhang
 * @author Gavin Guinn
 */
 
//changed player,enemy, healthbag calls to getters
public class Core extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Pane layout = new Pane();//PublicAwareness
    
    private Map map1=new Map();
    private Inventory inventory=new Inventory();
    private Player player1= new Player();
    private Enemy enemy1= new Enemy();
    private MyCanvas mCanvas=new MyCanvas(WIDTH,HEIGHT);
	
	private static int pHealth = 10;
	private static int eHealth = 9;
	private int chestchose=0;
	private boolean attack=false;
	private int moveRes=1;
	private double deltaX=0;
	private double deltaY=0;
    
	private static final int WIDTH=600;
	private static final int HEIGHT=650;

    @Override
    public void start(Stage stage) throws InterruptedException {
    	
    	stage.setTitle("Demo 2 player Fight");
    	Scene scene = new Scene(layout, WIDTH, HEIGHT);
    
    	
    	layout.getChildren().add(mCanvas);
    	stage.setScene(scene);
    
    	map1.createMap("void");

    	stage.show();
    	
    	/**
    	 * this handles player input
    	 */
    	scene.setOnKeyPressed(e ->{
			if(e.getCode()==KeyCode.D) {
				player1.player.setImage(player1.getPlayerRight());
				deltaX=moveRes;
				deltaY=0;
			}
			
			if(e.getCode()==KeyCode.A){
				player1.player.setImage(player1.getPlayerLeft());
				deltaX=-moveRes;
				deltaY=0;
			}

    		if(e.getCode()==KeyCode.S) {
    			deltaY=moveRes;
    			deltaX=0;
    			player1.player.setImage(player1.getPlayerDown());
    		}
        	
    		if(e.getCode()==KeyCode.W) {
    			deltaY=-moveRes;
    			deltaX=0;
    			player1.player.setImage(player1.getPlayerUp());
    		}
    		
    		if(e.getCode()==KeyCode.H) {
    			if(inventory.getHealthbag().isVisible()==true) {
    				inventory.setpHealth(10);
    				inventory.getHealthbag().setVisible(false);
    				System.out.println("pHealth "+ inventory.getpHealth());
    			}
    		}
    		
    		if(e.getCode()==KeyCode.SPACE) {
    			attack=true;
    		}
    	});
    	
    	/**
    	 * this handles the main game loop
    	 */
    	AnimationTimer animator = new AnimationTimer() {
			@Override
			public void handle(long arg0){
				//int i1;
				
				player1.getDamageView().setLayoutX(-1000);
				player1.getDamageView().setLayoutY(-1000);

				for(int i=0;i<10;i++) {
			    	if (check(deltaX,deltaY)==true) {
			    		player1.player.setLayoutY(player1.player.getLayoutY()+deltaY);
			    		player1.player.setLayoutX(player1.player.getLayoutX()+deltaX);
			    	}
    	        }
				
		        deltaX=0;
		        deltaY=0;
	    	        	
	    		if (attack==true) {
		    		if (player1.player.getImage()==player1.getPlayerUp())	
		    			player1.getDamageView().setLayoutX(player1.player.getLayoutX()-20);
		    			player1.getDamageView().setLayoutY(player1.player.getLayoutY()-75);
		        		
		    		if (player1.player.getImage()==player1.getPlayerDown()) {
		    			player1.getDamageView().setLayoutX(player1.player.getLayoutX()-15);
		    			player1.getDamageView().setLayoutY(player1.player.getLayoutY()+50);
	        		}
		    		
	    	    	if (player1.player.getImage()==player1.getPlayerLeft()) {
	    	    		player1.getDamageView().setLayoutX(player1.player.getLayoutX()-75);
	    	    		player1.getDamageView().setLayoutY(player1.player.getLayoutY()-15);
	        		}
	    	    	
	    			if (player1.player.getImage()==player1.getPlayerRight()) {
	    				player1.getDamageView().setLayoutX(player1.player.getLayoutX()+50);
	    				player1.getDamageView().setLayoutY(player1.player.getLayoutY()-10);
	    		
	    			}
	    		
	    			if(player1.getDamageView().getBoundsInParent().intersects(enemy1.getEnemy().getBoundsInParent())) {
	    				System.out.println("eHealth "+ eHealth);
	        			System.out.println("pHealth "+ pHealth);
	        			System.out.println();
	    				eHealth -= inventory.getpDamage();
	    				if(eHealth <=0) {
	    			    	
	        				layout.getChildren().remove(enemy1.getEnemy());
	        				enemy1.getEnemy().setLayoutX(-10000);
	        				enemy1.getEnemy().setLayoutY(-10000);
	    				}
		    		}
	    			
	    		attack=false;
	    		}
	    	}	
	    };animator.start(); 
    }
    
    /**
     * check handles the collision detection
	 * @param xDelt distance to check ahead in the x direction
	 * @param yDelt distance to precheck in the y direction
	 * @return false if solid object in the way
	 */
    public boolean check(double xDelt,double yDelt) {
    	Bounds pBound= player1.player.getBoundsInParent();
    	
    	for( Node object: enemy1.getHostileG().getChildren()) {
    		
    		if(object.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())){
    			eHealth -= inventory.getpDamage();
    			pHealth -= 1;
    		
    			System.out.println("eHealth "+ eHealth);
    			System.out.println("pHealth "+ pHealth);
    			
    			//"Deaths of the sprites"
    			if(pHealth <=0) {
    				layout.getChildren().remove(player1.player);
    				System.out.println("You died!");
    			}
    			
    			if(eHealth <=0) {
    				layout.getChildren().remove(enemy1.getEnemy());
    				enemy1.getEnemy().setLayoutX(-10000);
    				enemy1.getEnemy().setLayoutY(-10000);
    			}
    		return false;
    		}
        }
    	
    	for( Node object: map1.walls.getChildren()) {
    		if(object.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())) return false;
    	}
    	
    	for( Node chest: map1.chests.getChildren()) {
        	if(chest.getBoundsInParent().intersects(pBound.getMinX()+xDelt, pBound.getMinY()+yDelt, pBound.getWidth(), pBound.getHeight())){
        		map1.chests.getChildren().remove(chest);
    	        chestchose=inventory.getchestchose();
    	        
    	        if(chestchose==1) {
    	        	inventory.getSworda().setVisible(true);
    	        	inventory.setpDamage(3);
    	        }
    	        if(chestchose==2) {
    	        	inventory.getHealthbag().setVisible(true);
    	        }
    	        
    	        return false;
        	} 
        }	
    	
    return true;
    }

	public static int getpHealth() {
		
		return pHealth;
	}

	public static int geteHealth() {
		
		return eHealth;
	}
}   
