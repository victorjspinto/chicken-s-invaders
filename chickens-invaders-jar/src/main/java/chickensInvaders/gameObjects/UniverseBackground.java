package chickensInvaders.gameObjects;

import java.util.ArrayList;
import java.util.List;

import chickensInvaders.util.ChickensInvadersConstants;
import chickensInvaders.util.MathUtils;
import customFramework.gameObject.BaseObject;
import customFramework.util.BasicImage;
import customFramework.util.Point;

public class UniverseBackground extends BaseObject
{
	List<BaseObject> repeatedBackground;
	List<Planet> planets;
	List<Integer> currentPlanet = new ArrayList<Integer>();

	public UniverseBackground()
	{
		super(ChickensInvadersConstants.SPRITE_BACKGROUND);
		Initialize();
	}

	public void Initialize()
	{
		this.repeatedBackground = new ArrayList<BaseObject>();
		this.planets = new ArrayList<Planet>();

		for (int line = 0; line < 20; line++)
		{
			for (int column = 0; column < 18; column++)
			{
				BasicImage image = new BasicImage(
						ChickensInvadersConstants.SPRITE_BACKGROUND);
				image.setPosition(new Point(line * 40, (column * 40) - 40));
				repeatedBackground.add(image);
			}
		}

		randomNewPlanet(true, -100);
		randomNewPlanet(true, -500);
		randomNewPlanet(false, -100);
		randomNewPlanet(false, -500);

	}

	@Override
	public void Update(float gameTime)
	{
		for (BaseObject item : repeatedBackground)
		{
			item.Update(gameTime);
			item.getPosition().set_y(item.getPosition().get_y() + 1);
			if (item.getPosition().get_y() == 650)
			{
				item.getPosition().set_y(-70);
			}
		}

		for (Planet item : planets.toArray(new Planet[0]))
		{
			if (item.getPosition().get_y() > 640)
			{
				planets.remove(item);
				currentPlanet.remove((Object) item.getPlanetCode());
				randomNewPlanet(item.getPosition().get_x() < (400 - item
						.getSize().get_x()));
				continue;
			}
			item.Update(gameTime);
		}
	}

	private void randomNewPlanet(boolean left)
	{
		int size = MathUtils.Random(60, 100);
		Point newSize = new Point(size, size);

		Point newPosition = new Point(MathUtils.Random(40, 400 - size), size
				* -1);
		if (!left)
			newPosition.set_x(newPosition.get_x() + 400);

		Planet planet = new Planet(new Point(0, 1), 4, UniquePlanet());
		planet.setSize(newSize);
		planet.setPosition(newPosition);

		planets.add(planet);
	}

	private void randomNewPlanet(boolean left, int hight)
	{
		int size = MathUtils.Random(60, 100);
		Point newSize = new Point(size, size);

		Point newPosition = new Point(MathUtils.Random(40, 400 - size), hight);
		if (!left)
			newPosition.set_x(newPosition.get_x() + 400);

		Planet planet = new Planet(new Point(0, 1), 4, UniquePlanet());
		planet.setSize(newSize);
		planet.setPosition(newPosition);

		planets.add(planet);
	}

	private int UniquePlanet()
	{
		int x;
		do
		{
			x = MathUtils.Random(0, 7);
		} while (this.currentPlanet.contains(x));
		currentPlanet.add(x);
		return x;
	}

	@Override
	public void Draw(float gameTime)
	{
		for (BaseObject item : repeatedBackground)
		{
			item.Draw(gameTime);
		}

		for (BaseObject item : planets)
		{
			item.Draw(gameTime);
		}
	}
}
