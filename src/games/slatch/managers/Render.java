package games.slatch.managers;

import games.slatch.World;
import games.slatch.components.DynamicSprite;
import games.slatch.components.vectors.Position;
import games.slatch.components.vectors.Size;
import games.slatch.entities.Entity;
import games.slatch.singletons.Animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Render implements Manager
{
	private OrthographicCamera cam;
	private SpriteBatch batch;

	private DynamicSprite sprite;
	private Position position;
	private Size size;

	// A variable to avoid to many spritebatch calls
	private boolean startedRendering = false;

	public Render(float viewPortSizeX, float viewPortSizeY)
	{
		cam = new OrthographicCamera(viewPortSizeX, viewPortSizeY);

		// Sets it so (0, 0) is at the bottom left of the screen
		// cam.translate(viewPortSizeX / 2, viewPortSizeY /2);

		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.projection);
	}

	@Override
	public void processEntity(Entity e, World world)
	{
		sprite = (DynamicSprite) e.getComp(DynamicSprite.class);
		position = (Position) e.getComp(Position.class);
		size = (Size) e.getComp(Size.class);

		TextureRegion render = null;

		if (sprite.hasAnimation(sprite.getCurrentAni()))
			render = sprite.getImage(sprite.getCurrentAni(), sprite.currentTime);
		else
		{
			render = sprite.getImage(sprite.getCurrentAni().getAlt(), sprite.currentTime);
		}
		
		boolean useAlt = !sprite.hasAnimation(sprite.getCurrentAni());

		if (!startedRendering)
		{
			Gdx.gl.glClearColor(0.7f, 0.7f, 1.0f, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			cam.update();
			batch.setProjectionMatrix(cam.combined);
			batch.begin();
			startedRendering = true;
		}
		// ----Render-------------------------

		float drawSizeX = size.x;
		float drawSizeY = size.y;

		if (useAlt)
		{
			
			drawSizeX = sprite.getCurrentAni().flipX ? size.x * -1 : size.x;
			drawSizeY = sprite.getCurrentAni().flipY ? size.y * -1 : size.y;
		}

		batch.draw(
				render,
				useAlt ? (sprite.getCurrentAni().flipX ? position.x + size.x : position.x) : position.x,
				useAlt ? (sprite.getCurrentAni().flipY ? position.y + size.y : position.y) : position.y,
				size.x / 2,
				size.y / 2f,
				drawSizeX,
				drawSizeY,
				1,
				1,
				0);

		sprite.currentTime++;

		// --Stop Render-----------------------
		if (world.getEntites().indexOf(e, false) == world.getEntites().size - 1)
		{
			batch.end();
			startedRendering = false;
		}

	}

	@Override
	public boolean canProcess(Entity e)
	{
		if (e.hasComp(DynamicSprite.class) && e.hasComp(Position.class) && e.hasComp(Size.class))
			return true;
		else
			return false;
	}

}
