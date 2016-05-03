package customFramework.gameWindow;

import java.util.ArrayList;
import java.util.List;

import customFramework.behavior.IBaseObject;
import customFramework.behavior.IBonus;
import customFramework.behavior.IPlayer;
import customFramework.behavior.damage.IDamageBehavior;
import customFramework.behavior.damage.IDamageableBehavior;
import customFramework.gameObject.BaseObject;
import customFramework.util.Point;
import customFramework.util.Rectangle;

import jplay.Window;;

public abstract class Game
{
	Window gameWindow;

	boolean exit = Boolean.FALSE;

	List<IBaseObject> objectsOnScreen;
	IPlayer currentPlayer;

	BaseObject background;

	public Game(int heigth, int width, IPlayer player)
	{
		gameWindow = new Window(heigth, width);

		objectsOnScreen = new ArrayList<IBaseObject>();
		Game.CurrentInstance = this;
		this.currentPlayer = player;
		this.objectsOnScreen.add(player);
		Initialize();
		Run();
	}

	static Game CurrentInstance;

	public static Game GetGame()
	{
		return CurrentInstance;
	}

	public Window GetWindow()
	{
		return gameWindow;
	}

	public List<IBaseObject> GetObjectsOnScreen()
	{
		return objectsOnScreen;
	}

	public IPlayer getCurrentPlayer()
	{
		return this.currentPlayer;
	}

	public BaseObject getBackground()
	{
		return background;
	}

	public void setBackground(BaseObject background)
	{
		this.background = background;
	}

	private void Run()
	{
		float gameTime = 0.1f;

		while (!exit)
		{
			gameWindow.delay(33);
			gameWindow.update();
			if (background != null)
				background.Update(gameTime);
			if (background != null)
				background.Draw(gameTime);
			this.Update(gameTime);
			this.CheckDamage();
			this.CheckBonus();
			this.CheckLostObject();
			this.Draw(gameTime);
			gameTime += 0.33f;
		}
	}

	protected void CheckLostObject()
	{
		for (BaseObject obj : GetObjectsOnScreen().toArray(new BaseObject[0]))
			if (!obj.getBoundingArea().intersects(
					new Rectangle(new Point(-100, -100), 900, 700)))
			{
				this.GetObjectsOnScreen().remove(obj);
			}
	}

	protected void CheckBonus()
	{
		for (BaseObject obj : GetObjectsOnScreen().toArray(new BaseObject[0]))
			if (obj instanceof IBonus
					&& obj.getBoundingArea().intersects(
							getCurrentPlayer().getBoundingArea()))
			{
				((IBonus) obj).performBonus(getCurrentPlayer());
				GetObjectsOnScreen().remove(obj);
			}
	}

	protected void CheckDamage()
	{
		for (BaseObject projetil : GetObjectsOnScreen().toArray(
				new BaseObject[0]))
			if (projetil instanceof IDamageBehavior)
				for (BaseObject alvo : GetObjectsOnScreen().toArray(
						new BaseObject[0]))
					if (alvo instanceof IDamageableBehavior)
					{
						if (projetil.getBoundingArea().intersects(
								alvo.getBoundingArea())
								&& ((IDamageableBehavior) alvo).getSide() != ((IDamageBehavior) projetil)
										.getSide())
						{
							((IDamageableBehavior) alvo)
									.performDamage(((IDamageBehavior) projetil)
											.getDamageQuantity());
							this.GetObjectsOnScreen().remove(projetil);
							if (((IDamageableBehavior) alvo).getTotalHeath() <= 0)
								this.GetObjectsOnScreen().remove(alvo);
						}
					}
	}

	public void Exit()
	{
		this.exit = Boolean.TRUE;
	}

	public abstract void Initialize();

	public abstract void Draw(float gameTime);

	public abstract void Update(float gameTime);
}
