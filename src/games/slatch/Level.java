package games.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.ObjectMap;
import games.platformer.entites.Entity;
import games.platformer.entites.Player;
import games.platformer.interfaces.Physical;
import games.platformer.interfaces.Updateable;
import games.platformer.misc.Physics;
import games.platformer.misc.Raycast;
import games.platformer.tiles.Tile;

public class Level
{
	Array<Entity> entities;
	Array<Tile[][]> layers;
	Tile[][] tiles;

	OrthographicCamera cam;
	SpriteBatch batch;

	Pixmap map;
	Texture mapTexture;

	float GRAVITY = -0.6f;


	public Level create(int size)
	{
		entities = new Array<Entity>();

		layers = new Array<Tile[][]>();

		tiles = new Tile[size][size];
		layers.add(tiles);

		map = new Pixmap(Gdx.files.internal("data/map.png") );
		mapTexture = new Texture(map);


		cam = new OrthographicCamera(32, 24);

		cam.translate(16, 12);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.projection);

		/*for(int y = 0; y < 480; y++)
		{
			System.out.println();
			for(int x = 0; x < 640; x++)
			{
				System.out.print(" " + map.getPixel(x, y) + " ");
			}
		}*/


		return this;
	}

	public void render()
	{
		Gdx.gl.glClearColor(0.7f, 0.7f, 1.0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		cam.update();

		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(mapTexture, 0, 0, 32, 24);


		for(Tile[][] layer : layers)
			for(int y = 0; y < layer.length; y++)
				for(int x = 0; x < layer[y].length; x++)
				{
					if(tiles[y][x] != null)
						tiles[y][x].render(batch, cam);
				}

		for(Entity e : entities)
			e.render(batch, cam);

		batch.end();



	}

	public void update()
	{
		float delta = 1/60f;


		for(Tile[][] layer : layers)
			for(int y = 0; y < layer.length; y++)
				for(int x = 0; x < layer[y].length; x++)
				{
					if(tiles[y][x] != null)
						tiles[y][x].update(delta);
				}

		for(Entity e : entities)
		{
			if(e instanceof Updateable)
				e.update(delta);

			if(e instanceof Physical)
			{
				Physics.applyPhysics(e, GRAVITY * delta);
				Physics.applyCollision(e, map);

			}


		}
	}

	public void addTile(Texture t, int x, int y, int layer)
	{
		layers.get(layer)[y][x] = new Tile().create(x, y, t);
	}

	public void addEntity(Texture t, float x, float y, float width, float height)
	{
		Entity e = new Entity();
		e.create(new Vector2(x, y), new Vector2(width, height), t);
		entities.add(e);
	}

	public void addPlayer(Texture t, float x, float y, float width, float height, IntMap<Entity.Movement> controlScheme)
	{
		Player e = new Player();
		e.create(new Vector2(x, y), new Vector2(width, height), t, controlScheme);
		entities.add(e);
	}



}
