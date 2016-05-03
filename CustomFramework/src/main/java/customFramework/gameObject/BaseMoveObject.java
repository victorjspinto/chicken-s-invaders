package customFramework.gameObject;

import customFramework.behavior.move.IMovementBehavior;
import customFramework.behavior.move.NoMovementBehavior;

public class BaseMoveObject extends BaseObject
{
	private IMovementBehavior movementBahavior;

	public IMovementBehavior getMovementBahavior()
	{
		return movementBahavior;
	}

	public void setMovementBahavior(IMovementBehavior movementBahavior)
	{
		this.movementBahavior = movementBahavior;
	}

	public BaseMoveObject(String fileName)
	{
		super(fileName);
		this.movementBahavior = new NoMovementBehavior();
	}

	@Override
	public void Update(float gameTime)
	{
		this.Position.Sum(this.movementBahavior.performMovement());

		super.Update(gameTime);
	}

}
