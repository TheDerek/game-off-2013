package games.slatch;

import com.artemis.Component;
import com.artemis.Manager;
import com.artemis.systems.EntityProcessingSystem;

import games.slatch.components.Position;
import games.slatch.components.Velocity;
import games.slatch.entities.Entity;
import games.slatch.managers.Movement;



public class Level
{
	World world;
	Entity e;
	
	public Level()
	{
		world = new World();
		world.createWorld();
		
		world.addManager(new Movement());
		
		e = world.createEntity();
		e.addComp(new Position(5, 5));
		e.addComp(new Velocity(1, 1));
		
		System.out.println(e.getComp(Position.class));
		world.step();
		System.out.println(e.getComp(Position.class));

		
	}
	
	public static void main(String args[])
	{
		Level l = new Level();
	}

}
