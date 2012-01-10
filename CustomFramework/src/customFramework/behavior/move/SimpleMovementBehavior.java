package customFramework.behavior.move;

import customFramework.util.Point;

public class SimpleMovementBehavior implements IMovementBehavior
{
	Point direction;
	int velocity;

	public SimpleMovementBehavior(Point direction, int velocity)
	{
		this.direction = direction;
		this.velocity = velocity;
	}

	public Point performMovement()
	{
		return direction.Clone().MultiplyByScalar(velocity);
	}
}
