package games.slatch.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import games.slatch.World;
import games.slatch.components.Controller;
import games.slatch.components.DynamicSprite;
import games.slatch.components.vectors.Velocity;
import games.slatch.entities.Entity;
import games.slatch.singletons.Actions;
import games.slatch.singletons.Animations;

public class Input implements Manager
{
	Controller controller;
	Velocity velocity;
	DynamicSprite sprite;

	private float speed = 0.1f;

	@Override
	public void processEntity(Entity e, World world)
	{
		controller = (Controller) e.getComp(Controller.class);
		velocity = (Velocity) e.getComp(Velocity.class);

		if (e.hasComp(DynamicSprite.class))
			sprite = (DynamicSprite) e.getComp(DynamicSprite.class);

		if (isPressed(controller, Actions.walkRight))
		{
			
			velocity.add(speed, 0);

			if (sprite != null)
			{
				sprite.currentAnimation = Animations.walkRight;
				//sprite.framesPerImage = (int) (1/(velocity.x* 5));
			}
			
			

		}

		if (isPressed(controller, Actions.walkLeft))
		{
			
			velocity.add(-speed, 0);

			if (sprite != null)
			{
				sprite.currentAnimation = Animations.walkLeft;
			}
		}

		if (!Gdx.input.isKeyPressed(Keys.ANY_KEY))
			// WHERES THE ANY KEY
			if (sprite != null)
				sprite.currentAnimation = Animations.idle;
	}

	@Override
	public boolean canProcess(Entity e)
	{
		return e.hasComp(Velocity.class);
	}

	private boolean isPressed(Controller c, Actions action)
	{
		return Gdx.input.isKeyPressed(c.keyMap.findKey(action, true, -2));
	}

}
