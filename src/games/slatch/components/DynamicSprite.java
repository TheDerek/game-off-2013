package games.slatch.components;

import games.slatch.singletons.Animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;

public class DynamicSprite implements Component
{
	private ObjectMap<Animations, TextureRegion[]> animations;
	
	public int currentTime = 0;
	public int framesPerImage = 5;
	public Animations currentAnimation = Animations.idle;
	
	public DynamicSprite(ObjectMap<Animations, String> locations)
	{
		animations = new ObjectMap<>();
		
		for(String s : locations.values())
		{
			FileHandle folder = Gdx.files.internal(s);
			FileHandle files[] = folder.list();
			TextureRegion[] animation = new TextureRegion[files.length];
			
			for(int x = 0; x < files.length-1; x++)
			{
				animation[x] = new TextureRegion(new Texture(files[x]));
			}
			
			animations.put(locations.findKey(s, false), animation);
		}
	}
	
	public DynamicSprite(TextureRegion... region)
	{
		animations = new ObjectMap<>();
		animations.put(Animations.idle, region);
	}
	
	public static DynamicSprite create(String location)
	{
		ObjectMap<Animations, String> temp = new ObjectMap<>();
		temp.put(Animations.idle, location);
		return new DynamicSprite(temp);
	}
	
	public TextureRegion getImage(Animations animation, int time)
	{
		int frame = currentTime / framesPerImage;
		if(frame > animations.get(animation).length - 1)
		{
			frame = currentTime = 0;
		}
		
		System.out.println(frame);
		TextureRegion image = animations.get(animation)[frame];
		return image;
	}

}
