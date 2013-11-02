package games.slatch.managers;

import games.slatch.World;
import games.slatch.entities.Entity;

public interface Manager
{
	public void processEntity(Entity e, World world);
	public boolean canProcess(Entity e);


}
