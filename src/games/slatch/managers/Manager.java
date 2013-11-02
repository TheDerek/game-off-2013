package games.slatch.managers;

import games.slatch.entities.Entity;

public interface Manager
{
	public void processEntity(Entity e);
	public boolean canProcess(Entity e);


}
