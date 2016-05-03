package customFramework.util;

import jplay.Collision;

public class Rectangle
{
	double _x;
	double _y;
	double _width;
	double _height;

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

	public double get_width()
	{
		return _width;
	}

	public void set_width(double _width)
	{
		this._width = _width;
	}

	public double get_height()
	{
		return _height;
	}

	public void set_height(double _height)
	{
		this._height = _height;
	}

	public Rectangle(double x, double y, double width, double height)
	{
		this._x = x;
		this._y = y;
		this._width = width;
		this._height = height;
	}

	public Rectangle(Point position, double width, double height)
	{
		this._x = position._x;
		this._y = position._y;
		this._width = width;
		this._height = height;
	}

	public Rectangle(Point position, Point size)
	{
		this._x = position._x;
		this._y = position._y;
		this._width = size._x;
		this._height = size._y;
	}

	public String toString()
	{
		return "Rectangle X:" + this._x + "Y:" + this._y + "W:" + this._width
				+ "H" + this._height;
	}

	public Rectangle Clone()
	{
		return new Rectangle(this._x, this._y, this._width, this._height);
	}

	public boolean intersects(Rectangle anotherRectangle)
	{
		java.awt.Point min1 = new java.awt.Point((int) _x, (int) _y);
		java.awt.Point max1 = new java.awt.Point((int) (_x + _width),
				(int) (_y + _height));

		java.awt.Point min2 = new java.awt.Point((int) anotherRectangle._x,
				(int) anotherRectangle._y);
		java.awt.Point max2 = new java.awt.Point(
				(int) (anotherRectangle._x + anotherRectangle._width),
				(int) (anotherRectangle._y + anotherRectangle._height));

		return jplay.Collision.collided(min1, max1, min2, max2);
	}
}

// soudev11con