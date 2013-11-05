package games.slatch.singletons;

public enum Animations
{
	idle 		("idleRight", false, false),
	idleRight	("idleLeft", true, false),
	idleLeft	("idleRight", true, false),
	walkRight	("walkLeft", true, false),
	jump		(),
	walkLeft	("walkRight", true, false),
	fallLeft	("fallRight", true, false),
	fallRight	("fallLeft", true, false);
	
	Animations(String alt, boolean flipX, boolean flipY)
	{
		this.alt = alt;
		this.flipX = flipX;
		this.flipY = flipY;
	}
	
	Animations()
	{
		
	}
	
	/**Alternative animation for when the chosen animation
	is not available**/
	private String alt = "idle";
	public boolean flipX = false;
	public boolean flipY = false;

	public Animations getAlt()
	{
		return Animations.valueOf(alt);
	}

}
