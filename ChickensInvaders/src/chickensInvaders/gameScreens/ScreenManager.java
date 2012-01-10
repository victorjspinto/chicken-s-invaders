package chickensInvaders.gameScreens;

import java.util.HashMap;
import java.util.Map;

import customFramework.gameWindow.Game;

public class ScreenManager
{
	GameScreens currentScreen;

	Map<GameScreens, Game> screens;

	public ScreenManager()
	{
		currentScreen = GameScreens.NONE;
		screens = new HashMap<GameScreens, Game>();
		this.ChangeScreen(GameScreens.INTRO);
	}

	public void ChangeScreen(GameScreens nextScreen)
	{
		this.currentScreen = nextScreen;
		if(nextScreen == GameScreens.GAME)
		{
			screens.put(GameScreens.GAME, new GamePlayScreen());
		}
	}
	
	public void Draw(float arg0)
	{
		screens.get(currentScreen).Draw(arg0);
	}
	
	public void Update(float arg0)
	{
		screens.get(currentScreen).Update(arg0);
	}
}
