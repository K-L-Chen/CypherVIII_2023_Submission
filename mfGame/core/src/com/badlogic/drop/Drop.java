package com.badlogic.drop;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class Drop extends ApplicationAdapter {
   private Texture textboxImage;
   private Sound dropSound;
   private Music rainMusic;
   private SpriteBatch batch;
   private OrthographicCamera camera;
   private Rectangle textbox;
   private long lastDropTime;      
   private BitmapFont font;
   private Texture texture;
   private Sprite backgroundSprite;
   private SpriteBatch spriteBatch;
   
   
   
   
   float screenWidth = 1920;
   float screenHeight = 1080;
   
   public void renderBackground() {
       backgroundSprite.draw(spriteBatch);
   }
   @Override
   public void create() {
	   
	  font = new BitmapFont();   
      // load the images for the droplet and the bucket, 64x64 pixels each
 
	  texture = new Texture(Gdx.files.internal("textbox.png"));
	  backgroundSprite =new Sprite(texture);
	  
	  
      // load the drop sound effect and the rain background "music"
      dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
      rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

      // start the playback of the background music immediately
      rainMusic.setLooping(true);
      rainMusic.play();

      // create the camera and the SpriteBatch
      camera = new OrthographicCamera();
      // 1920×1080
      
      camera.setToOrtho(false, screenWidth, screenHeight);
      batch = new SpriteBatch();

   }

   @Override
   public void render() {
      // clear the screen with a dark blue color. The
      // arguments to clear are the red, green
      // blue and alpha component in the range [0,1]
      // of the color to be used to clear the screen.
      ScreenUtils.clear(0, 0, 0.2f, 1);

      // tell the camera to update its matrices.
      camera.update();

      // tell the SpriteBatch to render in the
      // coordinate system specified by the camera.
      batch.setProjectionMatrix(camera.combined);

      // begin a new batch and draw the bucket and
      // all drops
      batch.begin();
      batch.draw(texture, 0, 0, 1920, 540);
//      font.setScale(.2f);
      font.draw(batch, "hello", 500, 500);
      batch.end();


   }

   @Override
   public void dispose() {
      // dispose of all the native resources
      textboxImage.dispose();
      dropSound.dispose();
      rainMusic.dispose();
      batch.dispose();
   }
}
