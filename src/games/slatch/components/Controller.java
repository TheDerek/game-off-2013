package games.slatch.components;

import games.slatch.singletons.KeyStrokes;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.ObjectMap;

public class Controller implements Component{

	public ObjectMap<Integer, KeyStrokes> keys;
	
	public void setupController(){
		keys = new ObjectMap<>();
		keys.put(Keys.A, KeyStrokes.leftPressed);
		keys.put(Keys.D, KeyStrokes.rightPressed);
		keys.put(Keys.W, KeyStrokes.upPressed);
		keys.put(Keys.S, KeyStrokes.downPressed);
		
		keys.put(Keys.LEFT, KeyStrokes.leftPressed);
		keys.put(Keys.RIGHT, KeyStrokes.rightPressed);
		keys.put(Keys.UP, KeyStrokes.upPressed);
		keys.put(Keys.DOWN, KeyStrokes.downPressed);
		
	} 
	
}
