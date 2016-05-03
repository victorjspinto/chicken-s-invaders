package chickensInvaders.gameObjects.shot;

import customFramework.util.Point;

public interface IShotBehavior
{
	void PerformShot(Point position, Point Direction);
}
