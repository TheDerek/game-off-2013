package games.slatch;

import games.slatch.components.DynamicSprite;
import games.slatch.components.StaticSprite;
import games.slatch.components.vectors.Position;
import games.slatch.components.vectors.Size;
import games.slatch.components.vectors.Velocity;
import games.slatch.entities.Entity;
import games.slatch.managers.Movement;
import games.slatch.managers.Render;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;



public class Level implements ApplicationListener
{
	World world;
	Entity e;
	

	@Override
	public void create()
	{
		world = new World();
		world.createWorld();
		
		world.addManager(new Movement());
		world.addManager(new Render(8, 6));
		world.setDelta(1/60f);
		
		e = world.createEntity();
		e.addComp(new Position(0, 0));
		e.addComp(new Velocity(0, 0));
		e.addComp(new Size(0.8f, 1));
		e.addComp(DynamicSprite.create("assests/slatch_walk"));
	
	}

	@Override
	public void render()
	{
		world.step();
		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub
		
	}



	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}

}
