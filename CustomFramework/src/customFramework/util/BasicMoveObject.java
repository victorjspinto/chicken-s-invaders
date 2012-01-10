package customFramework.util;

import customFramework.gameObject.BaseObject;

public class BasicMoveObject extends BaseObject
{

	public Point getDirection()
	{
		return Direction;
	}

	public void setDirection(Point direction)
	{
		Direction = direction;
	}

	public int getVelocity()
	{
		return Velocity;
	}

	public void setVelocity(int velocity)
	{
		Velocity = velocity;
	}

	Point Direction;
	int Velocity;

	public BasicMoveObject(String fileName, Point direction,
			int velocity)
	{
		super(fileName);
		this.Direction = direction;
		this.Velocity = velocity;
	}

	@Override
	public void Update(float gameTime)
	{
		super.Update(gameTime);
		
		this.getPosition().set_x(this.getPosition().get_x() + ( Direction.get_x() * Velocity));
		this.getPosition().set_y(this.getPosition().get_y() + ( Direction.get_y() * Velocity));
	}
}
