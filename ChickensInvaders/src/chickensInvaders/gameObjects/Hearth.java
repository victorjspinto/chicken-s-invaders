package chickensInvaders.gameObjects;

import chickensInvaders.util.ChickensInvadersConstants;
import customFramework.gameObject.BaseObject;
import customFramework.util.Point;
import customFramework.util.Rectangle;

public class Hearth extends BaseObject
{

	public Hearth()
	{
		super(ChickensInvadersConstants.SPRITE_MISCELLANEOUS);
	}

	public Hearth(Point position)
	{
		super(ChickensInvadersConstants.SPRITE_MISCELLANEOUS);
		this.setPosition(position);
		this.setSize(new Point(33, 21));
	}

	@Override
	public void Draw(float gameTime)
	{
		super.Draw(gameTime, new Rectangle(getPosition(), getSize()),
				new Rectangle(new Point(33, 0), new Point(33, 21)));
	}

}
