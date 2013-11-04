package games.slatch.singletons;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.IntMap;


public class KeyMaps
{
	private static KeyMaps keyMap;
	public IntMap<Actions> player1;
	
	public static KeyMaps getInstance()
	{
		if(keyMap == null)
			keyMap = new KeyMaps();
		
		return keyMap;
	}
	
	private KeyMaps()
	{
		player1 = new IntMap<>();
		player1.put(Keys.D, Actions.walkRight);
		player1.put(Keys.A, Actions.walkLeft);
		player1.put(Keys.SPACE, Actions.jump);
	}

}
