package chickensInvaders.gameObjects;

import chickensInvaders.gameObjects.shot.IShotBehavior;
import chickensInvaders.gameObjects.shot.SimpleShotBehavior;
import chickensInvaders.util.ChickensInvadersConstants;
import customFramework.behavior.IPlayer;
import customFramework.behavior.damage.IDamageableBehavior;
import customFramework.gameObject.BaseObject;
import customFramework.input.InputManager;
import customFramework.util.Point;
import customFramework.util.Rectangle;
import customFramework.util.Side;

public class Nave extends BaseObject implements IDamageableBehavior, IPlayer
{
	static final int BEGIN_NAVE_HEALTH = 1;
	static final int BEGIN_NAVE_LIFE = 3;
	static final int BEGIN_NAVE_POINT = 0;
	static final Point BEGIN_POSITION = new Point(378, 535);

	int totalheath;
	int totalLifes;
	int totalPoints;

	IShotBehavior shotBehavior;

	public Nave(Point position)
	{
		super(ChickensInvadersConstants.SPRITE_NAVE);
		this.setPosition(position);
		Initialize();
	}

	public Nave()
	{
		super(ChickensInvadersConstants.SPRITE_NAVE);
		Initialize();
	}

	private void Initialize()
	{
		this.setPosition(BEGIN_POSITION.Clone());
		this.setSize(new Point(45, 43));
		this.setShot(new SimpleShotBehavior());
		this.totalheath = BEGIN_NAVE_HEALTH;
		this.totalLifes = BEGIN_NAVE_LIFE;
		this.totalPoints = BEGIN_NAVE_POINT;
	}

	public IShotBehavior getShotBehavior()
	{
		return shotBehavior;
	}

	@Override
	public void Update(float gameTime)
	{
		super.Update(gameTime);

		this.getPosition().Sum(
				InputManager.getInput().GetDirection().MultiplyByScalar(10));

		if (this.getPosition().get_x() > (ChickensInvadersConstants.WINDOW_WIDTH - this
				.getSize().get_x()))
		{
			this.getPosition().set_x(
					(ChickensInvadersConstants.WINDOW_WIDTH - this.getSize()
							.get_x()));
		} else if (this.getPosition().get_x() < (0))
		{
			this.getPosition().set_x(0);
		}

		if (this.getPosition().get_y() > ChickensInvadersConstants.WINDOW_HIGHT
				- this.getSize().get_y() - 20)
		{
			this.getPosition().set_y(
					ChickensInvadersConstants.WINDOW_HIGHT
							- this.getSize().get_y() - 20);
		} else if (this.getPosition().get_y() < 0)
		{
			this.getPosition().set_y(0);
		}

		if (InputManager.getInput().GetAction1State())
		{
			this.shotBehavior.PerformShot(this.getPosition().Clone(),
					new Point(0, -1));
		}
	}

	@Override
	public void Draw(float gameTime)
	{
		super.Draw(gameTime, new Rectangle(this.getPosition(), this.getSize()),
				new Rectangle(new Point(0, 0), new Point(43, 45)));
	}

	private void setShot(IShotBehavior ShotBehavior)
	{
		this.shotBehavior = ShotBehavior;
	}

	@Override
	public void performDamage(int damageQuantity)
	{
 		this.totalheath -= damageQuantity;
		if (this.totalheath < 0)
		{
			this.totalLifes--;
			if(totalLifes > 0)
						this.totalheath = BEGIN_NAVE_HEALTH;
			this.setPosition(BEGIN_POSITION);
		}
			
	}

	@Override
	public int getTotalHeath()
	{
		return this.totalheath;
	}

	@Override
	public int getLife()
	{
		return this.totalLifes;
	}

	@Override
	public void addLife()
	{
		this.totalLifes++;
	}

	@Override
	public int getScore()
	{
		return this.totalPoints;
	}

	@Override
	public void addScore()
	{
		this.totalPoints++;
	}

	@Override
	public void addScore(int value)
	{
		this.totalPoints += value;
	}

	@Override
	public void removeLife()
	{
		this.totalLifes--;
	}

	@Override
	public Side getSide()
	{
		return Side.ALLIANCE;
	}

	@Override
	public void setSide(Side side)
	{

	}
}
