package games.slatch;

import games.slatch.components.Component;
import games.slatch.entities.Entity;
import games.slatch.managers.Manager;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class World
{
	private ObjectMap<Class<? extends Component>, Component> components;
	private ObjectMap<Class<? extends Manager>, Manager> managers;
	
	private Array<Entity> entites;
	
	public World()
	{
		
	}
	
	
	public void createWorld()
	{
		components = new ObjectMap<>();
		managers = new ObjectMap<>();
		entites = new Array<>();
	}
	
	public void step()
	{
		for(Entity e : entites)
		{
			for(Manager man : managers.values())
			{
				if(man.canProcess(e))
					man.processEntity(e);
			}
		}
	}
	
	public void addManager(Manager m)
	{
		managers.put(m.getClass(), m);
	}
	
	
	public Entity createEntity()
	{
		Entity e = new Entity(this);
		entites.add(e);
		return e;
		
	}

}
