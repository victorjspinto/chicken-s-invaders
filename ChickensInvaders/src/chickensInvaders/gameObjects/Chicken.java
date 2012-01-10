package chickensInvaders.gameObjects;

import chickensInvaders.util.ChickensInvadersConstants;
import chickensInvaders.util.MathUtils;
import customFramework.behavior.damage.IDamageableBehavior;
import customFramework.gameObject.AnimatedObject;
import customFramework.gameWindow.Game;
import customFramework.util.Point;
import customFramework.util.Side;

public class Chicken extends AnimatedObject implements IDamageableBehavior
{
	int totalHealh;
	int type;

	public Chicken(int type)
	{
		super(ChickensInvadersConstants.SPRITE_CHICKEN, 3.5f, 7, 54, 43, true);
		this.type = type;
	}

	public Chicken(Point position, int type)
	{
		super(ChickensInvadersConstants.SPRITE_CHICKEN, 3.5f, 7, 54, 43, true);

		this.setPosition(position);
		this.setSize(new Point(54, 43));
		this.totalHealh = 1;
		this.type = type;
	}

	@Override
	public void Update(float gameTime)
	{
		if (MathUtils.Random(0, 2000) == 50 * type)
		{
			Egg egg = new Egg(Side.HORDER, 8);

			egg.getPosition().set_x(getPosition().get_x() + 10);
			egg.getPosition().set_y(getPosition().get_y() + getSize().get_y());
			Game.GetGame().GetObjectsOnScreen().add(egg);
		}

		super.Update(gameTime);
	}

	@Override
	public Side getSide()
	{
		return Side.HORDER;
	}

	@Override
	public void setSide(Side side)
	{

	}

	@Override
	public int getTotalHeath()
	{
		return totalHealh;
	}

	@Override
	public void performDamage(int damageQuantity)
	{
		totalHealh -= damageQuantity;
		if (totalHealh <= 0)
			if (MathUtils.Random(1, 10) != 5)
				Game.GetGame().GetObjectsOnScreen()
						.add(new Coxinha(this.getPosition().Clone()));
			else
				Game.GetGame().GetObjectsOnScreen()
						.add(new Prize(this.getPosition().Clone()));

	}
}
