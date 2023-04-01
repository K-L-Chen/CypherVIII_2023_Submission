package com.badlogic.drop;

import java.awt.*;
import java.awt.event.KeyEvent;
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
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
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
import com.badlogic.drop.battlesystem.Class;
import com.badlogic.drop.battlesystem.KeyboardWarrior;
import com.badlogic.drop.battlesystem.CompSciMageor;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Drop extends ApplicationAdapter {
   private Texture textboxImage;
   private Sound dropSound;
   private Music rainMusic;
   private Sound mechaResLife;
   private SpriteBatch batch;
   private OrthographicCamera camera;
   private Rectangle textbox;
   private long lastDropTime;      
   private BitmapFont font;
   private Texture texture;
   private StringBuffer buf;     
   private FileHandle handle;
   private BufferedReader reader;
   
   //top half of the screen
   private Texture bg;
   private Texture fg;
   
   private Sprite backgroundSprite;
   private SpriteBatch spriteBatch;
   private String message;
   public static Texture backgroundTexture;
   
   private Class playerclass;
   
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
	  mechaResLife = Gdx.audio.newSound(Gdx.files.internal("reslifemechboss.wav"));
	 
	  handle = Gdx.files.local("script.txt");
	  reader = new BufferedReader(new InputStreamReader(handle.read()));
	  
	  message = "Previous on Housing Royale";
	  
      // load the drop sound effect and the rain background "music"
      dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
      rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

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
      playerclass = new KeyboardWarrior(100,100,1,1);
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
      }
      else if(in_choice) { 
    	  choiceMSG();
    	  if(Gdx.input.isKeyPressed(Keys.NUM_1)) {
    		  this.playerclass = new KeyboardWarrior(10,10,10,10);
    		  System.out.print("Class Changed");
    		  in_choice = false;
    		  updateMSG();
    	  }
    	  else if(Gdx.input.isKeyPressed(Keys.NUM_2)) {
    		  this.playerclass = new CompSciMageor(10,10,10,10);
    		  in_choice = false;
    		  updateMSG();
    	  }
    	  else if(Gdx.input.isKeyPressed(Keys.NUM_3)) {
    		  this.playerclass = new CompSciMageor(10,10,10,10);
    		  in_choice = false;
    		  updateMSG();
    	  }
      }
      
	   
   }

   @Override
   public void dispose() {
      // dispose of all the native resources
      textboxImage.dispose();
      dropSound.dispose();
      rainMusic.dispose();
      batch.dispose();
   }
   
   //read a textfile and grab the next group of output text
   public String updateMSG() {
	   buf = new StringBuffer();
	   try {
       
           message = reader.readLine() + "\n" + reader.readLine();
           if(message.contains("battle"))
           {
         	 in_combat = true;
         	 message = "";
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
	   message = "MOVES (enter 1,2,3):\n\nATTACK  " + playerclass.getSkill1Name() + "  " + playerclass.getSkill2Name();
	   return message;
   }
   
   public String choiceMSG() {
	   message = "Choose a Class (enter 1,2,3):\n1:KeyboardWarrior 3:OpenSourceBandit\n2:CompSciMageor\n";
	   return message;
   }
}
