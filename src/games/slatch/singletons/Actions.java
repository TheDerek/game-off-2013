package games.slatch.singletons;

import com.badlogic.gdx.math.Vector2;

public enum Actions
{
	walkRight	(Animations.walkRight, new Vector2(1, 0)),
	walkLeft	(Animations.walkLeft, new Vector2(-1, 0)),
	jump 		(Animations.jump, null);
	
	private Animations animation;
	private Vector2 direction;
	
	Actions(Animations animation, Vector2 direction)
	{
		this.animation = animation;
		this.direction = direction;
	}
	
	public Animations getAnimation()
	{
		return animation;
	}
	
	public Vector2 getDirection()
	{
		return direction;
	}
	
}
