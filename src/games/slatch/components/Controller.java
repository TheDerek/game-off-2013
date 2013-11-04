package games.slatch.components;

import games.slatch.singletons.Actions;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.ObjectMap;

public class Controller implements Component
{

	public IntMap<Actions> keyMap;
	
	public Controller(IntMap<Actions> keyMap)
	{
		this.keyMap = keyMap;
	}
	
}
