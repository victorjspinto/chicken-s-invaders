package chickensInvaders.gameObjects;

import chickensInvaders.util.ChickensInvadersConstants;
import customFramework.util.BasicMoveObject;
import customFramework.util.Point;

public class Planet extends BasicMoveObject
{
	private int planetCode;

	public int getPlanetCode()
	{
		return planetCode;
	}

	public void setPlanetCode(int planetCode)
	{
		this.planetCode = planetCode;
	}

	public Planet(Point direction, int velocity, int planetCode)
	{
		super(RandomPlanet(planetCode), direction, velocity);
		this.planetCode = planetCode;
	}

	private static String RandomPlanet(int planetCode)
	{
		switch (planetCode)
		{
			case 0:
				return ChickensInvadersConstants.SPRITE_PLANET_BLUE;
			case 1:
				return ChickensInvadersConstants.SPRITE_PLANET_GREEN;
			case 2:
				return ChickensInvadersConstants.SPRITE_PLANET_INFERNAL;
			case 3:
				return ChickensInvadersConstants.SPRITE_PLANET_PANTERDS;
			case 4:
				return ChickensInvadersConstants.SPRITE_PLANET_PINKFLOYDE;
			case 5:
				return ChickensInvadersConstants.SPRITE_PLANET_WARLORDS;
			case 6:
				return ChickensInvadersConstants.SPRITE_PLANET_EARTH;
			default:
				return ChickensInvadersConstants.SPRITE_PLANET_BLUE;
		}
	}
	public static int NumberOfPlanets()
	{
		return 7;
	}
}
