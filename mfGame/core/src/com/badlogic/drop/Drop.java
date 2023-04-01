package com.badlogic.drop;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
   

   @Override
   public void create() {
      // load the images for the droplet and the bucket, 64x64 pixels each

      textboxImage = new Texture(Gdx.files.internal("textbox.png"));
      // load the drop sound effect and the rain background "music"
      dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
      rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

      // start the playback of the background music immediately
      rainMusic.setLooping(true);
      rainMusic.play();

      // create the camera and the SpriteBatch
      camera = new OrthographicCamera();
      camera.setToOrtho(false, 800, 480);
      batch = new SpriteBatch();

      textbox = new Rectangle();
      textbox.x = 90;
      textbox.y = 20;
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
    
      batch.draw(textboxImage, textbox.x, textbox.y);
  
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
