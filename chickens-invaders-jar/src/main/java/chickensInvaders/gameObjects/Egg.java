package chickensInvaders.gameObjects;

import chickensInvaders.util.ChickensInvadersConstants;
import customFramework.behavior.damage.IDamageBehavior;
import customFramework.gameWindow.Game;
import customFramework.util.BasicMoveObject;
import customFramework.util.Point;
import customFramework.util.Rectangle;
import customFramework.util.Side;

public class Egg extends BasicMoveObject implements IDamageBehavior
{
	Rectangle egg = new Rectangle(99, 0, 33, 21);
	Rectangle brokenEgg = new Rectangle(0, 0, 33, 21);
	Side side;
	
	int deleteEgg = 0;
	int EggState;

	public Egg(Side side, int velocity)
	{
		super(ChickensInvadersConstants.SPRITE_MISCELLANEOUS, new Point(
				0, 1), velocity);
		this.setSize(new Point(33, 21));
		EggState = 0;
		this.side = side;
	}

	@Override
	public void Update(float gameTime)
	{
		if (getPosition().get_y() > 560)
		{
			getPosition().set_y(580);
			setVelocity(0);
			setDirection(Point.Zero());
			EggState = 1;
		}

		if (EggState == 1)
			deleteEgg++;
		if (deleteEgg == 20)
			Game.GetGame().GetObjectsOnScreen().remove(this);

		super.Update(gameTime);
	}

	@Override
	public void Draw(float gameTime)
	{
		Rectangle targetWindowLocation = new Rectangle(getPosition(), getSize());
		Rectangle sourceImageLcation;
		if (EggState == 0)
		{
			sourceImageLcation = egg;
		} else
		{
			sourceImageLcation = brokenEgg;
		}

		super.Draw(gameTime, targetWindowLocation, sourceImageLcation);
	}

	@Override
	public int getDamageQuantity()
	{
		return 100;
	}

	@Override
	public void setSide(Side side)
	{
		this.side = side;
	}

	@Override
	public Side getSide()
	{
		return side;
	}
}
