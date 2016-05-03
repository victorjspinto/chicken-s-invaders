package chickensInvaders.gameObjects;

import chickensInvaders.gameObjects.shot.QuintupleShotBehavior;
import chickensInvaders.gameObjects.shot.SimpleShotBehavior;
import chickensInvaders.gameObjects.shot.TripleShotBehavior;
import chickensInvaders.util.ChickensInvadersConstants;
import customFramework.behavior.IBonus;
import customFramework.behavior.IPlayer;
import customFramework.behavior.move.SimpleMovementBehavior;
import customFramework.gameObject.BaseMoveObject;
import customFramework.util.Point;

public class Prize extends BaseMoveObject implements IBonus
{
	private static final int PRIZE_VELOCITY = 6;

	public Prize(Point position)
	{
		super(ChickensInvadersConstants.SPRITE_PRIZE);
		this.setMovementBahavior(new SimpleMovementBehavior(new Point(0, 1),
				PRIZE_VELOCITY));
		this.setPosition(position);
	}

	@Override
	public void performBonus(IPlayer player)
	{

		if (((Nave) player).shotBehavior instanceof SimpleShotBehavior)
		{
			((Nave) player).shotBehavior = new TripleShotBehavior();
		} else if (((Nave) player).shotBehavior instanceof TripleShotBehavior)
		{
			((Nave) player).shotBehavior = new QuintupleShotBehavior();
		} else
		{
			player.addScore(1000);
		}

	}

}
