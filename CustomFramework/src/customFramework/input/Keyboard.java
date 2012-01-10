package customFramework.input;

import customFramework.gameWindow.Game;
import customFramework.util.Point;

public class Keyboard implements InputDecive
{
	@Override
	public Point GetDirection()
	{
		Point result = new Point(0, 0);
		if (Game.GetGame().GetWindow().getKeyboard()
				.keyDown(jplay.Keyboard.LEFT_KEY))
		{
			result.set_x(result.get_x() - 1);
		}
		if (Game.GetGame().GetWindow().getKeyboard()
				.keyDown(jplay.Keyboard.RIGHT_KEY))
		{
			result.set_x(result.get_x() + 1);
		}
		if (Game.GetGame().GetWindow().getKeyboard()
				.keyDown(jplay.Keyboard.UP_KEY))
		{
			result.set_y(result.get_y() - 1);
		}
		if (Game.GetGame().GetWindow().getKeyboard()
				.keyDown(jplay.Keyboard.DOWN_KEY))
		{
			result.set_y(result.get_y() + 1);
		}
		return result;
	}

	@Override
	public Boolean GetAction1State()
	{
		return Game.GetGame().GetWindow().getKeyboard()
				.keyDown(jplay.Keyboard.SPACE_KEY);
	}

}
