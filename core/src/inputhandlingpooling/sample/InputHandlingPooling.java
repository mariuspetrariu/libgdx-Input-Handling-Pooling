package inputhandlingpooling.sample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class InputHandlingPooling extends ApplicationAdapter
    {
        private static final Logger             LOGGER_INFO = new Logger ( InputHandlingPooling.class.getName () , Logger.INFO );
        private static       int                displayLogger = 0;
        private              SpriteBatch        batch;
        private              BitmapFont         font;
        private              OrthographicCamera camera;
        private              Viewport           viewport;

        @Override
        public void create ()
            {
                camera = new OrthographicCamera ();
                viewport = new FitViewport ( 1080 , 720 , camera );
                batch = new SpriteBatch ();
                font = new BitmapFont ( Gdx.files.internal ( "oswald-32.fnt" ) );
            }

        @Override
        public void resize ( int width , int height )
            {
                viewport.update ( width , height , true );
            }

        @Override
        public void render ()
            {
                GdxUtils.clearScreen ();
                batch.setProjectionMatrix ( camera.combined );
                batch.begin ();
                int mouseX = Gdx.input.getX ();
                int mouseY = Gdx.input.getY ();
                if ( ( displayLogger % 60 ) == 0 )
                    {
                        LOGGER_INFO.info ( "mouse coordinates: mouse X = " + mouseX + " mouse Y = " + mouseY );
                    }
                displayLogger++;
                font.draw ( batch , "mouse coordinates: x = " + mouseX + " y = " + mouseY , 20f , 720f - 20f );
                boolean leftMouseButtonPressed  = Gdx.input.isButtonPressed ( Input.Buttons.LEFT );
                boolean rightMouseButtonPressed = Gdx.input.isButtonPressed ( Input.Buttons.RIGHT );
                font.draw ( batch , "left mouse button is" + ( leftMouseButtonPressed ? "" : "n't " ) + " pressed" , 20 , 720 - 60 );
                font.draw ( batch , "right mouse button is" + ( rightMouseButtonPressed ? "" : "n't " ) + " pressed" , 20 , 720 - 100 );
                boolean isAPressed = Gdx.input.isKeyPressed ( Input.Keys.A );
                boolean isSPressed = Gdx.input.isKeyPressed ( Input.Keys.S );
                font.draw ( batch , "A key is" + ( isAPressed ? "" : "n't " ) + " pressed" , 20 , 720 - 140 );
                font.draw ( batch , "S key is" + ( isSPressed ? "" : "n't " ) + " pressed" , 20 , 720 - 180 );
                batch.end ();
            }

        @Override
        public void dispose ()
            {
                batch.dispose ();
            }
    }
