package customFramework.behavior.move;

import customFramework.util.Point;

public class NoMovementBehavior implements IMovementBehavior
{

	@Override
	public Point performMovement()
	{
		return new Point(0, 0);
	}

}
