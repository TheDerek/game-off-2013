package games.slatch.entities;

import games.slatch.World;
import games.slatch.components.Component;

import com.badlogic.gdx.utils.ObjectMap;

public class Entity
{
	private ObjectMap<Class<? extends Component>, Component> components;
	World world;
	
	public Component getComp(Class c)
	{
		return components.get(c);
	}
	
	public boolean hasComp(Class c)
	{
		return components.containsKey(c);
	}
	
	public void addComp(Component c)
	{
		components.put(c.getClass(), c);
	}
	
	public Entity(World world)
	{
		this.world = world;
		components = new ObjectMap<>();
	}

}
