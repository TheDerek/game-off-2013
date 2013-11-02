package games.slatch.managers;

import com.artemis.Component;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Mapper;
import com.badlogic.gdx.math.Vector2;

import games.slatch.components.Position;
import games.slatch.components.Velocity;
import games.slatch.entities.Entity;

public class Movement implements Manager
{
	Velocity v;
	Position p;
	

	@Override
	public void processEntity(Entity e)
	{
		v = (Velocity) e.getComp(Velocity.class);
		p = (Position) e.getComp(Position.class);
		
		p.add(v);

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
