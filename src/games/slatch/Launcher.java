package games.slatch;



import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher
{
	public static void main(String args[])
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 640;
		config.height = 480;
		config.useGL20 = false;
		config.fullscreen = false;
		config.title = "Game";
		config.vSyncEnabled = true;
		config.samples = 0;
		
		LwjglApplication app = new LwjglApplication(new Main(), config);
		
	}

}
