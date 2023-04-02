package com.badlogic.drop;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.drop.battlesystem.Battle;
import com.badlogic.drop.battlesystem.Battler;
import com.badlogic.drop.battlesystem.KeyboardWarrior;
import com.badlogic.drop.battlesystem.MechaResLife;
import com.badlogic.drop.battlesystem.CompSciMageor;
import com.badlogic.drop.battlesystem.OpenSourceBanbit;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Drop extends ApplicationAdapter {
   private Texture textboxImage;
   //private Sound dropSound;
   //private Music rainMusic;
   private Sound mechaResLife;
   private SpriteBatch batch;
   private OrthographicCamera camera;
   private Rectangle textbox;
   //private long lastDropTime;      
   private BitmapFont font;
   private Texture texture;
   private StringBuffer buf;     
   private FileHandle handle;
   private BufferedReader reader;
   
   
   private Texture enemy;
   private Texture enemy_ko;
   private Texture robot;
   private Texture robot_ko;
   private Sound explosion;
   
   //top half of the screen
   //private Texture bg;
   //private Texture fg;
   
   private Sprite backgroundSprite;
   private SpriteBatch spriteBatch;
   private String message;
   public static Texture backgroundTexture;
   
   private Battler playerclass;
   
   final float screenWidth = 1920;
   final float screenHeight = 1080;
   //inner box height and width
   final float[] ibWidth = new float[]{192,1728};
   final float[] ibHeight = new float[]{420,120};
   //Label label;
   
   //flag for swapping between dialogue and combat sequences
   private boolean in_combat = false;
   private boolean in_choice = false;
   private int iter = 0;
   private Battle curBattle;
   private ArrayList<Battler> entities;
   
   private boolean player_isDead = false;
   
   public void renderBackground() {
       backgroundSprite.draw(spriteBatch);
   }
   
   @Override
   public void create() {
	   
	  font = new BitmapFont();
      // load the images for the droplet and the bucket, 64x64 pixels each
	  font.getData().scale(5); //4,5 is good size
	  
	  texture = new Texture(Gdx.files.internal("textbox.png"));
	  backgroundTexture = new Texture(Gdx.files.internal("rizlife.jpg"));
	
	  backgroundSprite =new Sprite(texture);
	  enemy = new Texture(Gdx.files.internal("Waitlisted.png"));
	  enemy_ko = new Texture(Gdx.files.internal("Waitlisted2.png"));
	  robot = new Texture(Gdx.files.internal("reslifemechaboss.png"));
	  robot_ko = new Texture(Gdx.files.internal("png-transparent-red-and-brown-explosion-illustration-nuclear-explosion-mushroom-cloud-explosion-photography-explosion-digital-image.png"));
	  
	  
	  handle = Gdx.files.local("script.txt");
	  reader = new BufferedReader(new InputStreamReader(handle.read()));
	  
	  message = "Previously on Housing Royale...";
	  
      // load the drop sound effect and the rain background "music"
      //dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
      //rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
      explosion = Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));
	  mechaResLife = Gdx.audio.newSound(Gdx.files.internal("reslifemechboss.wav"));

      // start the playback of the background music immediately
      //rainMusic.setLooping(true);
      //rainMusic.play();

      // create the camera and the SpriteBatch
      camera = new OrthographicCamera();
      // 1920×1080
      
      camera.setToOrtho(false, screenWidth, screenHeight);
      batch = new SpriteBatch();
      
      //USING LABELS REQUIRES USE OF stage()
      
      //LabelStyle style = new LabelStyle();
      //style.font = font;
      //style.fontColor = Color.RED;
      
      //style.background = new TextureRegionDrawable(new TextureRegion(texture));
      //label = new Label(message, style);
      //label.setBounds(ibWidth[0], ibWidth[1], ibHeight[0], ibHeight[1]);
      //label.setFontScale(5f);
      playerclass = null;
   }

   @Override
   public void render() {
      // clear the screen with a dark blue color. The
      // arguments to clear are the red, green
      // blue and alpha component in the range [0,1]
      // of the color to be used to clear the screen.
      ScreenUtils.clear(0, 0, 0.2f, 1);
      
      //active screen size update, depreciated as it doesn't change
      //regardless of fullscreen or not
      /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int swidth = (int)screenSize.getWidth();
      int slength = (int)screenSize.getHeight();*/
      //System.out.println(swidth + ", " + slength);
      
   // tell the camera to update its matrices.
      camera.update();
            
      // tell the SpriteBatch to render in the
      // coordinate system specified by the camera.
      batch.setProjectionMatrix(camera.combined);
      //font.getData().scale(1);
      
      // begin a new batch and draw the bucket and
      // all drops	
      batch.begin();
      batch.draw(backgroundTexture, 0 , 0, screenWidth, screenHeight);
      batch.draw(texture, 0, 0, screenWidth, screenHeight / 2);//swidth, slength / 3); //1920, 540
      //batch.addActor(label);
      //font.getData().scale(20);
      font.setColor(Color.RED);
      font.draw(batch, message, ibWidth[0], ibHeight[0]);
      //font.draw(batch, "hello", swidth / 2, slength / 4, 0, 0, lastDropTime, 0, false);
      batch.end();
      
      if(!in_combat && !in_choice && Gdx.input.isKeyPressed(Keys.SPACE)) {
    	  updateMSG();
    	  long time = System.currentTimeMillis();
    	  //spin
    	  while(System.currentTimeMillis() < time + 250) {}
      }
      else if(in_combat) {
    	  //setup combat sequence thing
    	  combatMSG();
    	  //win combat sequence for debugging
    	  if(iter == 3) {
    		  backgroundTexture = robot;
    	  }
    	  if(player_isDead) {
			  System.out.println("You died! Press a button to exit (crash)");
			  message = "You died! Click to exit (crash)";
			  //crash the game lmfao
			  if(Gdx.input.isTouched()) {
				  throw new ArithmeticException();
			  }
		  }
    	  else {
	    	  if(Gdx.input.isKeyPressed(Keys.L)) {
	    		  in_combat = false;
	    		  updateMSG();
	    	  }
	    	  //insert call to battle classes here:
	    	  //	new battle obj
	    	  //	includes player, battle number, enemies (1,2)
	    	  //	make two enemies for battle 2 (random class)
	    	  //while player is alive or all enemies are alive
	    	  //	player goes first (getPlayerAction)
	    	  //    scan for input (action), then target
	    	  //	save as integers
	    	  //	call getPlayerAction(action, target)
	    	  //	if entity = target,
	    	  //		act on entity
	    	  //	
	    	  //	enemy action (getEnemyAction)
	    	  //	
	    	  //while one player and one enemy are alive
	    	  //	continue battle
	    	  //
	    	  int action = 1;
	    	  
	    	  if(Gdx.input.isKeyPressed(Keys.NUM_1)) {
	    		  action = 1;
	    	  }
	    	  else if(Gdx.input.isKeyPressed(Keys.NUM_2)) {
	    		  action = 2;
	    	  }
	    	  else if(Gdx.input.isKeyPressed(Keys.NUM_3)) {
	    		  action = 3;
	    	  }
	    	  
	    	  if(Gdx.input.isKeyPressed(Keys.NUM_2) && iter == 2) {
				  entities = curBattle.getPlayerAction(action, 2);
				  for(int i = 1; i < entities.size(); i++) {
					  if(!entities.get(i).isDefeated()) {
						  entities = curBattle.EnemyAction(entities.get(i));
					  }
				  }
	//    			  boolean player_isDead = false;
	//    			  boolean e1_isDead = false;
	//    			  boolean e2_isDead = false;
				  playerclass = entities.get(0);
				  player_isDead = playerclass.curHp <= 0;
				  for(int i = 0; i < entities.size(); i++) {
					  entities.get(i).debug();
				  }
				  boolean e1_isDead = entities.get(1).curHp <= 0;
				  boolean e2_isDead = entities.get(2).curHp <= 0;
				  
				  curBattle.enemy.isDefeated = e1_isDead;
				  curBattle.enemy2.isDefeated = e2_isDead;
				  
				  if(e1_isDead && e2_isDead) {
					  in_combat = false;
				  }
			  }
			  else {
				  entities = curBattle.getPlayerAction(action, 0);
				  if(!entities.get(1).isDefeated()) {
					  entities = curBattle.EnemyAction(entities.get(1));
				  }
				  
				  for(int i = 0; i < entities.size(); i++) {
					  entities.get(i).debug();
				  }
				  
				  playerclass = entities.get(0);
				  player_isDead = playerclass.curHp <= 0;
				  boolean e1_isDead = entities.get(1).curHp <= 0;
				  
				  curBattle.enemy.isDefeated = e1_isDead;
				  if(e1_isDead) {
					  in_combat = false;
				  }
			  }
	    	  
	    	  long time = System.currentTimeMillis();
	    	  //spin
	    	  while(System.currentTimeMillis() < time + 250) {}
    	  }
      }
      else if(in_choice) { 
    	  choiceMSG();
    	  if(Gdx.input.isKeyPressed(Keys.NUM_1)) {
    		  this.playerclass = new KeyboardWarrior(150,50);
    		  System.out.print("Class Changed");
    		  in_choice = false;
    		  updateMSG();
    	  }
    	  else if(Gdx.input.isKeyPressed(Keys.NUM_2)) {
    		  this.playerclass = new CompSciMageor(100,150);
    		  System.out.print("Class Changed");
    		  in_choice = false;
    		  updateMSG();
    	  }
    	  else if(Gdx.input.isKeyPressed(Keys.NUM_3)) {
    		  this.playerclass = new OpenSourceBanbit(100,50);
    		  System.out.print("Class Changed");
    		  in_choice = false;
    		  updateMSG();
    	  }
    	  long time = System.currentTimeMillis();
    	  //spin
    	  while(System.currentTimeMillis() < time + 250) {}
      }
      
	   
   }

   @Override
   public void dispose() {
      // dispose of all the native resources
      textboxImage.dispose();
      //dropSound.dispose();
      //rainMusic.dispose();
      batch.dispose();
      enemy.dispose();
      enemy_ko.dispose();
      robot.dispose();
      robot_ko.dispose();
   }
   
   //read a textfile and grab the next group of output text
   public String updateMSG() {
	   buf = new StringBuffer();
	   try {
       
           message = reader.readLine() + "\n" + reader.readLine();
           if(message.contains(".battle"))
           {
         	 in_combat = true;
         	 iter++;
         	 if(iter == 3) {
         		 //call the boss battle and play the boss battle noise
         		 mechaResLife.play();
         	 }
         	 message = "";
         	 //curBattle = new Battle(playerclass);
         	 switch(iter) {
         	 	case 1:
         	 		System.out.println("First fight.");
         	 		int type = (int)(Math.random() * 3 + 1);
         	 		Battler enemy = null;
         	 		switch(type) {
         	 			case 1:
         	 				enemy = new KeyboardWarrior(10,50);
         	 				break;
         	 			case 2:
         	 				enemy = new CompSciMageor(10,50);
         	 				break;
         	 			case 3:
         	 				enemy = new OpenSourceBanbit(10,50);
         	 				break;
         	 		}
         	 		curBattle = new Battle(playerclass, iter, enemy);
         	 		break;
         	 	case 2:
         	 		System.out.println("Second fight.");
         	 		int type1 = (int)(Math.random() * 3 + 1);
         	 		Battler enemy1 = null;
         	 		switch(type1) {
	         	 		case 1:
	     	 				enemy1 = new KeyboardWarrior(10,50);
	     	 				break;
	     	 			case 2:
	     	 				enemy1 = new CompSciMageor(10,50);
	     	 				break;
	     	 			case 3:
	     	 				enemy1 = new OpenSourceBanbit(10,50);
	     	 				break;
         	 		}
         	 		type1 = (int)(Math.random() * 3 + 1);
         	 		Battler enemy2 = null;
         	 		switch(type1) {
	         	 		case 1:
	     	 				enemy2 = new KeyboardWarrior(10,50);
	     	 				break;
	     	 			case 2:
	     	 				enemy2 = new CompSciMageor(10,50);
	     	 				break;
	     	 			case 3:
	     	 				enemy2 = new OpenSourceBanbit(10,50);
	     	 				break;
         	 		}
         	 		curBattle = new Battle(playerclass, iter, enemy1, enemy2);
         	 		break;
         	 	case 3:
         	 		System.out.println("Boss fight.");
         	 		Battler reslife = new MechaResLife(100,50);
         	 		curBattle = new Battle(playerclass, iter, reslife);
         	 		break;
         	 }
           }
           else if(message.contains("choice"))
           {
         	 in_choice = true;
         	 message  = "";
           }
          
        	   
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
	   return message;
   }
   
   public String combatMSG() {
	   message = "MOVES (enter 1,2,3)      HP:"+playerclass.curHp+" MP:"+playerclass.curMp+"\n\nATTACK  " + playerclass.getSkill1Name() + "  " + playerclass.getSkill2Name();
	   return message;
   }
   
   public String clashMSG(String s) {
	   message = s;
	   return message;
   }
   
   public String choiceMSG() {
	   message = "Choose a Class (enter 1,2,3):\n1:KeyboardWarrior 3:OpenSourceBanBit\n2:CompSciMageor\n";
	   return message;
   }
}
