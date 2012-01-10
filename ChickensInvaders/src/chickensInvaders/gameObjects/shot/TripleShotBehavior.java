package chickensInvaders.gameObjects.shot;

import chickensInvaders.gameObjects.Shot;
import customFramework.gameWindow.Game;
import customFramework.util.Point;

public class TripleShotBehavior implements IShotBehavior
{

	@Override
	public void PerformShot(Point position, Point Direction)
	{
		Shot shot1 = new Shot(1, new Point(-.3, -1), 8);
		Shot shot2 = new Shot(3, new Point(.3, -1), 8);
		Shot shot3 = new Shot(2, new Point(0, -1), 8);
		shot1.setPosition(position.Clone());
		shot2.setPosition(position.Clone());
		shot3.setPosition(position.Clone());
		Game.GetGame().GetObjectsOnScreen().add(shot1);
		Game.GetGame().GetObjectsOnScreen().add(shot2);
		Game.GetGame().GetObjectsOnScreen().add(shot3);
	}

}
