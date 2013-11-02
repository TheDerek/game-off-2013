package games.slatch.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StaticSprite implements Component
{
	private TextureRegion region;
	
	public StaticSprite(TextureRegion region)
	{
		this.region = region;
	}
	
	public StaticSprite(String location)
	{
		region = new TextureRegion(new Texture(Gdx.files.internal(location)));
	}

	public TextureRegion getRegion()
	{
		return region;
	}

}
