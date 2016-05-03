package customFramework.util;

public class Point
{
	double _x;

	double _y;

	public double get_x()
	{
		return _x;
	}

	public void set_x(double _x)
	{
		this._x = _x;
	}

	public double get_y()
	{
		return _y;
	}

	public void set_y(double _y)
	{
		this._y = _y;
	}

	public Point(double x, double y)
	{
		this._x = x;
		this._y = y;
	}

	public static Point Zero()
	{
		return new Point(0, 0);
	}

	public Point MultiplyByScalar(int value)
	{
		this._x *= value;
		this._y *= value;
		return this;
	}

	public Point Sum(Point vector)
	{
		this._x += vector._x;
		this._y += vector._y;
		return this;
	}

	public Point Clone()
	{
		return new Point(_x, _y);
	}
}
