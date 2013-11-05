package games.slatch;

import games.slatch.components.Controller;
import games.slatch.components.DynamicSprite;
import games.slatch.components.StaticSprite;
import games.slatch.components.vectors.Position;
import games.slatch.components.vectors.Size;
import games.slatch.components.vectors.Velocity;
import games.slatch.entities.Entity;
import games.slatch.managers.Input;
import games.slatch.managers.Movement;
import games.slatch.managers.Render;
import games.slatch.singletons.Animations;
import games.slatch.singletons.KeyMaps;

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
		world.addManager(new Render(4, 3));
		world.addManager(new Input());
		world.setDelta(1/60f);
		
		e = world.createEntity();
		e.addComp(new Position(0, 0));
		e.addComp(new Velocity(0, 0));
		e.addComp(new Size(0.8f, 1));
		e.addComp(new Controller(KeyMaps.getInstance().player1));
		
		DynamicSprite sprite = DynamicSprite.create("assests/slatch_idle");
		sprite.putAnimation("assests/slatch_walk", Animations.walkRight);
		sprite.putAnimation("assests/slatch_idle", Animations.idleRight);
		sprite.putAnimation("assests/slatch_airborn", Animations.fallRight);
		e.addComp(sprite);
	
	
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
