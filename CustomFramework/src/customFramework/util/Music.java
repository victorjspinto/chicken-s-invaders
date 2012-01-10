package customFramework.util;

import jplay.Sound;

public class Music
{

	jplay.Sound sound;
	
	public Music(String fileName)
	{
		sound = new Sound(fileName);
	}
	
	public void PerformSound()
	{
		sound.play();
	}
	
}
