package chickensInvaders.gameObjects.shot;

import chickensInvaders.gameObjects.Shot;
import customFramework.gameWindow.Game;
import customFramework.util.Point;

public class SimpleShotBehavior implements IShotBehavior
{

	@Override
	public void PerformShot(Point position, Point Direction)
	{
		Shot shot = new Shot(2, Direction, 8);
		shot.setPosition(position);
		Game.GetGame().GetObjectsOnScreen().add(shot);
	}
}
