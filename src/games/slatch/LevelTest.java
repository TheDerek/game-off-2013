package games.slatch;

import com.artemis.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.ObjectMap;

public class LevelTest
{
	OrthographicCamera cam;
	SpriteBatch batch;
	Pixmap map;
	Texture mapTexture;
	float GRAVITY = -0.6f;

	World world;

	public LevelTest create(int size)
	{

		cam = new OrthographicCamera(32, 24);

		cam.translate(16, 12);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.projection);

		return this;
	}

	public void render()
	{
		Gdx.gl.glClearColor(0.7f, 0.7f, 1.0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		//----Render-------------------------
		
		
		//--Stop Render-----------------------
		batch.end();

	}

	public void update()
	{
		float delta = 1/60f;	
	}

}
