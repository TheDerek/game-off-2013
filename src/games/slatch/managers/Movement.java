package games.slatch.managers;

import com.badlogic.gdx.math.Vector2;

import games.slatch.World;
import games.slatch.components.vectors.Position;
import games.slatch.components.vectors.Velocity;
import games.slatch.entities.Entity;

public class Movement implements Manager
{
	Velocity v;
	Position p;
	
	private float damping = 0.95f;
	private float gravity = 0f;

	@Override
	public void processEntity(Entity e, World world)
	{
		v = (Velocity) e.getComp(Velocity.class);
		p = (Position) e.getComp(Position.class);
		
		v.add(new Vector2(0, world.getDelta() * gravity));
		
		v.scl(damping);
		p.add(v.cpy().scl(world.getDelta()));
		

	}

	@Override
	public boolean canProcess(Entity e)
	{
		if (e.hasComp(Position.class) && e.hasComp(Velocity.class))
			return true;
		else
			return false;
	}

}
