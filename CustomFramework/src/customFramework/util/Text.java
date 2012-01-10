package customFramework.util;

import java.awt.Color;

import customFramework.gameWindow.Game;

public class Text
{
	public static void DrawText(String text, Point position)
	{
		Game.GetGame()
				.GetWindow()
				.drawText(text, (int) position.get_x(), (int) position.get_y(),
						Color.BLUE);
	}
}
