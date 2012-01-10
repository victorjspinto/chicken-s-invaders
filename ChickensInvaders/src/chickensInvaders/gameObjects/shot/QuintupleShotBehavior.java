package chickensInvaders.gameObjects.shot;

import chickensInvaders.gameObjects.Shot;
import customFramework.gameWindow.Game;
import customFramework.util.Point;

public class QuintupleShotBehavior implements IShotBehavior
{

	@Override
	public void PerformShot(Point position, Point Direction)
	{
		Shot shot1 = new Shot(1, new Point(-.3, -1), 8);
		Shot shot2 = new Shot(3, new Point(.3, -1), 8);
		Shot shot3 = new Shot(2, new Point(0, -1), 8);
		Shot shot4 = new Shot(0, new Point(-.5, -1), 8);
		Shot shot5 = new Shot(4, new Point(.5, -1), 8);
		shot1.setPosition(position.Clone());
		shot2.setPosition(position.Clone());
		shot3.setPosition(position.Clone());
		shot4.setPosition(position.Clone());
		shot5.setPosition(position.Clone());
		Game.GetGame().GetObjectsOnScreen().add(shot1);
		Game.GetGame().GetObjectsOnScreen().add(shot2);
		Game.GetGame().GetObjectsOnScreen().add(shot3);
		Game.GetGame().GetObjectsOnScreen().add(shot4);
		Game.GetGame().GetObjectsOnScreen().add(shot5);		
	}

}
