package chickensInvaders.util;

public class MathUtils
{
	public static int Random(int minValue, int maxValue)
	{
		return (int) ((Math.random() * ((maxValue + 1) - minValue)) + minValue);
	}
}
