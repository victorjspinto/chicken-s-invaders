package chickensInvaders.gameObjects;

import chickensInvaders.util.ChickensInvadersConstants;
import customFramework.behavior.damage.IDamageBehavior;
import customFramework.util.BasicMoveObject;
import customFramework.util.Point;
import customFramework.util.Rectangle;
import customFramework.util.Side;

public class Shot extends BasicMoveObject implements IDamageBehavior
{
	private int shotType;

	public Shot(int shotType, Point direction, int velocity)
	{
		super(ChickensInvadersConstants.SPRITE_SHOT, direction, velocity);
		this.shotType = shotType;
		this.setSize(new Point(11, 21));
	}

	@Override
	public void Draw(float gameTime)
	{
		Rectangle targetWindowLocation;
		Rectangle sourceImageLocation;

		targetWindowLocation = new Rectangle(getPosition().Clone(), getSize()
				.Clone());
		sourceImageLocation = new Rectangle(shotType * 11, 0, 11, 21);

		super.Draw(gameTime, targetWindowLocation, sourceImageLocation);
	}

	
	
	@Override
	public void setSide(Side side)
	{
		
	}

	@Override
	public Side getSide()
	{
		return Side.ALLIANCE;
	}

	@Override
	public int getDamageQuantity()
	{
		return 1;
	}
}
