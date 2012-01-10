package chickensInvaders.gameObjects;

import chickensInvaders.util.ChickensInvadersConstants;
import customFramework.behavior.IBonus;
import customFramework.behavior.IPlayer;
import customFramework.behavior.move.NoMovementBehavior;
import customFramework.behavior.move.SimpleMovementBehavior;
import customFramework.gameObject.BaseMoveObject;
import customFramework.gameWindow.Game;
import customFramework.util.Point;
import customFramework.util.Rectangle;

public class Coxinha extends BaseMoveObject implements IBonus
{
	private static final int COXINHA_VELOCITY = 10;
	private static final int COXINHA_SCORE = 10;
	private int coxinhaState;
	private int deleteCoxinha = 0;

	public Coxinha(Point position)
	{
		super(ChickensInvadersConstants.SPRITE_MISCELLANEOUS);
		super.setSize(new Point(33, 21));
		this.setMovementBahavior(new SimpleMovementBehavior(new Point(0, 1),
				COXINHA_VELOCITY));
		this.setPosition(position);
		this.coxinhaState = 0;
	}

	@Override
	public void Draw(float gameTime)
	{
		Draw(gameTime, new Rectangle(getPosition(), getSize()), new Rectangle(
				new Point(66, 0), new Point(33, 21)));
	}

	@Override
	public void Update(float gameTime)
	{
		if (getPosition().get_y() > 560)
		{
			coxinhaState = 1;
			getPosition().set_y(580);
			this.setMovementBahavior(new NoMovementBehavior());
		}

		if (coxinhaState == 1)
			deleteCoxinha++;
		if (deleteCoxinha == 20)
			Game.GetGame().GetObjectsOnScreen().remove(this);

		super.Update(gameTime);
	}

	@Override
	public void performBonus(IPlayer player)
	{
		player.addScore(COXINHA_SCORE);
	}
}
