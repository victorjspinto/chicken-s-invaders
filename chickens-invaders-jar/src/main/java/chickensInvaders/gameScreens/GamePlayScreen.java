package chickensInvaders.gameScreens;

import chickensInvaders.gameObjects.Chicken;
import chickensInvaders.gameObjects.Hearth;
import chickensInvaders.gameObjects.Nave;
import chickensInvaders.gameObjects.Shot;
import chickensInvaders.gameObjects.UniverseBackground;
import chickensInvaders.util.ChickensInvadersConstants;

import customFramework.gameObject.BaseObject;
import customFramework.gameWindow.Game;
import customFramework.util.Music;
import customFramework.util.Point;
import customFramework.util.Text;

public class GamePlayScreen extends Game
{
	int level = 1;
	int chickensCount = 0;

	public GamePlayScreen()
	{
		super(800, 600, new Nave());
	}

	@Override
	public void Draw(float arg0)
	{
		for (BaseObject obj : GetObjectsOnScreen().toArray(new BaseObject[0]))
			obj.Draw(arg0);

		for (int i = 0; i < super.getCurrentPlayer().getLife(); i++)
			new Hearth(new Point(20 * i, 0)).Draw(arg0);
		Text.DrawText(Integer.toString(super.getCurrentPlayer().getScore()),
				new Point(600, 30));
	}

	@Override
	public void Update(float arg0)
	{
		chickensCount = 0;
		for (BaseObject obj : GetObjectsOnScreen().toArray(new BaseObject[0]))
		{
			if (obj instanceof Chicken)
				chickensCount++;
			obj.Update(arg0);
		}
		if (chickensCount == 0)
		{
			initializeLevel2();
			level += 30;
		}
	}

	@Override
	public void Initialize()
	{
		this.initializeLevel1();
	}

	public void initializeLevel1()
	{
		this.setBackground(new UniverseBackground());
		for (int i = 0; i < 9; i = i + 2)
			for (int j = 0; j < 5; j = j + 2)
				GetObjectsOnScreen()
						.add(new Chicken(
								new Point(85 + (70 * i), 43 + (43 * j)), 1));

	}

	public void initializeLevel2()
	{
		for (Object obj : GetObjectsOnScreen().toArray(new BaseObject[0]))
			if (obj instanceof Shot)
				super.GetObjectsOnScreen().remove(obj);

		this.setBackground(new UniverseBackground());
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 5; j++)
				GetObjectsOnScreen().add(
						new Chicken(new Point(85 + (70 * i), 43 + (43 * j)),
								level));

	}

}
